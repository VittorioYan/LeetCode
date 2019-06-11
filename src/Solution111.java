import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution111 {
    public int minDepth(TreeNode root) {
        int result=0;
        if(root==null)return 0;
        LinkedList<TreeNode> bfs=new LinkedList<>();
        LinkedList<Integer> coord=new LinkedList<>();
        bfs.add(root);
        coord.add(1);

        while (!bfs.isEmpty()){
            TreeNode thisRoot=bfs.poll();
            result=coord.poll();
            if(thisRoot.left==null&&thisRoot.right==null){
                break;
            }
            if(thisRoot.left!=null){
                bfs.add(thisRoot.left);
                coord.add(result+1);
            }
            if(thisRoot.right!=null){
                bfs.add(thisRoot.right);
                coord.add(result+1);
            }
        }
        return result;

    }
}