# Trie and DisJoint Set

## Trie数据结构

1. 字典数 - Trie树，又称单词查找树或者键树。用于统计和排序大量的字符串
2. 优点是最大限度的减少无谓的字符串比较，查询效率比哈希表高

### 基本结构

1. 结点本身不存任单词。
2. 单词沿着树的路径到叶子。从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串
3. 每个结点的所有子结点路径代表的字符都不相同
4. 搜索是，根据输入的不同字符，走不同分支
5. Trie树不是二叉数

### 结点存储额外信息

1. 统计频次，在叶子结点存储对应单词的频次
2. 还可以存其他额外信息

### 内部实现

1. 每个结点存一个字母哈希，对应每个字母指向下一个结点。比如字母’a'，根据a的哈希取得下一个结点的地址
2. 相当于每个结点有26个分叉（英文单词，其他情况可能更多）
3. 对于空间消耗比较大
4. 单词长度就是深度，所以查询很快

## 核心思想

1. 空间换时间
2. 利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的

## 实战题目

1. Trie树的实现

   ```java
   class TrieNode {
   	private TrieNode[] links
   	private final int R = 26;	
   	public boolean isEnd;
   	
   	public TrieNode() {
   		links = new TrieNode[R];
   	}
   
   	public boolean containKey(char ch) {
   		return links[ch - 'a'] != null;
   	}
   
   	public TrieNode get(char ch) {
   		return links[ch - 'a'];
   	}
   
   	public void put(char ch, TrieNode node) {
   		links[ch - 'a'] = node;
   	}
   
   	public void setEnd() {
   		isEnd = true;
   	}
   
   	public boolean isEnd() {
   		return isEnd;
   	}
   
   	public void insert(String word) {
   		TrieNode node = node;
   		for (int i = 0; i < word.length(); i++) {
   			char currcentChar = word.charAt(i);
   			if (!node.containKey(currentChar)) {
   				node.put(currentChar, new TrieNode());
   			}
   			node = node.get(currentChar);
   		}
   		node.setEnd();
   	}
   
   	public TrieNode searchPrefix(String word) {
   		TrieNode node = root;
   		for (int i = 0; i < wood.length(); i++) {
   			char curLetter = word.charAt(i);
   			if (node.containsKey(curLetter)) {
   				node = node.get(curLetter);
   			} else {
   				return null;
   			}
   		return node;
   	}
   
   	public boolean search(String word) {
   		TrieNode node =searchPrefix(word);
   		return node != null && node.isEnd();
   	}
   }	
   ```

   ```python
   class Trie(object):
   	def __init__(self):
   		self.root = {}
   		self.end_of_word = "#"
   	
   	def insert(self, word):
   		node = self.root
   		for char in word:
   			node = node.setdefault(char, {})
   		node[self.end_of_word] = self.end_of_word
   
   	def search(self, word):
   		node = self.root
   		for char in word:
   			if char not in node:
   				return False
   			node = node[char]
   		return self.end_of_word in node
   
   	def startsWith(self, prefix):
   		node = self.root
   		for char in prefex:
   			if char not in node:
   				return False
   			node = node[char]
   		return True
   ```

## DisJoin Set

### 使用场景

1. 组团、配对问题、分组问题、合并分组问题
2. 基本操作：
   1. makeset(s)：新建一个并查集，其中含s个单元素集合
   2. unionSet(x,y)：把元素x和y所在的集合合并，要求x和y的集合不相交，相交集合不合并
   3. find(x)：找到元素x所在的集合代表，该操作也用于判断两个元素是否位于同一个集合。

### 数据结构

1. 每一个元素有个parent的指针，初始时都指向自己

2. 每个元素从parent向上找，直到找到的元素parent指向自己，那么这个元素为集合的领头元素

3. 集合的合并，找出两个合并集合的领头元素，将其中一个的parent指向另外一个

