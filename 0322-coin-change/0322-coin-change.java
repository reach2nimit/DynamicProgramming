class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if(amount == 0)
            return 0;
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1); // it must be filled with large value as we use math min

        dp[0] = 0;


        for(int coin : coins){
            for(int i = coin; i<=amount; i++){
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}