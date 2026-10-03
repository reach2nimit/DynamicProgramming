class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){

                if( i == 0 || j == 0)
                    continue;
                if(grid[i][j] == 0 && dfs(i,j, grid))
                    count++;
            }
        }

        return count;
    }

    public boolean dfs(int row, int col, int[][] grid){

        int m = grid.length;
        int n = grid[0].length;

        if( row < 0 || col < 0 || row >= m || col >= n)
            return false;
        
        if(grid[row][col] == 1)
            return true;

        grid[row][col] = 1;

        // buggy if this is all down in one line as it wont reach to all
        boolean left = dfs(row, col - 1, grid);
        boolean right = dfs(row, col + 1, grid);
        boolean up = dfs(row - 1 , col, grid);
        boolean down = dfs(row + 1, col, grid);

        return left && right && up && down;
               
    }
}