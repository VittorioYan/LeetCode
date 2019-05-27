/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution101 {
    boolean search(TreeNode leftTree,TreeNode rightTree){
        if(leftTree==null||rightTree==null){
            return leftTree==null&&rightTree==null;
        }
        if(leftTree.val!=rightTree.val)return false;
        return search(leftTree.left,rightTree.right)&&search(leftTree.right,rightTree.left);

    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return search(root.left,root.right);
    }
}