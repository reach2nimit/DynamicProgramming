class Solution {
    public long pickGifts(int[] gifts, int k) {
       // 100 64 25 9 4
       // 64 25 10 9 4
       //25 10 9 8 4
       //10 9 8 5 4
       // 9 8 5 4 3

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int val : gifts)
            pq.add(val);
        
        while(k > 0){
            int val = pq.poll();
            val = (int)Math.sqrt(val);
            pq.add(val);
            k--;
        }

        long sum = 0;
        while(!pq.isEmpty()){
            sum+=(pq.poll());
        }

        return sum;
    }
}