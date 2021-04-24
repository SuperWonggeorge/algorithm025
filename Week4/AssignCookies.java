package leetcode.editor.cn;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        Solution solution = new AssignCookies().new Solution();
        //TODO Test
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int indexOfChildren = 0, indexOfCookies = 0;
            while (indexOfChildren < g.length && indexOfCookies < s.length) {
                if (s[indexOfCookies] >= g[indexOfChildren]) {
                    indexOfChildren++;
                }
                indexOfCookies++;
            }
            return indexOfChildren;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
