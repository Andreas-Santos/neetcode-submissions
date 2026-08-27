class Solution {

    List<List<Integer>> combinations;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        combinations = new ArrayList<>();

        Arrays.sort(candidates);
        
        dfs(candidates, 0, target, new ArrayList<>());

        return combinations;
    }

    public void dfs(int[] candidates, int index, int target, List<Integer> current) {

        if(target == 0) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            if(i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if(candidates[i] > target) {
                return;
            }

            current.add(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], current);
            current.remove(current.size() - 1);
        }
    }
}
