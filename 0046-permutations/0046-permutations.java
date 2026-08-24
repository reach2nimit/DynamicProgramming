class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, result, new ArrayList());
        return result;
    }

    public void backTrack(int[] nums, List<List<Integer>> result, List<Integer> current){

        if(current.size() == nums.length){
            result.add(new ArrayList(current));
            return;
        }

        for(int num : nums){
            if(!current.contains(num)){
                current.add(num);
                backTrack(nums, result, current);
                current.remove(current.size()-1);
            }
        }

    }
}