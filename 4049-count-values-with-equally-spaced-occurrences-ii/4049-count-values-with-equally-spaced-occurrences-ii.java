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
            
            int localCount = 1;
            for(int i = 2; i<indexList.size(); i++){
                if((indexList.get(i) - indexList.get(i-1)) == diff)
                    localCount++;
            }

            if(localCount == indexList.size()-1)
                count++;
        }

        return count;
    }
}