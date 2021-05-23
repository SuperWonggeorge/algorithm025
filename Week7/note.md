## 初级搜索复习

1. 朴素搜索

2. 优化方向：不重复(fibonaci)、剪枝

3. 搜索方向：DFS、BFS

   ```python
   # DFS - Recursion
   visited = set()
   def dfs(node,visited):
   	if node in visited: #terminator
   		return
   	visited.add(node)
   	# process current node here
   	...
   	for next_node in node.childred():
   		if not next_node in visited:
   			def(next_node,visited)
   ```

   ```python
   # DFS - Not Recursion
   def DFS(self, tree):
   	if tree.root is None:
   		return []
   	visited, stack = [], [tree.root]
   	while stack:
   		node = stack.pop()
   		visited.add(node)
   		process(node)
   		nodes = generate_related_nodes(node)
   		stack.push(nodes)
   	...
   ```

   ```python
   # BFS
   def BFS(graph, start, end):
   	queue = []
   	queue.append([start])
   	visited.add(start)
   
   	while queue:
   			node = queue.pop()
   			visited.add(node)
   			process(node)
   			nodes = generate_related_nodes(node)
   			queue.push(nodes)
   	
   ```

## 剪枝

压缩搜索分支，剪掉比较差或者次优的分支

### 回溯法

回溯法采用试错的思想，尝试分步的去解决一个问题。当它通过尝试发现现有的分步答案不能得到有效的解答的时候，将取消上一步甚至上几步的计算，在通过其他的可能分步解答再次尝试寻找问题的答案。本身就是递归和分治。

最坏情况复杂度是指数时间。

机器做重复性回溯比人脑强多

### 例题讲解

1. 括号生成：
   1. 剪枝和动态规划：见作业
   2. N皇后：见作业
   3. 数独 (回溯剪枝）：
      1. 需要三个set来判断是否使用各子（行、列、块）
      2. 枚举子块，方块索引 = (行 / 3) * 3 + 列  / 3

## 双向BFS

1. 相对于传统的BFS，同时从另一个方向进行BFS，直到有重合的点
2. 课程的例子，老师的代码超时了，考虑优化一下。

## 启发式搜索（heuristic)

### A* 搜索

1. 代码摸版

   ```python
   def AstarSearch(graph, start, end):
   	pq = collection.priority_queue()
   	pq.append([start])
   	visited.add(start)
   
   	while pq:
   		node = pq.pop()
   		visited.add(node)
   
   		process(node)
   		nodes = generate_related_nodes(node)
   		unvisited = [node for node in nodes if node not in visited]
   		pq.push(unvisited)
   ```

2. 不再使用Queue，使用优先队列PriorityQueuue

3. 重点是怎么定义这个估价函数（优先值函数）

### 估价函数

1. 启发式函数：h(n)，它用来评价哪些节点最有希望的是一个我们要找的节点，h(n)会返回一个非负实数，也可以认为是从节点n的目标节点路径的估价成本
2. 例题：
   1. 二进制矩阵的最短路径： h = dist(current_point, destination_point)
   2. 滑动谜题：还没理解，重复多听几次