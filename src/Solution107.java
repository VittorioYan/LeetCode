import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)return result;
        LinkedList<TreeNode> bfs=new LinkedList<>();
        LinkedList<Integer> coord=new LinkedList<>();
        bfs.add(root);
        coord.add(1);

        int layNum = 1;
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
        if(!layer.isEmpty())result.add(layer);
        int len=result.size();
        for(int i=0;i<len/2;i++){
            List<Integer> temp=result.get(len-1-i);
            result.set(len-1-i,result.get(i));
            result.set(i,temp);
        }

        return result;


    }
}