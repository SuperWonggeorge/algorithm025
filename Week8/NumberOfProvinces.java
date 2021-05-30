package leetcode.editor.cn;

public class NumberOfProvinces {
    public static void main(String[] args) {
        Solution solution = new NumberOfProvinces().new Solution();
        //TODO Test
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //1. DFS
        /*public int findCircleNum(int[][] isConnected) {
            if (isConnected.length == 1) return 1;
            *//**
             * 使用visited数组，判断每个节点，如果未访问到，则加1，然后dfs搜索所有关联的节点
             *//*
            boolean[] visited = new boolean[isConnected.length];
            int result = 0;
            for (int i = 0; i < isConnected.length; i++) {
                if (!visited[i]) {
                    dfs(isConnected, visited, i);
                    result++;
                }
            }
            return result;
        }

        private void dfs(int[][] isConnected, boolean[] visited, int index) {
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[index][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    dfs(isConnected, visited, i);
                }
            }
        }*/
        //2. 并查集
        class UnionFind {
            private int count = 0; //表示有多少个集合
            private int[] parent; //初始化parent[i] = i，自己指向自己
            public UnionFind(int n) {
                count = n;
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }
            public int find(int p) {
                while (p != parent[p]) {
                    parent[p] = parent[parent[p]]; //路径压缩
                    p = parent[p];
                }
                return p;
            }
            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP == rootQ) return;
                parent[rootP] = rootQ;
                count--;
            }
        }

        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (isConnected[i][j] == 1) uf.union(i, j);
                }
            }
            return uf.count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}