class Solution {
    public int maxSubArray(int[] nums) {

        int maxSum = nums[0];
        int current = 0;

        for(int i = 0; i < nums.length; i++) {
            current = Math.max(current + nums[i], nums[i]);

            maxSum = Math.max(maxSum, current);
        }

        return maxSum;
    }
}
