//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1302 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        //TODO Test
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //分治+回溯
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            //保存访问过的数据
            int[] visited = new int[nums.length];
            backtrack(result, nums, visited, new ArrayList<Integer>());
            return result;
        }

        private void backtrack(List<List<Integer>> result, int[] nums, int[] visited, List<Integer> list) {
            //terminator
            if (list.size() == nums.length) {
                result.add(new ArrayList<Integer>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] == 1) continue; //已经拿出来
                visited[i] = 1;
                list.add(nums[i]);
                backtrack(result, nums, visited, list);
                //reverse state
                visited[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}