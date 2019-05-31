/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution106 {
    TreeNode generateTree(int pL,int pR,int iL,int iR,int[] preorder,int[] inorder){
        if(pR<pL||iR<iL)return null;
        int root=preorder[pR];
        TreeNode temp=new TreeNode(root);
        for(int i=iL;i<=iR;i++){
            if(inorder[i]==root){
                temp.left=generateTree(pL,pL+(i-1-iL),iL,i-1,preorder,inorder);
                temp.right=generateTree(pR-1-(iR-i-1),pR-1,i+1,iR,preorder,inorder);
                break;
            }
        }
        return temp;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return generateTree(0,postorder.length-1,0,inorder.length-1,postorder,inorder);
    }
}