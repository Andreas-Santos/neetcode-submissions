class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for(int stone : stones) {
            heap.offer(stone);
        }

        while(heap.size() > 1) {

            int stone1 = heap.poll();
            int stone2 = heap.poll();

            int abs = Math.abs(stone1 - stone2);

            if(abs != 0) {
                heap.offer(abs);
            }
        } 

        if(heap.isEmpty()) return 0;

        return heap.poll();
    }
}
