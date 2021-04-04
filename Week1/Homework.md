# 本周作业

## 简单：

### 合并两个有序链表

使用递归的方法：

``` java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            }else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }else {
            if (l1 != null) return l1;
            else return l2;
        }
    }
}
```



### 两数之和

使用Hash来保存target

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(target - nums[i])) {
                result[0] = indexMap.get(target - nums[i]);
                result[1] = i;
                break;
            }
            indexMap.putIfAbsent(nums[i], i);
        }
        return result;
    }
}
```

### 移动零

采用双指针

```java
class Solution {
    public void moveZeroes(int[] nums) {
        for (int i=0, j=0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
```

### 加一

```java
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length -1; i >= 0; i -- ) {
            digits[i] ++ ;
            if (digits[i] > 9) {
                digits[i] %= 10;
            } else {
                return digits;
            }
        }
        digits = new int[ digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
```

