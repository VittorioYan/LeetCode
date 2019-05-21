import java.util.ArrayList;
import java.util.List;

class Solution94 {
    List<Integer> result;

    void search(TreeNode root){
        if(root.left!=null)search(root.left);
        result.add(root.val);
        if(root.right!=null)search(root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        result=new ArrayList<>();
        if(root==null)return result;
        search(root);
        return result;

    }
}