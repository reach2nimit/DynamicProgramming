class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList();

        char[][] board = new char[n][n];
        for(int i = 0; i<n; i++)
            Arrays.fill(board[i],'.');
        
        boolean[] cols = new boolean[n];
        boolean[] diag = new boolean[2 * n - 1];
        boolean[] antiDiag = new boolean[2 * n - 1];

        backtrack(0, n, board, cols, diag, antiDiag, result);
        return result;
    }

    public void backtrack(int row, int n, char[][] board, boolean[] cols, boolean[] diag,
    boolean[] antiDiag, List<List<String>> result)
    {
        if(row == n){
            result.add(buildBoard(board));
            return;
        }

        for(int col = 0; col<n; col++){

            int d = row - col + n - 1;
            int ad = row + col;

            if(cols[col] || diag[d] || antiDiag[ad])
                continue;
            
            board[row][col] = 'Q';
            cols[col] = true;
            diag[d] = true;
            antiDiag[ad] = true;
        
            backtrack(row+1, n , board, cols, diag, antiDiag, result);

            board[row][col] = '.';
            cols[col] = false;
            diag[d] = false;
            antiDiag[ad] = false;
        }
       return;                     
    }

    public List<String> buildBoard(char[][] board){
        List<String> rows = new ArrayList();

        for(int i = 0; i<board.length; i++){
            rows.add(new String(board[i]));
        }
        return rows;
    }
}