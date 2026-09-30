class Solution {
    public int longestMountain(int[] arr) {
        int longest = 0;
        int n = arr.length;

        for(int i = 1; i<n-1; i++){

            if(arr[i] > arr[i-1] && arr[i]>arr[i+1]){
                int local = 3;
                int left = i-1, right = i+1;

                while(left - 1 >=0 &&  arr[left]>arr[left-1]  ){
                    left = left - 1;
                    local++;
                }

                while(right + 1 < n && arr[right]>arr[right+1]){
                    right = right + 1;
                    local++;
                }
                longest = (longest > local) ? longest : local;
            }
        }

        return longest;
    }
}