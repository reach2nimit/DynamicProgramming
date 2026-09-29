class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        
        if(n<4){
            int profit = 0;
            for(int i = 1; i<n; i++)
                if(prices[i] > prices[i-1])
                    profit+=(prices[i] - prices[i-1]);
            return profit;
        }

        int[] buy = new int[3];
        int[] sell = new int[3];
        Arrays.fill(buy, Integer.MIN_VALUE);

        for(int price : prices){
            for(int j = 1 ; j<=2; j++){
                buy[j] = Math.max(buy[j], sell[j-1] - price);
                sell[j] = Math.max(sell[j], buy[j] + price);
            }
        }
        return sell[2];
    }
}