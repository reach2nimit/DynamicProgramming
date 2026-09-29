class Solution {
    public int minimumMountainRemovals(int[] nums) {
        
        int n = nums.length;
        int[] leftLis = findLIS(nums, false);
        int[] rightLis = findLIS(nums, true);

        int best = 0;

        for(int i = 1; i<nums.length - 1; i++){

            if(leftLis[i] > 1 && rightLis[i] > 1)
                best = Math.max(best, leftLis[i] + rightLis[i] - 1);
        }

        return n - best;
    }

    public int[] findLIS(int [] nums, boolean reverse){

        int n = nums.length;
        List<Integer> arr = new ArrayList();
        int[] result = new int[n];

        for(int k = 0; k <nums.length; k++){

            int i = reverse ? n - k - 1 : k;
            int pos = findPosition(nums[i], arr);
            if(pos == arr.size())
                arr.add(nums[i]);
            else
                arr.set(pos, nums[i]);
            
            result[i] = pos + 1;
        }
        return result;       
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