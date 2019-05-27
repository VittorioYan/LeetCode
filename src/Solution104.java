import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution104 {
    public int maxDepth(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)return 0;
        LinkedList<TreeNode> bfs=new LinkedList<>();
        LinkedList<Integer> coord=new LinkedList<>();
        bfs.add(root);
        coord.add(0);

        int layNum = 0;
        List<Integer> layer = new ArrayList<>();

        while (!bfs.isEmpty()){
            int theCoord=coord.poll();
            TreeNode theBfs=bfs.poll();
            if(theCoord>layNum){
                result.add(layer);
                layer=new ArrayList<>();
                layNum++;
            }
            layer.add(theBfs.val);
            if(theBfs.left!=null){
                coord.add(theCoord+1);
                bfs.add(theBfs.left);
            }
            if(theBfs.right!=null){
                coord.add(theCoord+1);
                bfs.add(theBfs.right);
            }

        }
        if(!layer.isEmpty())layNum++;

        return layNum;
    }
}