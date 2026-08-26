class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, target, result, new ArrayList<>());
        
        return result;
    }

    public void backtrack(int[] nums, int i, int target, List<List<Integer>> result, List<Integer> current) {
        
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if(i == nums.length || target < 0 || nums[i] == 0) {
            return;
        }

        current.add(nums[i]);
        backtrack(nums, i, target - nums[i], result, current);

        current.remove(current.size() - 1);
        backtrack(nums, i + 1, target, result, current);
    }
}
