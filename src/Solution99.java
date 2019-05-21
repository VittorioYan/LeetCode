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
class Solution99 {
    List<Integer> nums;
    int setPoint;
    void search(TreeNode root){
        if(root.left!=null)search(root.left);
        nums.add(root.val);
        if(root.right!=null)search(root.right);
    }
    void sets(TreeNode root){
        if(setPoint>=nums.size())return;
        if(root.left!=null)sets(root.left);
        root.val=nums.get(setPoint);
        setPoint++;
        if(root.right!=null)sets(root.right);
    }

    public void recoverTree(TreeNode root) {
        nums=new ArrayList<>();
        search(root);
        Collections.sort(nums);
        setPoint=0;
        sets(root);


    }
}