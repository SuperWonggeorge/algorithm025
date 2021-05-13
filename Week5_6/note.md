# 动态规划（Dynamic Programming）

## 分治

1. 大问题分解为子问题
2. 代码摸版

```python
def divide_conquer(problem,param1,param2,...):
	# recursion terminator
	if problem is None:
			print_result
			return
	
	# prepare data
	data = prepare_data(problem)
	subproblems = split_problem(problem,data)
	
	# conquer subproblems
	subresult1 = self.divide_conquer(subproblem[0],p1,...)
	subresult2 = self.divide_conquer(subproblem[1],p1,...)
	...

	# process and generate the final result
	result = process_result(subresult1,subresult2,subresult3,...)

	# revert the current level states
```

1. 找到最近最简方法，将其拆解成可重复解决的问题
2. 数学归纳思维

## 动态规划定义

1. 问题的特点有最优子结构

2. 复杂的问题分解成简单的子问题

3. 动态规划和递归分治没有本质的区别

   - 共性：找到重复子问题
   - 差异性：最优子结构、中途可以淘汰次优解

4. 分治 - > 自顶向下进行递归，看能不能用记忆化搜索优化

   动态规划 - > 自底向上递推

5. 动态规划关键点：

   - 最优子结构 opt[n] = best_of(opt[n-1],opt[n-2],...)
   - 储存中间状态 opt[i]
   - 递推公式（状态转移方程)

## 常见问题

### 斐波那契数列

1. 直接递归是指数级

2. 加一个缓存（数组）保存结果，递归状态树就可以减少重复计算，进行记忆化搜索

   ```java
   int fib (int n, int[] memo) {
   	if (n <= 1) {
   		return n;
   	}
   	if (memo[n] == 0) {
   		memo[n] = fib(n-1) + fib(n-2);
   	}
   	return memo[n];
   }
   ```

3. 从指数级降为O(n)

4. 采用Bottom Up (递归是自顶向下)

   ```java
   a[0] = 0, a[1] = 1;
   for (int i = 2; i <= n; i++) {
   	a[i] = a[i-1] + a[i-2];
   }
   ```

### 路径问题

1. 分治的方法 + 记忆化搜索
2. 动态规划变成递推
3. 状态转移方程（DP方程）
4. opt[i,j] = opt[i+1,j] + opt[i,j+1]

### 最长公共子序列

1. 字符串问题：

   - S1 = ""，S2 = 任意字符串，为空
   - S1 = A，S2判断包不包括A
   - S1 = "...A"，S2="......A"，以A为结尾，可以化为求A之前的公共子序列的子问题

2. 用一个二维数组，一个字符串在行，另一个字符串在列

3. 状态转移方程：

   ```python
   if S1[-1] != S2[-1]:
   	LCS[S1, S2] = Max(LCS[S1-1, S2], LCS[S1, S2-1])
   else:
   	LCS[S1, S2] = LCS[S1-1, S2-1] + 1
   ```

## 动态规划小结

1. 打破自己的思维惯性，形成机器思维
2. 理解复杂逻辑的关键
3. 职业进阶的要点要领 - 不要人肉递归，不要亲力亲为，你只要做分治那一部分

## 习题

1. 三角形的最小路径和
   - 重复性 problem(i,j) = min(sub(i+1,j), sub(i+1,j+1)) + a[i,j]
   - 定义状态数据f[j,j]
   - dp方程：f[j,j] = min(f[i+1,j], f[i+1,j+1]) + a[i,j]
2. 最大连续和
   - 分治 problem(i) = Max(sub(i-1), 0) + a[i]
   - 状态数据f[i]
   - dp方程 f[i] = Max(f[i-1[,0) + a[i]
3. 零钱兑换
   - 递归，广度优先搜索，层数是硬币数，最先出现0的层数为最小的银币数
   - DP
     - 分治：
     - dp方程 f(n) = min{f(n-k), for k in []}) + 1
4. 打家劫舍
   1. 用个二维数组表示状态dp[][0,1]，其中dp[i][0]表示第i个房子不偷的最大值，dp[i][1]表示第i个房子偷的最大值
   2. 状态转移方程就有dp[i][0] = max(dp[i-1][0],dp[i-1][1])，dp[i][1] = dp[i-1][0] + num[i]
   3. 最后求max(dp[n][0],dp[n][1])
   4. 如果用一维数组表示，dp[i]表示0...i偷到的最大值
   5. 状态转移方程式dp[i] = max(dp[i-1], num[i] + dp[i-2])
   6. 打家劫舍问题II：环形，可以化解为两个子问题：不包含第一个元素nums[1:]，不包含最后一个元素nums[:n-1]，求max(nums[1:]，nums[:n-1]），求两个DP