# DFS and BFS

## DFS - 深度优先

1. 采用递归

   ```python
   # Binary Tree
   def dfs(node):
   	if node in visited:
   		return
   	visited.add(node)
   	dfs(node.left)
   	dfs(node.right)
   # Graph
   visited = set()
   def dfs(node, visited):
   	visited.add(node)
   	for next_node in node.children():
   		if not next_node in visited:
   			dfs(next_node,visited)
   ```

2. 非递归

   ```python
   def DFS(self, tree):
   	if tree.node is node:
   		return []
   	visited, stack = [], [tree.node]
   	while stack:
   		node = stack.pop()
   		visited.add(node)
   		process(node)
   		nodes = generate_related_nodes(node)
   		stack.push(nodes)
   ```

## BFS - 广度优先

1. 非递归

   ```python
   def BFS(graph, start, end):
   	queue = []
   	queue.append([start])
   	visited.add(start)
   
   	while queue:
   		node = queue.popleft()
   		visited.add(node)
   		process(node)
   		nodes = generate_related_nodes(node)
   		queue.push(nodes)
   ```

# Greedy Algorithm

## 贪心算法

1. 每一步选择中都采取当前状态下最好或最优的选择，从而希望导致结果是全局最好或最优的算法
2. 贪心算法与动态规划的不同在于对每个子问题的解决方案都做出选择，**不能回退** 。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，**有回退功能**
3. 贪心解决最优化问题：如最小生成树、哈夫曼编码。然而工程问题一般不能得到我们所要的结果
4. 如果一个问题可以通过贪心解决，一般贪心是最好的办法
5. 贪心法的高效及所求的结果一般接近最优解，可以用作辅助算法，或者直接解决一些对结果不特别精确的问题

## 使用贪心算法的情况

1. 问题能够分解成子问题解决，子问题的最优解能递推到最终问题的最优解。有最优子结构（跟动态规划相似）

# Binary Search

## 二分查找的前提

1. 目标函数的单调性（单调递增或递减）
2. 存在上下界
3. 能够通过索引访问

## 二分查找代码摸版

```python
left,right = 0, len(array) - 1
while left <= right:
	mid = (left + right)/2
	if array[mid] == target:
		break or return result
	elif array[mid] < target:
		left = mid + 1
	else:
		right = mid - 1
```

## 题解

1. 使用二分查找，寻找一个半有序数组[4,5,6,7,0,1,2]中间无序的地方

   二分查找后，取中间数，然后和左边界与右边界比较:

   - 如果中间的数比左边界还小的，说明旋转的位置在左边，修改右边界；
   - 如果中间的数比右边界还大，说明旋转的位置在右边，修改左边界；
   - 如果符合单调递增，那么左边界就是旋转的位置

   ```java
   class Solution {
   		public int rotatedIndex(int[] nums) {
   	    int left = 0, right = nums.length - 1;
         while (left < right) {
   	      int mid = (left + right) / 2;
           if (nums[mid] < left) {
   	        right = mid - 1;
           }else if (nums[mid] > right) {
   	        left = mid + 1;
           }else break;
         }
   	    return left;
      }
   }
   ```