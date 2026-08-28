class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return  helper(nums, 0);
    }

    public List<List<Integer>> helper(int[] nums, int index) {

        if(index == nums.length) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        List<List<Integer>> nextPerm = new ArrayList<>();
        List<List<Integer>> perms = helper(nums, index + 1);

        for(List<Integer> perm : perms) {
            for(int i = 0; i < perm.size() + 1; i++) {
                List<Integer> copy = new ArrayList<>(perm);
                copy.add(i, nums[index]);
                nextPerm.add(copy);
            }
        }

        return nextPerm;
    }
}
