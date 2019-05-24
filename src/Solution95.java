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
    TreeNode mostRight(TreeNode root){
        TreeNode temp=root;
        while(temp.right!=null)temp=temp.right;
        return temp;
    }
    TreeNode mostLeft(TreeNode root){
        TreeNode temp=root;
        while(temp.left!=null)temp=temp.left;
        return temp;
    }
    TreeNode copyTree(TreeNode root){
        if(root==null)return null;
        TreeNode temp=new TreeNode(root.val);
        if(root.right!=null)temp.right=copyTree(root.right);
        if(root.left!=null)temp.left=copyTree(root.left);
        return temp;
    }


    public List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> treeMax=new ArrayList<>();
        List<List<TreeNode>> treeMin=new ArrayList<>();

        List<TreeNode> minPointTree=new ArrayList<>();
        List<TreeNode> maxPointTree=new ArrayList<>();
        List<TreeNode> result=new ArrayList<>();
        treeMax.add(new ArrayList<>());
        treeMin.add(new ArrayList<>());
        TreeNode minTree=new TreeNode(1);
        TreeNode maxTree=new TreeNode(n);
        minPointTree.add(minTree);
        treeMin.add(minPointTree);

        maxPointTree.add(maxTree);
        treeMax.add(maxPointTree);

        for(int i=2;i<=n;i++){
            minPointTree=new ArrayList<>();
            List<TreeNode> tempMin=treeMin.get(i-1);
            for(int j=0;j<tempMin.size();j++){
                TreeNode temp1=new TreeNode(i);
                temp1.left=tempMin.get(j);
                minPointTree.add(temp1);
                TreeNode temp2=copyTree(tempMin.get(j));
                mostRight(temp2).right=new TreeNode(i);
                minPointTree.add(temp2);
            }
            treeMin.add(minPointTree);
        }
        for(int i=2;i<=n;i++){
            maxPointTree=new ArrayList<>();
            List<TreeNode> tempMax=treeMax.get(i-1);
            for(int j=0;j<tempMax.size();j++){
                TreeNode temp1=new TreeNode(n-i+1);
                temp1.right=tempMax.get(j);
                maxPointTree.add(temp1);
                TreeNode temp2=copyTree(tempMax.get(j));
                mostLeft(temp2).left=new TreeNode(n-i+1);
                maxPointTree.add(temp2);
            }
            treeMax.add(maxPointTree);
        }

        for(int i=1;i<=n;i++){
            List<TreeNode> tempLeft=treeMin.get(i-1);
            List<TreeNode> tempRight=treeMax.get(n-i);
            if(tempLeft.size()==0){
                for(int k=0;k<tempRight.size();k++){
                    TreeNode temp=new TreeNode(i);
                    temp.left=null;
                    temp.right=tempRight.get(k);
                    result.add(temp);
                }
            }
            if(tempRight.size()==0){
                for(int k=0;k<tempLeft.size();k++){
                    TreeNode temp=new TreeNode(i);
                    temp.left=tempLeft.get(k);
                    temp.right=null;
                    result.add(temp);
                }
            }

            for(int j=0;j<tempLeft.size();j++){
                for(int k=0;k<tempRight.size();k++){
                    TreeNode temp=new TreeNode(i);
                    temp.left=tempLeft.get(j);
                    temp.right=tempRight.get(k);
                    result.add(temp);
                }
            }
        }

        return result;
    }
}