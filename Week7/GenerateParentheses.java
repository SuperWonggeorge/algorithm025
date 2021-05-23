//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1725 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        //TODO Test
        solution.generateParenthesis(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /*class Solution {
        //使用递归
        //每层递归添加括号，判断不合法，并满足
        //递归函数以左括号数和右括号数为参数
        //1. 添加的左括号数不能超过n
        //2. 添加的右括号，必须当前左括号数大于右括号数
        private List<String> resultList;

        public List<String> generateParenthesis(int n) {
            resultList = new ArrayList<>();
            _generate(0, 0, n, "");
            return resultList;
        }

        private void _generate(int left, int right, int n, String s) {
            // teminator
            if (left == n && right == n) {
                resultList.add(s);
            }

            //process current logic: left , right

            //drill down
            if (left < n) {
                _generate(left + 1, right, n, s + "(");
            }
            if (left > right) {
                _generate(left, right + 1, n, s + ")");
            }
        }
    }*/
    class Solution {
        /**
         * 使用DP
         * 参考题解<a href="https://leetcode-cn.com/problems/generate-parentheses/solution/zui-jian-dan-yi-dong-de-dong-tai-gui-hua-bu-lun-da/"></a>
         * 最优子结构，第n对括号的对数，等于第i对括号的情况，两边加左右括号，加上第j对括号的所有情况。其中i + j = n - 1
         *
         */
        public List<String> generateParenthesis(int n) {
            List<List<String>> resultList = new LinkedList<>();
            resultList.add(new LinkedList<>()); // 0对括号的情况
            List<String> oneList = new LinkedList<>();
            oneList.add("()");
            resultList.add(oneList); // 1对括号的情况
            for (int i = 2; i <= n; i++) {
                List<String> tempList = new LinkedList<>();
                for (int j = 0; j < i; j++) { // n - 1的情况
                    List<String> leftList = resultList.get(j);
                    List<String> rightList = resultList.get(i - 1 - j);
                    for (String l1: leftList) {
                        for (String r1: rightList) {
                            tempList.add("(" + l1 + ")" + r1);
                        }
                    }
                }
                for (String l1 : resultList.get(i - 1)) {
                    tempList.add("()" + l1);
                    tempList.add("(" + l1 + ")");
                }
                resultList.add(tempList);
            }
            return resultList.get(n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}