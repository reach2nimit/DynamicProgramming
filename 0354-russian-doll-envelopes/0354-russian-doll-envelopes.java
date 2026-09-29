class Solution {
    public int maxEnvelopes(int[][] envelopes) {

       Arrays.sort(envelopes, (a,b) -> {
        if(a[0]==b[0]) 
            return b[1] - a[1];
        else 
            return a[0] - b[0];
       });

       int[] heights = new int[envelopes.length];

       for(int i =0; i<envelopes.length; i++)
        heights[i] = envelopes[i][1];

       List<Integer> arr = new ArrayList(); 

       for(int height : heights){

        int pos = binarySearch(height, arr);
        if(pos == arr.size())
            arr.add(height);
        else
            arr.set(pos, height);
       }

       return arr.size(); 
    }

    public int binarySearch(int height, List<Integer> arr){

        int left = 0, right = arr.size()-1;

        while(left<=right){

            int mid = left + (right-left)/2;

            if(arr.get(mid) >= height)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
    }
}