class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int len = barcodes.length;
        int[] result = new int[len];

        Arrays.sort(barcodes);
        int maxBarcode = 0, maxFreq = 0;

        int index = 0;
        while(index < len){
            int start = index;
            while(index <len && barcodes[index] == barcodes[start]) {
                index++;
            }
            int count = index - start;

            if(count > maxFreq){
                maxFreq = count;
                maxBarcode = barcodes[start];
            }
        }
        int pos = 0;
        for(int i = 0; i< maxFreq; i++){
            result[pos] = maxBarcode;
            pos+=2;
        }

        for(int j = 0; j<len; j++){
            if(barcodes[j] == maxBarcode) continue;
            if(pos>=len)
                pos = 1;
            result[pos] = barcodes[j];
            pos+=2;
        }
        return result;
    }
}