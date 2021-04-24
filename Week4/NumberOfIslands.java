package leetcode.editor.cn;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        //TODO Test
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //使用DFS
        //遍历二维数组，碰到是1的开始计算，进行DFS，所有相邻的1都设为0，岛数加1
        //继续遍历二维数组，只要碰到1都进行DFS，重复
        public int numIslands(char[][] grid) {
            int count = 0;
            if (grid.length == 0) return 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        DFSMarking(grid, i, j);
                        ++count;
                    }
                }
            }
            return count;
        }

        private void DFSMarking(char[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != '1') return;
            grid[i][j] = '0';
            DFSMarking(grid, i + 1, j);
            DFSMarking(grid, i, j + 1);
            DFSMarking(grid, i - 1, j);
            DFSMarking(grid, i, j - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
