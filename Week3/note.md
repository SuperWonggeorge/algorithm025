# Recursion

## 递归代码摸版

1. 递归terminator
2. 处理当前层逻辑
3. 下探到下一层
4. 清理当前层

## 递归思路

1. 不要人肉进行递归
2. 找到最近最简的方法，将其拆解成为可重复解决的问题（重复子问题）
3. 数学归纳思想

## 题解

1. 生成括号
2. 验证二叉搜索树：BST的中序遍历是顺序的

# Divide and Conquer、BackTracking

## 分治

### 分治代码摸版

```python
def divide_conquer(problem, param1, param2, ...):
	# recursion terminator
	if problem is None:
		print_result
		return
	# prepare data
	data = prepare_data(problem)
	sub_problems = split_problem(problem, data)
	# conquer subproblems
	subresult1 = self.divide_conquer(sub_problems[0], p1, ...)
	subresult2 = self.divide_conquer(sub_problems[1], p1, ...)
	...
	# process and generate the final result
	result = process_result(subresult1, subresult2, ...)
```

## 回溯

回溯采用试错的思想，尝试分步的去解决问题。回溯法通常用最简单的递归方法来实现，最坏情况可能会导致指数级时间。