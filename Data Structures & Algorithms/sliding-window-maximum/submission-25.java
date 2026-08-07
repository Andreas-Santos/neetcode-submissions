class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // fixed window of size k
        // result array of size nums.length - k + 1

        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new LinkedList<>();

        int l = 0;
        for(int r = 0; r < n; r++) {

            while(!deque.isEmpty() && nums[r] > nums[deque.peekLast()]) {
                deque.removeLast();
            }

            deque.addLast(r);

            if(l > deque.peekFirst()) {
                deque.removeFirst();
            }

            if(r - l + 1 >= k) {
                result[l] = nums[deque.peekFirst()];
                l++;
            }
        }

        return result;
    }
}
