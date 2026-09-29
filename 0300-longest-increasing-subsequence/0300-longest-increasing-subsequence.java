class Solution {
    public int lengthOfLIS(int[] nums) {
        // int n = nums.length;
        // int[] dp = new int[n];
        // Arrays.fill(dp, 1);

        // int maxLen = 1;
        // for(int i = 1; i<n; i++){
        //     for(int j = 0; j<i; j++){

        //         if(nums[i]>nums[j])
        //             dp[i] = Math.max(dp[i], dp[j]+1);
        //     }
        //     maxLen = Math.max(maxLen, dp[i]);
        // }

        // return maxLen;


        List<Integer> arr = new ArrayList();

        for(int num : nums){

            int pos = findPosition(num, arr);
            if(pos == arr.size())
                arr.add(num);
            else
                arr.set(pos, num);
        }

        return arr.size();

    }


    public int findPosition(int num, List<Integer> arr){
        int left = 0, right = arr.size()-1;

        while(left<=right){
            int mid = left + (right-left)/2;

            if(arr.get(mid) >= num){
                right = mid - 1;
            }
            else
                left = mid + 1;
        }

        return left;
    }
}