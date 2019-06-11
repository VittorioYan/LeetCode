/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution114 {
    TreeNode generate(TreeNode root){
        TreeNode point=root;
        while(point!=null){
            if(point.left!=null){
                TreeNode onlyRight=generate(point.left);
                TreeNode pointOR=onlyRight;
                while(pointOR.right!=null)pointOR=pointOR.right;
                pointOR.right=point.right;
                point.right=onlyRight;
                point.left=null;
            }
            point=point.right;
        }
        return root;
    }

    public void flatten(TreeNode root) {
        if(root==null)return;
         generate(root);
    }
}