class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new LinkedList<>();
        int l = 0;
        for(int r = 0; r < n; r++) {

            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[r]) {
                deque.removeLast();
            }

            deque.addLast(r);

            if(deque.peekFirst() < l) {
                deque.removeFirst();
            }            

            if(r + 1 >= k) {
                result[l] = nums[deque.peekFirst()];
                l++;
            }
        }

        return result;
    }
}
