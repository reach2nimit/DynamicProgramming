class Solution {
    public int lastStoneWeight(int[] stones) {
        // 8 7 4 2 1 1
        // 4 2 1 1 1
        // 2 1 1 1 
        // 1 1 1 
        // 1
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : stones)
            heap.offer(num);
        
        while(heap.size()>1){
            int first = heap.remove();
            int second = heap.remove();

            if(first == second)
                continue;
            else
                heap.offer(Math.abs(first-second));
        }
        if(heap.isEmpty())
            return 0;
        else
            return heap.peek();
    }
}