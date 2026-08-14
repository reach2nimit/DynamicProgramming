class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int len = barcodes.length;
        int[] result = new int[len];

        final int MAX_VALUE = 10000;
        int[] count = new int[MAX_VALUE + 1];

        int maxBarcode = barcodes[0];
        int maxFreq = 0;

        for(int i = 0; i < len; i++){
            int value = barcodes[i];
            count[value]++;

            if(count[value] > maxFreq){
                maxFreq = count[value];
                maxBarcode = value;
            }
        }

        int pos = 0;
        while(count[maxBarcode]>0){
            result[pos] = maxBarcode;
            pos+=2;
            count[maxBarcode]--;
        }

        for( int i = 1; i<=MAX_VALUE; i++){
            while(count[i]>0){
                if(pos>=len)
                    pos = 1;
                result[pos] = i;
                pos+=2;
                count[i]--;
            }
        }

        return result;
    }
}