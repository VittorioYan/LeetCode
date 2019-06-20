/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution129 {
    int result;
    void calcul(TreeNode root,int num){
        int temp=num*10+root.val;
        if(root.left==null&&root.right==null){
            result+=temp;
            return;
        }
        if(root.left!=null){
            calcul(root.left,temp);
        }
        if(root.right!=null){
            calcul(root.right,temp);
        }

    }
    public int sumNumbers(TreeNode root) {
        result=0;
        if(root==null)return 0;
        calcul(root,0);
        return result;


    }
}