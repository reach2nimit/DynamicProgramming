class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        int[][] directionMap = {{0,1}, {1,0}, {0,-1}, {-1,0} };
        int[][] result = new int[rows*cols][2];

        int steps = 0, len = 0;
        int direction = 0;

        result[0] = new int[]{rStart, cStart};
        int count = 1;

        while(count < rows * cols){

            if(direction ==0 || direction == 2)
                steps++;
            
            for(int i = 0; i < steps; i++){

                rStart += directionMap[direction][0];
                cStart += directionMap[direction][1];

                if(rStart>=0 && rStart < rows && cStart>=0 && cStart < cols){
                    result[count] = new int[]{rStart, cStart};
                    count++;
                }

                if(count == rows * cols)
                    return result;

            }
        
            direction = (direction + 1)%4;
        }

        return result;
    }
}