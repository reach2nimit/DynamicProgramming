class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int oneStep = 0, twoStep = 0;
        for(int i = 2; i<= cost.length; i++){
            int minCost = Math.min(oneStep + cost[i-1], twoStep + cost[i-2]);
            twoStep = oneStep;
            oneStep = minCost;
        }

        return oneStep;
    }
}