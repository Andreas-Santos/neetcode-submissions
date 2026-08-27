class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return dfs(nums, 0);
    }

    public List<List<Integer>> dfs(int[] nums, int index) {
        if(index == nums.length) {
            List<List<Integer>> perms = new ArrayList<>();
            perms.add(new ArrayList<>());
            return perms;
        }

        List<List<Integer>> permutationsList = new ArrayList<>();
        List<List<Integer>> perms = dfs(nums, index + 1);
        for(List<Integer> perm : perms) {
            for(int i = 0; i < perm.size() + 1; i++) {
                List<Integer> permCopy = new ArrayList<>();
                permCopy.addAll(perm);
                permCopy.add(i, nums[index]);
                permutationsList.add(permCopy);
            }
        }
    

        return permutationsList;
    }
}
