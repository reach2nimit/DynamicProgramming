class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {

       List<Integer> result = new LinkedList();

       for(int i = num.length-1; i>=0; i--){
        result.add(0, (num[i] + k)%10);
        k = (num[i] + k)/10;
       }

       while(k>0){
        result.add(0, k%10);
        k = k/10;
       }
       return result;
    }
}