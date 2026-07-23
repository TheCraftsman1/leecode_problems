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
    private int height_check(TreeNode root){
        if(root == null) return 0;

        int leftheight = height_check(root.left);
        if(leftheight == -1) return -1;

        int rightheight = height_check(root.right);
        if(rightheight== -1) return -1;

        if(Math.abs(leftheight-rightheight)>1) return -1;
        return 1+Math.max(leftheight,rightheight);
    }
    public boolean isBalanced(TreeNode root) {
        return height_check(root)!=-1;
    }
}