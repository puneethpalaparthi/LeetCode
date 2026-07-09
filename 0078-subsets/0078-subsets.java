class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        ArrayList<Integer> subset= new ArrayList<>();
        backtracking(nums,0,subset,res);
        return res;
    }
    private void backtracking(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res){

        
        res.add(new ArrayList<>(subset)); // every state is a solution state
        for(int j=i;j<nums.length;j++){
            subset.add(nums[j]); // pick // make a choice
            backtracking(nums,j+1,subset,res); // backtrack // explore a new path
            subset.remove(subset.size()-1); // not pick // undo the choice
        }
    }
}