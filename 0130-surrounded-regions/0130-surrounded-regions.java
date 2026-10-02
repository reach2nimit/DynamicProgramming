class Solution {
    public void solve(char[][] board) {
        
        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i<rows; i++){

            dfs(board, i, 0);
            dfs(board, i, cols-1);
        }

        for(int i = 0; i<cols; i++){

            dfs(board, 0, i);
            dfs(board, rows-1, i);
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }

        return;        
    }


    public void dfs(char[][] board, int row, int col){

        int rows = board.length;
        int cols = board[0].length;
        
        if( row < 0 || col < 0 || row >= rows || col >= cols || board[row][col] != 'O')
            return;
        
        board[row][col] = '#';

        dfs(board, row + 1 , col);
        dfs(board, row - 1 , col);

        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}