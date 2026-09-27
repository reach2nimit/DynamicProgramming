class Solution {
    public int deleteAndEarn(int[] nums) {

        int maxVal = Arrays.stream(nums).max().getAsInt();

        int[] points = new int[maxVal + 1];
        
        for(int i = 0; i<nums.length; i++)
            points[nums[i]]+=nums[i];

        int[] dp = new int[maxVal + 1];
        dp[0] = 0;
        dp[1] = points[1];

        for(int i = 2; i < dp.length; i++)
            dp[i] = Math.max(dp[i-2] + points[i], dp[i-1]);
        
        return dp[maxVal];
    }
}