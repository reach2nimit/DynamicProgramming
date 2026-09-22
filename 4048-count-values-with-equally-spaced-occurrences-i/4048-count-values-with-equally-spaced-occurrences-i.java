class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> mp = new HashMap();
        
        for(int i = 0; i<nums.length; i++){
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int count = 0;
        
        for(int val : mp.keySet()){

            List<Integer> indexList = mp.get(val);
            if(indexList.size() != 3)
                continue;
            
            if((indexList.get(2) - indexList.get(1)) == (indexList.get(1) - indexList.get(0)))
                count++;
        }

        return count;
    }
}