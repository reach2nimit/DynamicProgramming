class Solution {
    public boolean exist(char[][] board, String word) {
        
        boolean result = false;
        for(int i = 0; i<board.length;i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0))
                    return true;
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int curr){

        if(curr == word.length())
            return true;

        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] != word.charAt(curr))
            return false;

        char temp = board[i][j];
        board[i][j]='@';
        if (dfs(board, word, i+1, j, curr+1) ||
            dfs(board, word, i-1, j, curr+1) ||
            dfs(board, word, i, j+1, curr+1) ||
            dfs(board, word, i, j-1, curr+1)) {

            return true;
        } 

        board[i][j] = temp;

        return false;
    }
}