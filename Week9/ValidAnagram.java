

package leetcode.editor.cn;

public class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
        //TODO Test
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    //使用Hash
    //开一个26个字母的数组，如果s字符串有，则加一；t有，则减一
    //最后判断是否都为0
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;
            int[] alphabetHash = new int[26];
            for (int i = 0; i < s.length(); i++) {
                alphabetHash[s.charAt(i) - 'a'] ++;
                alphabetHash[t.charAt(i) - 'a'] --;
            }
            for (int i = 0; i < alphabetHash.length; i++) {
                if (alphabetHash[i] != 0) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
