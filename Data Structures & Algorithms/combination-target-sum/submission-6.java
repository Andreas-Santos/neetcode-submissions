class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, target, new ArrayList<>(), result);

        return result;

    }

    public void backtrack(
        int[] nums, int i, int target, List<Integer> list, List<List<Integer>> result) 
    {
        if(target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if(target < 0 || i >= nums.length) {
            return;
        }

        list.add(nums[i]);
        backtrack(nums, i, target - nums[i], list, result);
        list.remove(list.size() - 1);
        backtrack(nums, i + 1, target, list, result);
    }
}
