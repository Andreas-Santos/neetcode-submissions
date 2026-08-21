class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for(int stone : stones) {
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            int smash = Math.abs(stone1 - stone2);

            if(smash != 0){
                maxHeap.offer(smash);
            }
        }

        maxHeap.offer(0);
        return maxHeap.peek();
    }
}
