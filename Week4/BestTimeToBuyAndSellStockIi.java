package leetcode.editor.cn;

public class BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIi().new Solution();
        //TODO Test
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //Greedy
        //后一天比前一天大，就可以买进
        //不用考虑卖出去再买进，好像不符合题解，如果a,b,c三天，a买进，c卖出，收益是c-a，跟c-b+b-a的效果是一样（就是b既买进又卖出)
        public int maxProfit(int[] prices) {
            int result = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i+1] > prices[i]){
                    result += prices[i+1] - prices[i];
                }
            }
            return  result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
