package leetcode.editor.cn;

public class ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();
        //TODO Test
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            String[] stringArray = s.split(" ");
            StringBuilder resultString = new StringBuilder();
            int size = stringArray.length;
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    resultString.append(" ");
                }
                resultString.append(new StringBuffer(stringArray[i]).reverse());
            }
            return resultString.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}