class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];

        Deque<int[]> dq = new ArrayDeque();

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){

                if(mat[i][j] == 0)
                    dq.offer(new int[]{i,j});
                else
                    dist[i][j] = -1;
            }
        }

        int[] dirs = {-1, 0, 1, 0, -1};
        
        while(!dq.isEmpty()){

            int[] curr = dq.poll();

            for(int k = 0; k<4; k++){
                int x = curr[0] + dirs[k], y = curr[1] + dirs[k+1];

                if(x>=0 && y>=0 && x<m && y<n && dist[x][y] == -1){
                   dist[x][y] = dist[curr[0]][curr[1]] + 1;
                   dq.offer(new int[]{x,y}); 
                }
            }
        }

        return dist;
    }
}