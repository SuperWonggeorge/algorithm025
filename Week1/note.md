## Arrays、LinkedList、SkipList

### Arrays

1. 数组增加删除元素要增加额外移动元素操作

2. 随机访问的复杂度是O(1)

3. 数组元素的删除，底层实现是把要删除的元素的后面的部分，复制到删除元素的地方：

   ```java
   System.arrayCopy(array, index+1, array, index, length)
   ```

   删除array中的index的元素，实际把index+1后面的元素复制到index的位置，长度减1

### LinkedList

1. 链表增删节点不用额外移动操作
2. 链表的访问元素要从头（尾）节点开始访问

### 跳表SkipList

1. 基于有序的链表（注意，跳表的使用一定时链表的元素是有序的）

2. 跳表对标的是AVL Tree，插入/删除/搜索都是O(Log n)的数据结构

3. 优势是原理简单、容易实现、方便扩展

4. 原理：

   1. 原有链表，添加第一级索引，查找先从索引开始查，再到原始的链表查找
   2. 要进一步提高查找效率的化，在第一级索引再添加第二级索引
   3. 可以继续添加索引，查找从最高的索引一级一级往下查

5. 时间复杂度：第K级索引的节点数是n/(2^k)，索引有h级，最高索引假设有2个，n/(2^h) = 2，从而h=log(n)-1

   跳表中查询的任意查询任意数据的时间复杂度是O(nlogn)

6. 空间复杂度O(n)

## Stack、Queue、Deque、PriorityQueue

### Stack、Queue

1. 栈，先进后出（LIFO）；队列，先进先出（FIFO）
   1. 栈解决问题：有最佳相关性，用栈解决
2. 查询O(n)，添加和删除O(1)
3. Deque：双端队列
4. Java源码实现
   1. Stack底层是Vector实现，工程不推荐用Stack，用Deque
   2. Stack API：peek（看栈顶)、pop（栈顶元素弹出并返回）、pull
   3. Queue是接口
   4. Queue接口：add、remove、element（访问元素）、offer（不抛异常，错误返回一个值)、poll（相当于remove，不抛异常）、peek（相当于element，不抛异常）
   5. Deque也是接口，实现有多个
   6. Deque的API相对Queue，多路xxxFirst和xxxLast

### PriorityQueue

1. 插入操作是O(1)
2. 取出操作是O(logn)
3. 底层具体实现的数据结构较为多样性和复杂，如heap、BST、treap
4. Java实现
   1. 需要实现comparator接口来对元素优先级进行比较

### 题目讲解

1. 如果遇到用队列实现栈或者用栈实现队列，一般用两个队列或者两个栈就可以了
2. 滑动窗口用双端队列