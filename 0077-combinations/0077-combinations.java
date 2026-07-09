class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        backtracking(1,n,k,new ArrayList<>(),res);
        return res;

    }
    private void backtracking(int start, int n, int k, List<Integer> current, List<List<Integer>> res){
        if(current.size()==k){
            res.add(new ArrayList<>(current));
            return;
        }
        for(int i=start;i<=n-(k-current.size())+1;i++)
        {
            current.add(i);
            backtracking(i+1,n,k,current,res);
            current.remove(current.size()-1);
        }
    }
}