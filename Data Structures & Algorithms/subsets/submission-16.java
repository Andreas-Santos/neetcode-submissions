class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> subsets = new ArrayList<>();

        dfs(nums, 0, subsets, new ArrayList<>());

        return subsets;

    }

    public void dfs(int[] nums, int i, List<List<Integer>> subsets, List<Integer> current) {

        if(i == nums.length) {
            subsets.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[i]);
        dfs(nums, i + 1, subsets, current);
        current.remove(current.size() - 1);

        dfs(nums, i + 1, subsets, current);
    }
}
