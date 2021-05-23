package leetcode.editor.cn;

public class ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new ValidSudoku().new Solution();
        //TODO Test
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            boolean[][] row = new boolean[9][10];
            boolean[][] col = new boolean[9][10];
            boolean[][] block = new boolean[9][10];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') continue;
                    int number = board[i][j] - '0';
                    int blockIndex = (i/3) * 3 + j / 3;
                    if (row[i][number]) return false;
                    if (col[j][number]) return false;
                    if (block[blockIndex][number]) return false;
                    row[i][number] = true;
                    col[j][number] = true;
                    block[blockIndex][number] = true;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}