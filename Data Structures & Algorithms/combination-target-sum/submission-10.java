class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();

        dfs(nums, 0, target, new ArrayList<>());

        return result;
    }

    public void dfs(int[] nums, int i, int target, List<Integer> current) {
        
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if(target < 0 || i == nums.length || nums[i] == 0) {
            return;
        }

        for(int index = i; index < nums.length; index++) {
            current.add(nums[index]);
            dfs(nums, index, target - nums[index], current);
            current.remove(current.size() - 1);
        }
    }
}
