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
    TreeNode addTree(TreeNode root,int add){
        if(root==null)return null;
        TreeNode temp=new TreeNode(root.val+add);
        if(root.right!=null)temp.right=addTree(root.right,add);
        if(root.left!=null)temp.left=addTree(root.left,add);
        return temp;
    }



    public List<TreeNode> generateTrees(int n) {
        if(n==0)return (new ArrayList<>());
        if(n==1){
            List<TreeNode> temp=new ArrayList<>();
            temp.add(new TreeNode(1));
            return temp;
        }

//        List<List<TreeNode>> treeMax=new ArrayList<>();

//        List<TreeNode> maxPointTree=new ArrayList<>();
//        treeMax.add(new ArrayList<>());

//        TreeNode maxTree=new TreeNode(n);

//        maxPointTree.add(maxTree);
//        treeMax.add(maxPointTree);

        List<List<TreeNode>> treeMin=new ArrayList<>();
        List<TreeNode> minPointTree=new ArrayList<>();
        treeMin.add(new ArrayList<>());
        TreeNode minTree=new TreeNode(1);
        minPointTree.add(minTree);
        treeMin.add(minPointTree);

        for(int theNum=2;theNum<=n;theNum++){
            minPointTree=new ArrayList<>();
            for(int i=1;i<=theNum;i++){
                List<TreeNode> tempTreeMin=treeMin.get(i-1);
                List<TreeNode> tempTreeMax=treeMin.get(theNum-i);

                if(tempTreeMin.size()==0){
                    for (TreeNode thisTurn:tempTreeMax) {
                        TreeNode temp=new TreeNode(i);
                        temp.left=null;
                        temp.right=addTree(thisTurn,i);
                        minPointTree.add(temp);
                    }
                }
                if(tempTreeMax.size()==0){
                    for (TreeNode thisTurn:tempTreeMin) {
                        TreeNode temp=new TreeNode(i);
                        temp.left=addTree(thisTurn,0);
                        temp.right=null;
                        minPointTree.add(temp);
                    }
                }
                for(int j=0;j<tempTreeMin.size();j++){
                    for(int k=0;k<tempTreeMax.size();k++){
                        TreeNode temp=new TreeNode(i);
                        temp.left=addTree(tempTreeMin.get(j),0);
                        temp.right=addTree(tempTreeMax.get(k),i);
                        minPointTree.add(temp);
                    }
                }
            }
            treeMin.add(minPointTree);

        }

        return minPointTree;

    }
}