class Solution {
    public int[][] highestPeak(int[][] isWater) {

        int m = isWater.length, n = isWater[0].length;
        int[][] grid = new int[m][n];

        Deque<int[]> dq = new ArrayDeque();

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){

                if(isWater[i][j] == 1)
                    dq.offer(new int[]{i,j});
                else
                    grid[i][j] = -1;
            }
        }

        int[] dir = {-1, 0, 1, 0, -1};

        while(!dq.isEmpty()){

            int[] curr = dq.poll();
            for(int k = 0; k < 4; k++){

                int x = curr[0] + dir[k], y = curr[1] + dir[k+1];

                if(x >= 0 && y>=0 && x<m && y<n && grid[x][y] == -1){
                    grid[x][y]  = grid[curr[0]][curr[1]] + 1;
                    dq.offer(new int[]{x,y});
                }
            }

        }
        return grid;  
    }
}