class Solution {
    public String[] findRelativeRanks(int[] score) {
        Queue<Integer> heap = new PriorityQueue<>((a,b) -> score[b] - score[a]);
        for(int i = 0; i < score.length; i++)
            heap.offer(i);
        
        String[] result = new String[score.length];

        Integer pos = 1;
        while(heap.size()>0){
            int index = heap.poll();
            if(pos == 1)
                result[index] = "Gold Medal";
            else if(pos == 2)
                result[index] = "Silver Medal";
            else if(pos == 3)
                result[index] = "Bronze Medal";
            else
                result[index] = pos.toString();
            pos++;
        }

        return result;
    }
}