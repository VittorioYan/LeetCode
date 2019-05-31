/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution108 {
    TreeNode generate(int[] nums,int l,int r){
        if(l>r)return null;
        if(l==r)return new TreeNode(nums[l]);
        int mid=l+(r-l)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=generate(nums,l,mid-1);
        root.right=generate(nums,mid+1,r);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int len=nums.length;
        return generate(nums,0,len-1);
    }
}