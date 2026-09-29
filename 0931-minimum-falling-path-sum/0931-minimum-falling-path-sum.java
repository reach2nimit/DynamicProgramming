class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int[] prev = matrix[n-1];

        for(int i = n-2; i>=0; i--){
            int[] curr = new int[n];

            for(int j = 0; j<n; j++){
                int best = prev[j];

                if(j>0)
                    best = Math.min(best, prev[j-1]);
                
                if(j<n-1)
                    best = Math.min(best, prev[j+1]);
                
                curr[j] = matrix[i][j] + best;
            }
            prev = curr;
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++)
            result = Math.min(result, prev[i]);

        return result;
    }
}