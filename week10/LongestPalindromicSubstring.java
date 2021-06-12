package leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        //TODO Test
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //dp
        // dp[i][j] 表示i,j是否回文串，dp[i][j]是回文串等于 i == j 或者 s[i] == s[j] 且 （j - i == 1 或者 dp[i+1][j-1]是回文串）
        public String longestPalindrome(String s) {
            int n = s.length();
            String res = "";
            boolean[][] dp = new boolean[n][n];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i; j < n; j++) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                    if (dp[i][j] && j - i + 1 > res.length()) {
                        res = s.substring(i , j + 1);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}