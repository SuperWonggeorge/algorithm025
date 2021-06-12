package leetcode.editor.cn;

public class DistinctSubsequences {
    public static void main(String[] args) {
        Solution solution = new DistinctSubsequences().new Solution();
        //TODO Test
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDistinct(String s, String t) {
            int[][] dp = new int[t.length() + 1][s.length() + 1];
            for (int i = 0; i < s.length(); i++)
                dp[0][i] = 1;
            for (int i = 1; i <t.length() + 1; i++) {
                for (int j = i; j < s.length() + 1; j++) {
                    if (t.charAt(i - 1) == s.charAt(j - 1)) {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                    }
                    else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
            return dp[t.length()][s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}