# Boom Filter, LRU Cache

## 布隆过滤器Boom Filter

### 布隆过滤器与HashTable

1. 一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索一个元素是否在一个集合中
2. 优点是空间效率和查询时间都远远超过一般算法。缺点是有一定的误识别率和删除困难
3. Hash表不止可以判断在集合中，还可以存额外信息（value），布隆过滤器只能判断是否在集合中。

### 原理

1. 每个元素分配一系列的二进制位。通过映射函数，把元素转为一系列二进制位，并把对应二进制位设为1。
2. 判断一个元素是否在布隆过滤器里面，先通过映射函数转换为二进制位，如果有某一为在布隆过滤器不为1，那这个元素肯定不在布隆过滤器
3. 如果一个元素分配的二进制位都在布隆过滤器都为1，不一定这个元素一定在（False positive）
4. 布隆过滤器可以作为第一到过滤的关，如果在布隆过滤不存在，肯定存储不存在；如果存在，就再到后续的后台判断存不存在

### 实现

```python
from bitarray import bitarray
import mmh3

class BloomFilter:
	def __init__(self, size, hash_num):
		self.size = size
		self.hash_num = hash_num #hash_num表示分成多少个二进制位
		self.bit_array = bitarray(size)
		self.bit_array.setall(0)

	def add(self, s):
		for seed in range(self.hash_num):
			result = mmh.hash(s, seed) % self.size
			self.bit_array[result] = 1

	def lookup(self, s):
		for seed in range(self.hash_num):
			result = mmh3.range(s, seed) % self.size
			if self.bit_array[result] == 0:
				return "Nope"
		return "Probably"
```

## LRU Cache

### 特点

1. 数据结构：HashTable + DoubleLinkedList
2. O(1)查询，O(1)修改、更新

### 原理

1. 替换策略：最少最近被使用(least recently used)
2. 双向队列维护数据结构，最近使用和元素放在前面，较少使用的元素使用后面。当队列满时，新元素进来：新元素存在，修改为头元素；新元素不存在，丢弃尾元素
3. LFU - least frequently used

### 实现

```python
class LRU(object):
	
	def __init__(self, capacity):
		self.dic = collections.OrderedDict()
		self.remain = capacity

	def get(self, key):
		if key not in self.dic:
			return -1
		v = self.dic.pop(key) 
		self.dic[key] = v # key as the newest one
		return v

	def put(self, key, value):
		if key in self.dic:
			self.dic.pop(key)
		else:
			if self.remain > 0:
				self.remain -= 1
			else:
				self.dic.popitem(last=False)
		self.dic[key] = value
class LRUCache extends LinkedHashMap<Integer, Integer> {
        //使用LinkedHashMap
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
```

# Sort

## 排序分类

1. 比较类排序：通过比较元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此称为非线性时间比较类排序

   - 交换排序：冒泡，快排
   - 插入排序：简单插入排序、希尔排序
   - 选择排序：简单选择，堆排
   - 归并排序：二路归并，多路归并

2. 非比较类排序：不通过比较来决定元素间的相对次序，可以突破基于比较类排序的时间下界，以线性时间运行，线性时间非比较类排序。缺点是只能用于整型类型的排序，需要辅助的空间

   - 计数排序
   - 桶排序
   - 基数排序

