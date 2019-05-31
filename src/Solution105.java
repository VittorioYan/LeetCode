/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution105 {
    TreeNode generateTree(int pL,int pR,int iL,int iR,int[] preorder,int[] inorder){
        if(pR<pL||iR<iL)return null;
        int root=preorder[pL];
        TreeNode temp=new TreeNode(root);
        for(int i=iL;i<=iR;i++){
            if(inorder[i]==root){
                temp.left=generateTree(pL+1,pL+i-iL,iL,i-1,preorder,inorder);
                temp.right=generateTree(pL+i-iL+1,pR,i+1,iR,preorder,inorder);
                break;
            }
        }
        return temp;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return generateTree(0,preorder.length-1,0,inorder.length-1,preorder,inorder);
    }
}