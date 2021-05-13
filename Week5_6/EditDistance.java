package leetcode.editor.cn;

public class EditDistance {
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
        //TODO Test
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //DFS 超时
/*        public int minDistance(String word1, String word2) {
            return dfs(word1, 0, word2, 0);
        }

        *//*
        private int dfs(String word1, int index1, String word2, int index2) {
            // 如果word1，或word2已完成指示了，剩下的字母要么删除(word1比较长），要么添加(word2比较长)
            if (word1.length() == index1) return word2.length() - index2;
            if (word2.length() == index2) return word1.length() - index1;
            // 当前指示指示的字母相等，不用变换，看下一个
            if (word1.charAt(index1) == word2.charAt(index2)){
                return dfs(word1, index1 + 1, word2, index2 + 1);
            }else {
                //字母不相等，要么插入，要么删除，要么替换，三种情况
                return Math.min(dfs(word1, index1, word2, index2 + 1),
                        Math.min(dfs(word1, index1 + 1, word2, index2),
                        dfs(word1, index1 + 1, word2, index2 + 1)) ) + 1;
            }
        }*/

        //记忆化搜索，加状态矩阵
        /*public int minDistance(String word1, String word2) {
            int[][] states = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 0; i <= word1.length(); i++){
                Arrays.fill(states[i], -1);
            }
            //自顶向下
            return dsfWithStates(word1, 0, word2, 0, states);
        }

        private int dsfWithStates(String word1, int index1, String word2, int index2, int[][] states) {
            if (states[index1][index2] != -1)//已经遍历过，返回
                return states[index1][index2];
            if (index1 == word1.length()) {
                states[index1][index2] = word2.length() - index2;
                return states[index1][index2];
            }
            if (index2 == word2.length()) {
                states[index1][index2] = word1.length() - index1;
                return states[index1][index2];
            }
            if (word1.charAt(index1) == word2.charAt(index2)) {
                states[index1][index2] = dsfWithStates(word1, index1 + 1, word2, index2 + 1, states);
                return states[index1][index2];
            }else {
                states[index1][index2] = Math.min(dsfWithStates(word1, index1, word2, index2 + 1, states),
                        Math.min(dsfWithStates(word1, index1 + 1, word2, index2, states),
                                dsfWithStates(word1, index1 + 1, word2, index2 + 1, states)) ) + 1;
                return states[index1][index2];
            }

        }*/

        //DP，记忆化搜搜的states数组作状态数组
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            //初始化DP
            for (int i = 0; i <= word1.length(); i++) {
                dp[i][word2.length()] = word1.length() - i;
            }
            for (int j = 0; j <= word2.length(); j++) {
                dp[word1.length()][j] = word2.length() - j;
            }
            //从底向上
            for (int i = word1.length() - 1; i >= 0; i--) {
                for (int j = word2.length() - 1; j >= 0; j--) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1])) + 1;
                    }
                }
            }
            return dp[0][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}