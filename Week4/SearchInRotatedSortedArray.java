package leetcode.editor.cn;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        //TODO Test
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //二分查找
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                //如果左边有序，看是否在左边
                if (target == nums[mid]) return mid;
                //nums[0] <= nums[mid]说明左边是单调有序的，target > nums[mid] 或者 target < nums[0]（说明旋转在右边) 都看右边
                if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                    left = mid + 1;
                }else if (target < nums[0] && target > nums[mid]) {
                    //旋转在左边，target比nums[0]小，比mid大，看右边
                    left = mid + 1;
                }else {
                    //其他情况看左边
                    right = mid;
                }
            }
            return left == right && nums[left] == target ? left : -1;
        }
}
//leetcode submit region end(Prohibit modification and deletion)


}
