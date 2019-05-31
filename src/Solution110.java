import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution110 {
    class TreeDepth{
        boolean isBanlan;
        int depth;
        TreeDepth(boolean isBanlan,int depth){
            this.isBanlan=isBanlan;
            this.depth=depth;
        }
    }
    LinkedList<TreeDepth> queue=new LinkedList<>();
    int depthLeft;
    int depthRight;

    TreeDepth bfs(TreeNode root){
        TreeDepth temp=new TreeDepth(false,0);
        if(root==null){
            temp.isBanlan=true;
            return temp;
        }
        TreeDepth left=bfs(root.left);
        TreeDepth right=bfs(root.right);
        if(!(left.isBanlan&&right.isBanlan))return temp;
        if(Math.abs(left.depth-right.depth)>1)return temp;
        temp.depth=Math.max(left.depth,right.depth)+1;
        temp.isBanlan=true;
        return temp;

    }

    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
       TreeDepth result=bfs(root);
       return result.isBanlan;
    }
}