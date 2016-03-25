package Leetcode;

 
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
 
public class MinDepth {
    public int minDepth(TreeNode root) {
        if(root==null)
           return 0;
        if(root.left!=null && root.right!=null){
            int left = minDepth(root.left)+1;
            int right = minDepth(root.right)+1;
            return Math.min(left,right);
        }
        else if(root.left!=null){
            return minDepth(root.left)+1;
        }
        else{
            return minDepth(root.right)+1;
        }
    }
}