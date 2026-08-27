class Solution {
    
    List<List<Integer>> subsets;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        subsets = new ArrayList<>();
        Arrays.sort(nums);
        
        dfs(nums, 0, new ArrayList<>());

        return subsets;
    }

    public void dfs(int[] nums, int i, List<Integer> subset) {

        if(i == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(nums, i + 1, subset);
        subset.remove(subset.size() - 1);

        while(i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        dfs(nums, i + 1, subset);
    }
}
