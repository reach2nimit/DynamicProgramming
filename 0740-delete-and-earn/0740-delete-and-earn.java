class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> points = new HashMap<>();

        for(int num : nums)
            points.put(num, points.getOrDefault(num,0) + num);
        
        int maxVal = Arrays.stream(nums).max().getAsInt();

        int[] dp = new int[maxVal + 1];
        dp[0] = 0;
        dp[1] = points.getOrDefault(1,0);

        for(int i = 2; i < dp.length; i++)
            dp[i] = Math.max(dp[i-2] + points.getOrDefault(i,0), dp[i-1]);
        
        return dp[maxVal];
    }
}