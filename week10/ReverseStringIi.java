package leetcode.editor.cn;

public class ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
        //TODO Test
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            int len = s.length();
            char[] arrayChars = new char[len];
            boolean flag = true;
            int index = 0, num = 0;
            while (index < len) {
                if (flag) {
                    int last = index + k - 1 > len - 1 ? len - 1 : index + k - 1;
                    int tmp = index;
                    while (last >= index) {
                        arrayChars[tmp++] = s.charAt(last--);
                    }
                    flag = false;
                    index = tmp;
                    num = 0;
                } else {
                    arrayChars[index] = s.charAt(index);
                    index++;
                    num++;
                    if (num == k) {
                        flag = true;
                    }
                }
            }
            return new String(arrayChars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}