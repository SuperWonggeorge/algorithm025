//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 560 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        //TODO Test
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            recursion(result, 1, n, k, new ArrayList<Integer>());
            return result;
        }

        private void recursion(List<List<Integer>> result, int index, int n, int k, List<Integer> list) {
            //terminator
            if ( k == 0 ) {
              result.add(new ArrayList<Integer>(list));
              return;
            }
            if ( index > n) return;
            recursion(result, index + 1, n, k, list);
            list.add(index);
            recursion(result, index + 1, n, k - 1, list);
            //reverse state
            list.remove(list.size() - 1);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}