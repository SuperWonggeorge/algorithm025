package leetcode.editor.cn;

import java.util.Arrays;

public class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
        //TODO Test
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //二分查找
        public boolean searchMatrix(int[][] matrix, int target) {
            //获取第一列的元素
            int[] columnOne = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                columnOne[i] = matrix[i][0];
            }
            //二分查找找寻target的范围
            int row = rangeBinarySearch(columnOne, target);
            if (matrix[row][0] == target) return true;
            return Arrays.binarySearch(matrix[row], target) >= 0 ? true : false;
        }

        private int rangeBinarySearch(int[] columnOne, int target) {
            int left = 0, right = columnOne.length - 1;
            int mid = 0;
            while (left < right) {
                mid = (left + right + 1) / 2; //为什么要加1
                if (columnOne[mid] == target) return mid;
                if (columnOne[mid] > target) {
                    right = mid - 1;
                }else {
                    left = mid;
                }
            }
            return left;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}