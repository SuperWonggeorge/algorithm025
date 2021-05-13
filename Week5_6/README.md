## 本周作业

说明：作业摸版使用idea的LeetCode插件生成

### 中等

1. 最小路径和 

   - 最优子结构：每个格子的值等于上面或左边格子的最小值加上自身
   - 状态数组dp(i, j)表示到达第(i,j)个格子的最小值
   - 状态转移方程dp(i,j) = min(dp(i-1,j), dp(i, j-1)) + grid(i,j)
   - 时间复杂度为O(mn)

   https://github.com/Albertsirius/algorithm025/blob/main/Week5_6/MinimumPathSum.java

### 困难

1. 最长有效括号

   - 最优子结构：以每个字符作为右边界，以此到求最长的有效括号的长度：
     - 字符是"("：由于"("不能作右边界，有效括号长度为0
     - 如果字符是")"：分情况讨论：
       - 这个字符的上一个字符是"("，则有效括号长度为上两个字符的为上一个右边界的长度加2
       - 减去上一个字符是")"作为右边界的长度后，再下一个字符作为有边界的长度加上刚刚减去的长度再加2
   - 状态函数dp(i)表示以i为右边界的最长有效括号长度
   - 状态转移方程：
     - 如果s(i) == '('，dp(i) = 0
     - 否则
       - 如果s(i-1) == '(', dp(i) = dp(i-2) + 2
         - 否则，dp(i) = dp(i-1) + dp(i - dp(i-1) -2) + 2
   - 时间复杂度为O(n)

   https://github.com/Albertsirius/algorithm025/blob/main/Week5_6/LongestValidParentheses.java

2. 编辑距离

   - 开始用DFS：时间复杂度为O(2^n)，超时
     - Dfs(word1, i,  word2, j)表示计算word1[i:]，word2[j:]的编辑最短距离
     - 如果i == word1的长度，所以剩下word2的部分都要增加，返回长度
     - 如果j == word2的长度，所以剩下word1的部分都要删除，返回长度
     - word1[i] == word2[j]，最短路径就等于word1[i+1 :]和word2[j+1 :]
     - 不等，则有三种情况（删除，增加，新增），求最小值，再加1
   - 使用DFS + 记忆化搜索，定义数据states(i,j)表示word1[i:]和word2[j:]的编辑最短距离，初始化为负一，递归进去先检查，如果不为负一，则立刻返回
   - 使用DP：
     - 记忆化搜索states可以转为状态数据dp(i,j)，表示word[i:]和word[j:]的最短距离
     - 状态转移参照DFS
     - 时间复杂度为O(mn)

   https://github.com/Albertsirius/algorithm025/blob/main/Week5_6/EditDistance.java