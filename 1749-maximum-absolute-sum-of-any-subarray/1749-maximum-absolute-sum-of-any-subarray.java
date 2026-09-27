class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max_sum = 0, min_sum =0;
        int max_till_here = 0, min_till_here = 0;

        for(int num : nums){

            max_till_here+=num;
            min_till_here+=num;

            max_sum = Math.max(max_sum, max_till_here);
            min_sum = Math.min(min_sum, min_till_here);

            if(max_till_here < 0)
                max_till_here = 0;
            
            if(min_till_here > 0)
                min_till_here = 0;
        }

        return Math.max(Math.abs(max_sum), Math.abs(min_sum));
    }
}