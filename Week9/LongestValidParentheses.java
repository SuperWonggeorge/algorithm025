package leetcode.editor.cn;

public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        //TODO Test
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            if (s.length() < 2) return 0;
            int[] dp = new int[s.length()];
            int result = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
                    }else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + (i - dp[i - 1] >=2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    result = Math.max(result, dp[i]);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}