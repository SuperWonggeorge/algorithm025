package leetcode.editor.cn;

public class StringToIntegerAtoi {
    public static void main(String[] args) {
        Solution solution = new StringToIntegerAtoi().new Solution();
        //TODO Test
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int myAtoi(String s) {
            if(s.length() == 0) return 0;
            int index = 0, sign = 1, result = 0;
            while (index < s.length() && s.charAt(index) == ' ') index++;
            if (index == s.length()) return 0;
            if (s.charAt(index) == '+' || s.charAt(index) == '-') {
                sign = s.charAt(index) == '+' ? 1 : -1;
                index++;
            }
            for (; index < s.length(); index++) {
                int num = s.charAt(index) - '0';
                if (num < 0 || num > 9) break;
                //check if overflow after 10 times and add digit
                if (Integer.MAX_VALUE / 10 < result || Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < num) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = 10 * result + num;
            }
            return result * sign;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}