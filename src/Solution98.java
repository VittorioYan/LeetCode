import java.util.ArrayList;
import java.util.List;

class Solution98 {
    List<Integer> result;

    void search(TreeNode root){
        if(root.left!=null)search(root.left);
        result.add(root.val);
        if(root.right!=null)search(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        result=new ArrayList<>();
        if(root==null)return true;
        search(root);
        int a=result.get(0);
        for(int i=1;i<result.size();i++){
            if(result.get(i)<=a)return false;
            a=result.get(i);
        }
        return true;

    }

}