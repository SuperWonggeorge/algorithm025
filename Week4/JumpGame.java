package leetcode.editor.cn;

import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        //TODO Test
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //两重循环，两个数组，时间复杂度O(n^2)
        /*public boolean canJump(int[] nums) {
            int[] flag = new int[nums.length];
            flag[0] = 1;
            for (int i = 0; i < nums.length; i++) {
                int step = i + nums[i];
                if (flag[i] == 0) return false; //该格子不可达，立刻返回
                for (int j = i; j <= step && j < nums.length; j++) {
                    flag[j] = 1;
                }
            }
            return flag[nums.length - 1] == 1;
        }*/
        //贪心算法
        //从后往前贪心：标记一个下标，初始为最后一个元素，然后从后到前直到0遍历，当前遍历到的元素加上自己的步数如果能达到那个下标的，更新下标为当前元素
        //时间复杂度为O(n)
        public boolean canJump(int[] nums) {
            if (nums == null) return false;
            int endFlag = nums.length - 1; //初始下标为最后元素
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] + i >= endFlag) {
                    endFlag = i;
                }
            }
            return endFlag == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
