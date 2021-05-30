package leetcode.editor.cn;

public class PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new PowerOfTwo().new Solution();
        //TODO Test
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}