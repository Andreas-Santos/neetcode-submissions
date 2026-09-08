class Solution {
    public int findPeakElement(int[] nums) {
        
        // peak element -> greater than its neighbors

        int max = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[max]) {
                max = i;
            }
        }

        return max;
    }
}