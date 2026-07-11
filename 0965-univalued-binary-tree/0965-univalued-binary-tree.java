/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        traversal(root,res);
        int val=res.get(0);
        for(int i:res){
            if(i!=val){
                return false;

            }
         
        }
        return true;
        
        
    }
    private void traversal(TreeNode root, List<Integer> res){
        if(root==null){
            return;
        }
        res.add(root.val);
        traversal(root.left,res);
        traversal(root.right,res);
    }
}