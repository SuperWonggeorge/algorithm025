//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 366 👎 0


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