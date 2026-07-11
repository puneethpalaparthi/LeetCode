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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        backtrack(root,"",res); //path=""
        return res;
    }
    private void backtrack(TreeNode root, String path,List<String> res){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            res.add(path+String.valueOf(root.val));
        }
        backtrack(root.left,path+String.valueOf(root.val)+"->",res);
        backtrack(root.right,path+String.valueOf(root.val)+"->",res);
    }
}

