class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        int[][] result = new int[rows*cols][2];

        int steps = 1; 
        result[0] = new int[]{rStart, cStart};
        int count = 1, total = rows * cols;

        int curRow = rStart;
        int curCol = cStart;

        while(count < total){

            for(int i = 0; i < steps && count < total; i++){
                curCol++;

                if(curRow >= 0 && curCol >= 0 && curRow < rows && curCol < cols){
                    result[count] = new int[]{curRow, curCol};
                    count++;
                }
            }

            for(int i = 0; i < steps && count < total; i++){
                curRow++;

                if(curRow >= 0 && curCol >= 0 && curRow < rows && curCol < cols){
                    result[count] = new int[]{curRow, curCol};
                    count++;
                }
            }

            steps++;

            for(int i = 0; i < steps && count < total; i++){
                curCol--;

                if(curRow >= 0 && curCol >= 0 && curRow < rows && curCol < cols){
                    result[count] = new int[]{curRow, curCol};
                    count++;
                }
            }

            for(int i = 0; i < steps && count < total; i++){
                curRow--;

                if(curRow >= 0 && curCol >= 0 && curRow < rows && curCol < cols){
                    result[count] = new int[]{curRow, curCol};
                    count++;
                }
            }

            steps++;
        }

        return result;
    }
}