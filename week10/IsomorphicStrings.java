package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new IsomorphicStrings().new Solution();
        //TODO Test
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> mapStoT = new HashMap<>();
            Map<Character, Character> mapTtoS = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char s_char = s.charAt(i);
                char t_char = t.charAt(i);
                if ((mapStoT.containsKey(s_char) && mapStoT.get(s_char) != t_char) || (mapTtoS.containsKey(t_char) && mapTtoS.get(t_char) != s_char)) {
                    return false;
                }
                mapStoT.put(s_char, t_char);
                mapTtoS.put(t_char, s_char);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}