package leetcode.editor.cn;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
        //TODO Test
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            int[] charCout = new int[26];
            int len = s.length();
            for (int i = 0; i < len; i++) {
                charCout[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < len; i++) {
                if (charCout[s.charAt(i) - 'a'] == 1) return i;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}