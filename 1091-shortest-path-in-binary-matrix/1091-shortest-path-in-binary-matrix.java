class Solution {
    //BFS used for more thorough search 
    //DFS wont give result it has to search extensively
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] != 0 || grid[n-1][n-1] != 0)
            return -1;
        
        int[][] directions = {{1,1}, {1,0}, {0,1}, {-1,1}, {1,-1}, {0,-1}, {-1, 0}, {-1,-1}};
        //directions pairs check them carefully

        Queue<int[]> dq = new ArrayDeque();
        dq.offer(new int[]{0,0});
        grid[0][0] = 1;

        while(!dq.isEmpty()){

            int[] curr = dq.poll();
            int x = curr[0], y = curr[1];

            if(x == n-1 && y == n-1)
                return grid[x][y];
            
            for(int[] dir : directions){

                int newX = x + dir[0], newY = y + dir[1];

                if(newX >= 0 && newY >= 0 && newX < n && newY < n && grid[newX][newY] == 0){

                    grid[newX][newY] = grid[x][y] + 1;
                    dq.offer(new int[]{newX, newY});
                }
            }

        }
        return -1;
    }

}