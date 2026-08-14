class Solution {
    public int maximumTop(int[] nums, int k) {
        if(k == 0)
            return nums[0];
        int len = nums.length;
        if(len == 1){
            if(k%2==0)
                return nums[0];
            return -1;
        }
        
        int best = -1;
        int limit = Math.min(len, k-1);

        for(int i = 0; i<limit; i++){
            if(nums[i]>best)
                best = nums[i];
        }

        if(k < len && best < nums[k])
            best = nums[k];
        
        return best;

    }
}