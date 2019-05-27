import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//over time
//class Solution102 {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> result=new ArrayList<>();
//        LinkedList<TreeNode> queue=new LinkedList<>();
//        queue.add(root);
//        List<Integer> layer=new ArrayList<>();
//        int turns=0;
//        int layNum=1;
//        int nullNum=0;
//        while (!queue.isEmpty()){
//            if(nullNum==layNum)break;
//            if(turns==layNum){
//                result.add(layer);
//                layer=new ArrayList<>();
//                layNum*=2;
//                turns=0;
//                nullNum=0;
//            }
//            turns++;
//            TreeNode temp=queue.poll();
//            if(temp==null){
//                nullNum++;
//                queue.add(null);
//                queue.add(null);
//                continue;
//            }
//            layer.add(temp.val);
//            queue.add(temp.left);
//            queue.add(temp.right);
//        }
//        if(!layer.isEmpty())result.add(layer);
//        return result;
//
//
//
//    }
//}
//

class Solution102 {


    public List<List<Integer>> levelOrder(TreeNode root) {
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

        return result;
    }
}