class Solution {
    public int countSpecialIntegers(int[] nums) {

        Map<Integer, List<Integer>> mp = new HashMap();
        
        for(int i = 0; i<nums.length; i++){
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int count = 0;
        
        for(int val : mp.keySet()){

            List<Integer> indexList = mp.get(val);
            if(indexList.size() < 3)
                continue;
            
            int diff = (indexList.get(1) - indexList.get(0));
            
            boolean valid = true;
            for(int i = 2; i<indexList.size(); i++){
                if((indexList.get(i) - indexList.get(i-1)) != diff){
                    valid = false;
                    break;
                }
            }

            if(valid)
                count++;
        }

        return count;
    }
}