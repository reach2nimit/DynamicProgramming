class Solution {
    public void nextPermutation(int[] nums) {
        int index = nums.length-2;
        while(index>=0 && nums[index]>=nums[index+1])
            index--;

        if(index >= 0){
            int i = nums.length-1;
            while(i>=0 && nums[index]>=nums[i])
                i--;
            
            swap(nums, index, i);
        }

        reverse(nums, index+1);
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start){

        int i = start, j = nums.length-1;
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }

    }
}