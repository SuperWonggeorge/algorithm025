# String

## 字符串基础

### 遍历字符串

- Python

  ```python
  for ch in "abc":
  	print(ch)
  ```

- Java

  ```java
  String x = "abc";
  for (int i = 0; i < x.size(); i++) {
  		char ch = x.charAt(i)
  }
  for ch in x.toCharArray() {
  	System.out.println(ch);
  }
  ```

### 字符串比较

- Java

  ==比较的是对象的地址，不是内容；equals和equalsIgnoreCase才是比较内容（和忽略大小写）

### 例题

1. Atoi

   老师的样例代码有问题，如果输入” “会报错，应该在trim字符串时先判断是否越界

2. 最长公共前缀

   水平对比

   ```java
   public String longestCommonPrefix(String[] strs) {
               if (strs == null || strs.length == 0) return "";
               for (int i = 0; i < strs[0].length(); i++) {
                   char c = strs[0].charAt(i);
                   for (int j = 1; j < strs.length; j++) {
                       if ( i == strs[j].length() || strs[j].charAt(i) != c) {
                           return strs[0].substring(0, i);
                       }
                   }
               }
               return strs[0];
           }
   ```

   Trie（待补充）

## 高级字符串应用

### 动态规划相关

**字符串类的动态规划题目，一般dp状态数组的长度都是字符串长度加1，原因是dp下标为0是表示空字符，不是表示第一个字符。空字符情况是要考虑的**

1. 最长公共子序列

   子序列和子串的区别是，子序列是有允许间隔

   dp[i][j] = dp[i-1][j-1] + 1 (if s1[i-1] == s2[i-1]) else max(dp[i-1][j], dp[i][j-1]

   ```python
   class Solution(object):
   	def longestCommonSubsequence(self, text1, test2):
   		if not text1 or not text2:
   			return 0
   		m = len(text1)
   		n = len(text2)
   		dp = [[0] * (n + 1) for _ in range(m + 1)]
   		for i in range(1, m + 1):
   			for j in range(1, n + 1):
   				if text1[i - 1] == text2[j - 1]:
   					dp[i][j] = 1 + dp[i - 1][j - 1]
   				else:
   					dp[i][j] = max(dp[i-1][j], dp[i][j-1])
   		return dp[m][n]
   ```

2. 最长公共子串（连续的）

   dp[i][j] = dp[i-1][j-1] + 1 if s1[i-1] = s2[j-1] else 0

3. 最长回文子串

   - 定义P(i, j)，如果s[i,j]是回文串，为true，不是为false
   - P(i,j ) = (P(i+1,j-1) && s[i] == s[j])

4. 正则表达式

   1. 递归

      - s为待匹配字串，p为模式pattern
      - firstmatch表示第一位是否匹配成功。如果p为空，s为空匹配成功；s不为空则匹配失败
      - 如果p[0] == s[0]或者p[0] == '.'，则firstmatch为真
      - 如果p有*，且p的长度大于2，p[1]为*，就有两种情况
        - 匹配串不匹配，就是*为0，则就要匹配s和p[2:]
        - 首位匹配成功firstmatch为真，则要匹配s[1:]和p（p带着首位字母和*继续做下一轮匹配）

   2. 记忆化搜索

      ```python
      def isMatch(test, pattern) -> bool:
      	memo = dict()
      	def dp(i, j):
      		if (i, j) in memo: return memo[(i,j)]
      		if j == len(pattern): return i == len(text)
      	
      		first = i < len(text) and pattern[j] in {text[i], '.'}
      		
      		if j <= len(pattern) - 2 and pattern[j + 1] == '*':
      			ans = dp(i, j + 2) or first and dp(i + 1, j)
      		else:
      			ans = first and dp(i + 1, j + 1)
      		memo[(i, j)] = ans
      		return ans
      	
      	return dp(0, 0)
      ```

   3. 动态规划递推（见作业）

5. 不同子序列

   - dp[i][j]表示T前i字符串可以由s前j字符串组成最多个数
   - 当S[j] == T[i]，dp[i][j] = dp[i-1][j-1] + dp[i][j-1]
   - 当S[j] ≠ T[j]，dp[i][j] = dp[i][j-1]

   ```java
   class Solution {
   	public int numDistinct(String s, String t) {
   		int[][] dp = new int[t.length() + 1][s.length() + 1];
   		for (int i = 0; i < s.length(); i++)
   			dp[0][i] = 1;
   		for (int i = 1; i <t.length() + 1; i++) {
   			for (int j = i; j < s.length() + 1; j++) {
   				if (t.charAt(i - 1) == s.charAt(j - 1)) {
   					dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
   				}
   				else {
   					dp[i][j] = dp[i][j - 1];
   				}
   			}
   		}
   		return dp[t.length()][s.length()];
   	}
   }
   ```

## 字符串匹配算法

### 常见算法

1. 暴力法 - O(mn)
2. 改进 - 用字串的hash来加速Rabin-Karp
3. KMP

### Rabin-Karp

为了避免挨个字符对目标字符串和子串进行比较，我们可以尝试一次性判断两者是否相等。因此我们需要有一个好的哈希函数，通过哈希函数，算出子串的哈希值，跟目标字符串中的子串的哈希值进行比较。

使用滑动窗口方法来更新hash值，保证每次算hash值是O(1)

```java
public final static int D = 256;
public final static int Q = 9997;

static int RabinKarpSearch(String txt, String pat) {
	int M = pat.length();
	int N = txt.length();
	int patHash = 0, txtHash = 0;

	for (int i = 0; i < M; i++) {
		patHash = (D * patHash + pat.charAt(i)) % Q;
		txtHash = (D * txtHash + txt.charAt(i)) % Q;
	}

	int highestPow = 1;
	for (i = 0; i < M - 1; i++) {
		highestPow = (highestPow * D) % Q;
	}

	for (i = 0; i <= N - M; i++) {
		if (patHash == txtHash) {
			for (j = 0; j < M; j++) {
				if (txt.charAt(i + j) != pat.charAt(j))
						break;
			}
			if (j == M)
				return i;
		}
		if (i < N - M) {
			txtHash = (D * (txtHash - txt.charAt(i) * highestPow) + txt.charAt(i + M) % Q;
			if (txtHash < 0)
				txtHash += Q;
		}
	}
}
```

### KMP算法

当子串与目标字符串不匹配时，设法利用这个已知信息，不要把搜索位置移回已经比较过的位置，继续向后移动，提高效率（还没理解）