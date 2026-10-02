class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxCount = 0;

        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(grid[i][j] == 1){
                    maxCount = Math.max(maxCount, dfs(grid, m, n, i, j));
                }
            }
        }

        return maxCount;
    }

    public int dfs(int[][] grid, int rows, int cols, int i, int j){

        if(i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == 0)
            return 0;
        
        grid[i][j] = 0; 

        int value = 1 + dfs(grid, rows, cols, i+1, j) + dfs(grid, rows, cols, i-1, j) +
                    dfs(grid, rows, cols, i, j + 1) + dfs(grid, rows, cols, i, j - 1);

        return value;
        
    }
}