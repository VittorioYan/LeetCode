import java.util.ArrayList;
import java.util.List;

class Solution113 {
    List<List<Integer>> result;
    void generate(TreeNode root,int sum,List<Integer> route){
        route.add(root.val);
        if(root.val==sum){
            if(root.left==null&&root.right==null){
                result.add(new ArrayList<>(route));
                return;
            }
        }
        if(root.right!=null){
            generate(root.right,sum-root.val,new ArrayList<>(route));
        }
        if(root.left!=null){
            generate(root.left,sum-root.val,new ArrayList<>(route));
        }

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result=new ArrayList<>();
        if(root==null)return result;
        generate(root,sum,new ArrayList<>());
        return result;
    }
}