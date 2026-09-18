class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        backTrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    public void backTrack(List<String> result, StringBuilder str, int start, int end, int n){

        if(start == n && end == n){
            result.add(str.toString());
            return;
        }

        if(start<n){
            str.append("(");
            backTrack(result, str, start+1, end, n);
            str.deleteCharAt(str.length()-1);       
        }

        if(end<start){ //this logic is important
            str.append(")");
            backTrack(result, str, start, end + 1, n);
            str.deleteCharAt(str.length()-1);       
        }

        return;
    }
}