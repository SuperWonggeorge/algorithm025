//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学 
// 👍 148 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ChouShuLcof {
    public static void main(String[] args) {
        Solution solution = new ChouShuLcof().new Solution();
        //TODO Test
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //使用堆，每次拿出最小的数字，乘以2，3，5，加到堆里面
        //用set去重
        public int nthUglyNumber(int n) {
            Set<Long> set = new HashSet<>();
            PriorityQueue<Long> heap = new PriorityQueue<>();
            set.add(1L);
            heap.offer(1L);
            int[] factors = {2,3,5};
            int result = 0;
            for (int i = 0; i < n; i++) {
                long temp = heap.poll();
                result = (int) temp;
                for (int factor : factors) {
                    long next = temp * factor;
                    if (set.add(next)){
                        heap.offer(next);
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}