3. 复杂度总结

   [排序方法复杂度总结](https://www.notion.so/842dd6d0abd141a1aeb0191c9072c4ab)

## 初级排序 - O(n^2)

1. 选择排序 - 每次找最小值，然后放到待排序数组的起始位置

   代码实现

   ```java
   public static void selectSort(int[] array) {
   	for (int i = 0; i < array.length; i++) {
   		for (int j = i + 1; j < array.length; j++) {
   			if (array[j] < min) {
   				int temp = array[j];
   				array[j] = array[i];
   				array[i] = temp;
   			}
   		}
   	}
   }
   ```

2. 插入排序 - 从前到后逐步构建有序序列，对于未排序的数据，在已排序序列从后向前扫描，找到相应位置并插入

   代码实现

   ```java
   public static void insertSort(int[] array) {
   	for (int i = 1; i < array.length; i++) {
   		if (array[i] < array[i - 1]) {
   			int temp = array[i];
   			int j = i;
   			while (j > 0 && temp < array[j - 1]) {
   				array[j] = array[j - 1];
   				j--;
   			}
   			array[j] = temp;
   		}
   	}
   }
   ```

3. 冒泡排序 - 嵌套循环，每次查看相邻元素，如果逆序，则交换

   代码实现

   ```java
   public static void bubbleSort(int[] array) {
   	for (int i = 1; i < array.length; i++) {
   		for (int j = 0; j < array.length - i; j++) {
   			if (array[j] > array[j + 1]) {
   				int temp = array[j];
   				array[j] = array[j + 1];
   				array[j + 1] = array[j];
   			}
   		}
   	}
   }
   ```

## 高级排序 - O(n^logn)

### 快速排序

1. 数组取标杆pivot，将小元素放到pivot左边，大元素放到右侧，然后依次对右边和左边的子数组进行快排，以达到整个序列有序

2. 代码实现

   ```java
   public static void quickSort(int[] array, int begin, int end) {
   	if (end <= begin) return;
   	int pivot = partition(array, begin, end);
   	quicksort(array, begin, pivot - 1);
   	quicksort(array, pivot + 1, end);
   }
   
   static int partition(int[] a, int begin, int end) {
   	int pivot = end, counter = begin //counter,小于pivot元素的个数
   	for (int i = begin; i < end; i++) {
   		if (a[i] < a[pivot] {
   			int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
   			counter++;
   		}
   	}
   	int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
   	return counter;
   }
   ```

### 归并排序

1. 把长度为n的输入序列分为两个长度为n/2的子序列

2. 对这两个子序列分表采用归并排序

3. 将两个排序好的子序列合并成为一个最终的排序序列

4. 实现

   ```java
   public static void mergeSort(int[] array, int left, int right) {
   	if (right <= left) return;
   	int mid = (left + right) >> 1;
   	mergeSort(array, left, mid);
   	mergeSort(array, mid + 1, right);
   	merge(array, left, mid, right);
   }
   
   public static void merge(int[] array, int left, int mid, int right) {
   	int[] temp = new int[right - left + 1];
   	int i = left, j = mid + 1, k = 0;
   	while (i <= mid && j <= right) {
   		temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
   	}
   	while (i <= mid) temp[k++] = array[i++];
   	while (j <= right) temp[k++] = array[j++];
   	for (int p = 0; p < temp.length; p++) {
   		array[left + p] = temp[p];
   	}
   }
   ```

### 对比

1. 归并：先排序左右子数组，然后合并两个有序子数组
2. 快排：先调配左右子数组，然后对左右子数组进行排序

### 堆排序

1. 数组元素一次建立小顶堆

2. 依次取堆顶元素，并删除

3. 代码实现

   ```java
   static void heapify(int[] array, int length, int i) {
   	int left = 2 * i + 1, right = 2 * i + 2;
   	int largest = i;
   	if (left < length && array[left] > array[largest]) {
   		largest = left;
   	}
   	if (right < length && array[right] > array[largest]) {
   		largest = right;
   	}
   	if (largest != i) {
   		int temp = array[i]; array[i] = array[largest]; array[largest] = temp;
   		heapify(array, length, largest);
   	}
   }
   
   public static void heapSort(int[] array) {
   	if (array.length == 0) return;
   	int length = array.length;
   	for (int i = length / 2 -1; i >= 0; i--) {
   		heapify(array, length, i);
   	}
   	for (int i = length - 1; i >= 0; i--) {
   		int temp = array[0]; array[0] = array[i]; array[i] = temp;
   		heapify(array, i , 0);
   	}
   }
   ```

## 特殊排序

1. 计数排序（Counting Sort）

   计数排序不是基于比较的排序算法，核心在于将输入的数据值转化为键存储在额外开辟的数组空间中，计算排序要求输入的数据必须是确定范围的整数

2. 桶排序 （Bucket Sort)

   利用函数的映射关系，将数据分到有限数量的桶里，每个桶再分别排序

3. 基数排序（Radix Sort）

   按照低位排序，然后收集，再按照高位排序，然后收集，依次类推，直到最高位。最大的问题只能排整型数

### 例题

1. 逆序对（493）重点看

# Advanced DP

## 复习

1. 人肉递归低效，累
2. 找到最近最简方法，将其拆解成可重复解决的问题
3. 数学归纳思维
4. 分治算法时，当发现有重复解，有最优子结构，可以淘汰次优解，那么分治可以采用动态规划的方法
5. 分治 + 记忆化搜索 → 动态规划

## 动态规划要点

1. 复杂问题分解为简单子问题
2. 分治 + 最优子结构
3. 状态可以顺推，动态递推
4. 动态规划和递归或者分治没有根本的区别（关键看有没有最优子结构）。共性是找到重复子问题。差异是最优子结构，中途可以淘汰次优解

## 常见问题和状态转移方程

1. 爬楼梯：斐波那契，硬币兑换

   f(n) = f(n-1) + f(n-2), f(1) = 1, f(0) = 0

   ```python
   def f(n):
   	x, y = 1, 1
   	for i in range(1, n):
   		y, x = x + y, y
   	return y
   ```

2. 不同路径

   f(x, y) = f(x-1, y) + f(x, y-1)

   ```python
   def f(x, y):
   	dp = [[0] * (m + 1) for _ in range(n + 1)]
   	dp[1][1] = 1
   	for i in range(1, y + 1):
   		for j in range(1, x + 1):
   			dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
   	return dp[x][y]
   ```

3. 打家劫舍

   dp[i] = max(dp[i - 2] + nums[i], dp[i -1])

   另一种中状态转移：dp[i][0]：没有偷nums[i]，dp[i][1]偷了nums[i]

   dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])

   dp[i][1] = dp[i-1][0] + nums[i];

4. 最小路径和

   dp[i][j]定义为minPath(A[1 → i][1 → j])

   dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + A[i][j]

5. 股票买卖

   dp[i][k][0 or 1]

   - i为天数
   - k为最多交易次数
   - 0,1为是否持有股票

   dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]) 今天没有持有股票，等于昨天也没持有，以及昨天持有今天卖出去

   dp[i][k][1] = max(dp[i-1][k][1] , dp[i-1][k-1][0] - prices[i]) 今天持有股票，等于昨天持有股票，以及昨天没有持有今天买了

   初始状态

   dp[-1][k][0] = dp[i][0][0] = 0

   dp[-1][k][1] = dp[i][0][1] = -infinity

## 复杂度来源

1. 如果一维状态矩阵无法解决，考虑升维，二维、三维
2. 状态维度更多，考虑压缩
3. 状态方程随着维度增加变得复杂