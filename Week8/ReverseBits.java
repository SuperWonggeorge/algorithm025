package leetcode.editor.cn;

public class ReverseBits {
    public static void main(String[] args) {
        Solution solution = new ReverseBits().new Solution();
        //TODO Test
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int result = 0;
            int count = 32;
            while (count-- > 0) {
                result = result<<1;
                result += (n & 1);
                n = n>>1;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}