class Solution {
    public int minCost(int[][] costs) {
        int len = costs.length;
        if(len == 0)
            return 0;
        
        int lastRed = costs[0][0], lastBlue = costs[0][1], lastGreen = costs[0][2];

        for(int i = 1; i<len; i++){

            int currRed = Math.min(lastBlue, lastGreen) + costs[i][0];
            int currBlue = Math.min(lastRed, lastGreen) + costs[i][1];
            int currGreen = Math.min(lastBlue, lastRed) + costs[i][2];

            lastRed = currRed;
            lastBlue = currBlue;
            lastGreen = currGreen;
        }

        return Math.min(Math.min(lastGreen, lastBlue), lastRed);
    }
}