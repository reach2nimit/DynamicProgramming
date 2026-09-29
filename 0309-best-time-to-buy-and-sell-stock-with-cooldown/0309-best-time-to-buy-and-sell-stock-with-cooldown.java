class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length<2)
            return 0;

        int hold = -prices[0], sell = 0, rest = 0;

        for(int price : prices){
            int prevHold = hold, prevSold = sell, prevRest = rest;

            hold = Math.max(prevRest - price, prevHold);
            sell = prevHold + price;
            rest = Math.max(prevRest, prevSold);
        }

        return Math.max(rest, sell);
    }
}