package leetcode.editor.cn;

import java.util.*;

public class RelativeSortArray {
    public static void main(String[] args) {
        Solution solution = new RelativeSortArray().new Solution();
        //TODO Test
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            LinkedHashMap<Integer, Integer> countMap = new LinkedHashMap<>();
            int[] notMatch = new int[arr1.length];
            for (int i : arr2) {
                countMap.put(i, 0);
            }
            int notMatchIndex = 0;
            for (int i : arr1) {
                if (!countMap.containsKey(i)) {
                    notMatch[notMatchIndex++] = i;
                } else {
                    countMap.compute(i, (k, v) -> v + 1);
                }
            }
            Arrays.sort(notMatch, 0, notMatchIndex);
            int[] result = new int[arr1.length];
            int resultIndex = 0;
            for (int i : countMap.keySet()) {
                int count = countMap.get(i);
                while (count-- > 0) result[resultIndex++] = i;
            }
            System.arraycopy(notMatch, 0, result, resultIndex, notMatchIndex);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}