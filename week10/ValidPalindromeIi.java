package leetcode.editor.cn;

public class ValidPalindromeIi {
    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIi().new Solution();
        //TODO Test
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            if (s.length() == 1 || s.length() == 0) return true;
            int l = 0, r = s.length() - 1;
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) {
                    return checkPalindrome(s.substring(l, r)) || checkPalindrome(s.substring(l + 1, r + 1));
                }else {
                    l++;
                    r--;
                }
            }
            return true;
        }

        private boolean checkPalindrome(String s) {
            if (s.length() == 1) return true;
            int l = 0, r = s.length() - 1;
            while (l < r) {
                if (s.charAt(l++) != s.charAt(r--)) return false;
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}