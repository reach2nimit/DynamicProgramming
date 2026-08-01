class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        int currMax = nums[0];
        int currMin = nums[0];
        int result = currMax;

        for(int i = 1; i<nums.length; i++){
            int temp = Math.max(nums[i], Math.max(nums[i] * currMax, nums[i] * currMin));
            currMin = Math.min(nums[i], Math.min(nums[i] * currMin, nums[i] * currMax));
            currMax = temp;
            result = Math.max(result, currMax);
        }

        return result;
    }
}