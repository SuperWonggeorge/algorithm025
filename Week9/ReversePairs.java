package leetcode.editor.cn;

import java.util.Arrays;

public class ReversePairs {
    public static void main(String[] args) {
        Solution solution = new ReversePairs().new Solution();
        //TODO Test
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // merge-sort 归并排序O(nlogn)
        //归并排序的时候，作合并，可以进行判断是否满足条件
        /*public int reversePairs(int[] nums) {
            return mergeSort(nums, 0, nums.length - 1);
        }

        private int mergeSort(int[] nums, int left, int right) {
            if (left >= right) return 0;
            int mid = left + (right - left) / 2;
            int cnt = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
            for (int i = left, j = mid + 1; i <= mid; i++) {
                while (j <= right && nums[i] / 2.0 > nums[j]) j++;//防止溢出
                cnt += j - (mid + 1);
            }
            Arrays.sort(nums, left, right + 1); //直接sort，没有作排序，使复杂度增加了
            return cnt;
        }*/
        //另一种写法, 没有用系统的sort
        public int reversePairs(int[] nums) {
            if (nums.length == 0) return 0;
            return mergeSort(nums, 0, nums.length - 1);
        }

        private int mergeSort(int[] nums, int left, int right) {
            if (left >= right) return 0;
            int mid = left + (right - left) / 2;
            int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

            int[] temp = new int [right - left + 1];
            int i = left, t = left, c = 0;
            for (int j = mid + 1; j <= right; j++, c++) {
                while (i <= mid && nums[i] / 2.0 <= nums[j]) i++;
                while (t <= mid && nums[t] < nums[j]) temp[c++] = nums[t++];
                temp[c] = nums[j];
                count += mid - i + 1;
            }
            while (t <= mid) temp[c++] = nums[t++];
            System.arraycopy(temp, 0, nums, left, right - left + 1);
            return count;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}