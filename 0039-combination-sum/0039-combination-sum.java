class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(0, candidates, target, new ArrayList<>(), res);
        return res;
    }

    private void backtracking(int start, int[] candidates, int target, List<Integer> current, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
        
            backtracking(i, candidates, target - candidates[i], current, res);
            
            current.remove(current.size() - 1);
        }
    }
}