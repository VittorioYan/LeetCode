import java.util.ArrayList;
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
class Solution95 {
    List<List<TreeNode>> treesMin;
    List<List<TreeNode>> treesMax;

    List<TreeNode> generate(int rootx){
        List<TreeNode> res=new ArrayList<>();
        List<TreeNode> rootLeft=treesMin.get(rootx-1);
        List<TreeNode> rootRight=treesMax.get(rootx+1);
        for(int i=0;i<rootLeft.size();i++){
            for(int j=0;j<rootRight.size();j++){
                TreeNode temp=new TreeNode(rootx);
                temp.left=rootLeft.get(i);
                temp.right=rootRight.get(j);
                res.add(temp);
            }
        }
        return res;

    }

    public List<TreeNode> generateTrees(int n) {

        List<TreeNode> minPointTree=new ArrayList<>();
        List<TreeNode> maxPointTree=new ArrayList<>();

        treesMin.add(minPointTree);
        treesMax.add(minPointTree);

        return null;
    }
}