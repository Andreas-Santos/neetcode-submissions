class Solution {
    List<List<Integer>> subsets;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        subsets = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        
        return subsets;
    }

    public void dfs(int[] nums, int index, List<Integer> subset) {
        if(index == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        dfs(nums, index + 1, subset);
        subset.remove(subset.size() - 1);

        while(index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }

        dfs(nums, index + 1, subset);
    }
}
