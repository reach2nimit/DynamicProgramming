class Solution {
    public int minGroups(int[][] intervals) {
        
        // 1 1 2 5 6
        // 3 5 8 10 10
        
        int len = intervals.length;
        int[] start = new int[len];
        int[] end = new int[len];

        for(int i = 0; i<len; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int endIndex = 0, result = 0;

        for(int val : start){
            if(val > end[endIndex])
                endIndex++;
            else
                result++;
        }

        return result;
    }
}