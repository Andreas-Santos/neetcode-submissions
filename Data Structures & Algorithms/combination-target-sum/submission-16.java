class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        List<List<Integer>> combinations = new ArrayList<>();
        
        dfs(nums, 0, target, combinations, new ArrayList<>());

        return combinations;
    }

    public void dfs(
        int[] nums, 
        int index, 
        int target, 
        List<List<Integer>> combinations,
        List<Integer> current
    ) {

        if(target == 0) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for(int i = index; i < nums.length; i++) {
            if(nums[i] > target) {
                break;
            }

            current.add(nums[i]);
            dfs(nums, i, target - nums[i], combinations, current);
            current.remove(current.size() - 1);
        }
    }
}