4. 路径压缩，通过查找雅俗路径：如果有多个元素传递的指向，可以调整都指向领头元素，压缩路径。

   ```java
   class UnionFind {
   	private int count = 0; //表示有多少个集合
   	private int[] parent; //初始化parent[i] = i，自己指向自己
   	public UnionFind(int n) {
   		count = n;
   		parent = new int[n];
   		for (int i = 0; i < n; i++) {
   			parent[i] = i;
   		}
   	}
   	public int find(int p) {
   		while (p != parent[p]) {
   			parent[p] = parent[parent[p]]; //路径压缩
   			p = parent[p];
   		}
       return p;
   	}
   	public void union(int p, int q) {
   		int rootP = find(p);
   		int rootQ = find(q);
   		if (rootP == rootQ) return;
   		parent[rootP] = rootQ;
   		count--;
   	}
   }
   ```

   ```python
   def init(p):
   	p = [i for i in range(n)]
   
   def union(self, p, i, j):
   	p1 = self.parent(p, i)
   	p2 = self.parent(p, j)
   	p[p1] = p2
   
   def parent(self, p, i):
   	root = i
   	while p[root] != root:
   		root = p[root]
   	while p[i] != i: #路劲压缩
   		x = i; i = p[i]; p[x] = root;
   	return root
   ```

### 例题

1. 朋友圈：可以使用DFS和并查集

# AVL & Reb-Black Tree

## AVL树（一种平衡二叉树）

### 概念

1. 平衡因子：右子树的高度减去左子树的高度。AVL树的取值范围只有-1，0和1
2. 通过旋转操作来平衡（四种）
   - 左旋：右右子树
   - 右旋：左左子树
   - 左右旋：左右子树
   - 右左旋：右左子树
3. 不足：结点需要存储额外信息(int)，且调整次数频繁

## 红黑树（一种近似平衡二叉树）

### 概念

1. 红黑树是一种近似平衡的二叉树，确保任何一个结点的左右子树的高度差少于两倍（旋转的频次降低）
2. 满足以下特点：
   1. 每个结点要么是红，要么是黑
   2. 根结点是黑色
   3. 每个叶结点（NIL结点，空结点）是黑色
   4. 不能有相邻接的两个红色结点
   5. 从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点
3. 从根结点到叶子的最长的可能路径不多于最短的可能路径的两倍长

### AVL与红黑树对比

1. AVL比红黑树更高的查询效率（因为AVL是严格平衡）
2. 红黑树提供更快的插入和删除效率（红黑是近似平衡，旋转频次更少）
3. AVL存储信息更多（1个int），红黑树更少（1个bit）
4. 读操作更多的用AVL，插入更多的用红黑树
5. 高级语言库大多数用红黑树，DB则是AVL

# 位运算

## 位运算介绍

### 位运算符

- 左移：<<
- 右移：>>
- 按位或：|
- 按位与：&
- 按位取反：~
- 按位异或：^

### 指定位置位运算

1. 将x最右边的n位清零：x & (~0 << n)
2. 将取x的第n值（0或者1）：(x>>n) & 1
3. 获取x的第n为的幂值：x & (1 << n)
4. 仅将第n位置为1：x | (1 << n)
5. 仅将第n位置为0：x & ( ~(1<<n))
6. 将x最高为至第n位（含）清零：x & ((1<<n) - 1)

### 实战位运算的要点

1. 判断奇偶:

   - x % 2 == 1 → (x & 1) == 1
   - x % 2 == 0 → (x & 1) == 0

2. x >> 1 → x

   mid = (left + right) /2 → mid = (left +  right) >> 1

3. x = x & (x - 1)清零最低位的1

4. x & -x  得到最低位的1

5. x & ~x = 0

## 例题讲解

1. N皇后 - 位运算解法 （还没理解怎么表示撇捺以及计数过程)

   ```python
   def totalNQueens(self, n):
   	if n < 1: return []
   	self.count = 0
   	self.DFS(n, 0, 0, 0, 0)
   	return self.count
   
   def DFS(self, n, row, cols, pie, na):
   	# recursion terminator
   	if row >= n:
   		self.count += 1
   		return
   	
   	bits = (~(cols | pie | na)) & ((1<<n) - 1)
   	
   	while bits:
   		p = bits & -bits #取最低位1
   		bits = bits & (bits - 1) # 表示p位置上放入皇后
   		self.DFS(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1)
   		# 不需要revert cols，pie，na的状态
   ```

   ```java
   class Solution { //重复看
   	private int size; //可以填皇后的位置
   	private int count;
   	
   	private void solve (int row, int ld, int rd) {
   		if (row == size) {
   			count ++;
   			return;
   		}
   		int pos = size & (~|row | ld | rd));
   		while (pos != 0) {
   			int p = pos & (-pos);
   			pos -= p;
   			solve(row | p, (ld | p) << 1, (rd | p) >> 1);
   		}
   
   	}
   
   	public int totalNQueens(int n) {
   		count = 0;
   		size = (1 << n) - 1;
   		solve(0, 0, 0);
   		return count;
   	}
   }
   ```