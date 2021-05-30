package leetcode.editor.cn;

public class NumberOf1Bits {
    public static void main(String[] args) {
        Solution solution = new NumberOf1Bits().new Solution();
        //TODO Test
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need to treat n as an unsigned value
        //清零最低位的1，由于不是无符号整数，不用用n > 0的模式
        public int hammingWeight(int n) {
            int count = 0;
            while ( n != 0) {
                count ++;
                n = n & ( n - 1);
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}