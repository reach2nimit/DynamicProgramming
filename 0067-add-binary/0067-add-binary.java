class Solution {
    public String addBinary(String a, String b) {
        
        int len1 = a.length() - 1, len2 = b.length() - 1;

        StringBuilder sb = new StringBuilder();
        int carry = 0;

        while(len1>=0 || len2>=0 || carry>0){

            if(len1>=0){
                int curr = a.charAt(len1) - '0';
                carry+=curr;
                len1--;
            }

            if(len2>=0){
                int curr = b.charAt(len2) - '0';
                carry+=curr;
                len2--;
            } 

            sb.append(carry % 2);
            carry /= 2;           
        }

        return sb.reverse().toString();
    }
}