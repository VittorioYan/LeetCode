/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution124 {
    int result=Integer.MIN_VALUE;
    int maxP(TreeNode root){
        if(root==null)return 0;
        int thisNum=root.val;
        int leftNum=maxP(root.left);
        int rightNum=maxP(root.right);
        if(leftNum>0)thisNum+=leftNum;
        if(rightNum>0)thisNum+=rightNum;
        result=Integer.max(result,thisNum);
        if(leftNum>0&&rightNum>0)thisNum-=Integer.min(leftNum,rightNum);
        return thisNum;
    }
    public int maxPathSum(TreeNode root) {
        maxP(root);
        return result;
    }
}