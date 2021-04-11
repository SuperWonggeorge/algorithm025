//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 713 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        //TODO Test
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //方法1、排序后分组
        //方法2、进行计数：所有字符串拆分为a[numa]b[numb]c[numc]...这种形式进行比较
        public List<List<String>> groupAnagrams(String[] strs) {
            return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    int[] alphabets = new int[26];
                    for (int i = 0; i < str.length(); i++) {
                        alphabets[str.charAt(i) - 'a'] ++;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < 26; i++) {
                        if (alphabets[i] != 0) {
                            stringBuilder.append((char)(i + 'a'));
                            stringBuilder.append(alphabets[i]);
                        }
                    }
                    return stringBuilder.toString();
                })).values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}