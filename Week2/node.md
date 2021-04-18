# Hash

# Tree

# Heap、Binary Heap

## Heap

1. 迅速找到

## Binary Heap

### 介绍

1. 通过完全二叉树实现（不是二叉搜索树）
2. 树种任意节点的值总是大于等于子节点的值
3. 二叉堆一般通过数组实现
4. 节点索引是i，左儿子是2*i+1，右儿子是2*i+2
5. 索引为i的父节点floor((i-1)/2)

### 操作

1. 插入操作(O(logN)）
   1. 新元素插入到尾部
   2. 进行heapifyUp操作：大于父亲的化，与父亲节点交换
2. 删除堆顶的操作(O(logN))
   1. 将堆尾元素替换到顶部
   2. 从根部向下调整HeapifyDown
3. 工程实现直接调用Priority_Queue
4. Java实现的堆是PriorityHeap，默认是最小堆，如果要最大堆，初始化时要传入函数(a,b) → (b -a)即可
5. Map有各个方法是getOrDefault，如果不存在key，就返回Default定义的值

# Graph

## Graph的属性和分类

### 属性

1. Graph（V，E）
2. V 点
   1. 度 - 入度和出度
   2. 点与点间是否相连
3. E 边
   1. 有向和无向
   2. 权重

### 分类

1. 无向无权图
   1. 邻接矩阵: 没有方向，所以是对称矩阵；没有权重，矩阵元素为1
   2. 邻接表（链表）
2. 有向无权图
   1. 邻接矩阵：不是对称矩阵，矩阵元素为1
   2. 邻接表
3. 无向有权图
   1. 邻接矩阵：对称，矩阵元素为权重
   2. 邻接表：链表的元素包含值
4. 有向有权图

## 图常用算法

### DFS 递归写法

1. 必须要加visited的集合（树不用加，因为树没有环；图可能会重复）

### BFS代码

1. 同样必须有visited的集合