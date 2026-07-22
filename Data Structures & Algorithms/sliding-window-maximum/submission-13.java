class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> indexQ = new LinkedList<>();

        int l = 0;
        for(int r = 0; r < n; r++) {

            while(!indexQ.isEmpty() && nums[indexQ.getLast()] < nums[r]) {
                indexQ.removeLast();
            }

            indexQ.addLast(r);

            if(l > indexQ.getFirst()) {
                indexQ.removeFirst();
            }

            if(r + 1 >= k) {
                result[l] = nums[indexQ.getFirst()];
                l++;
            }
        }
        
        return result;
    }
}
