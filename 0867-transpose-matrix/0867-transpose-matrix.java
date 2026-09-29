class Solution {
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        if(row == col){
            for(int i = 0; i < row; i++){
                for(int j = i + 1; j < col; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            return matrix;
        }
        else{
            int[][] result = new int[col][row];

            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    result[j][i] = matrix[i][j];
                }
            }
            return result;
        }
    }
}