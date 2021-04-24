package leetcode.editor.cn;

public class LemonadeChange {
    public static void main(String[] args) {
        Solution solution = new LemonadeChange().new Solution();
        //TODO Test
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //贪心算法
        public boolean lemonadeChange(int[] bills) {
            int five = 0, ten = 0;
            for (int i = 0; i < bills.length; i++) {
                if (bills[i] == 5) {
                    five++;
                }else if (bills[i] == 10) {
                    if (five < 1) return false;
                    ten++;
                    five--;
                }else {
                    if (ten >= 1) {
                        if (five < 1) return false;
                        ten--;
                        five--;
                    }else {
                        if (five < 3) return false;
                        five-=3;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
