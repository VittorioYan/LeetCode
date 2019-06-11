/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution109 {
    TreeNode generate(ListNode left,int num){
        if(num==0)return null;
        if(num==1)return new TreeNode(left.val);
        int mid=num/2;
        ListNode point=left;
        while(mid>0){
            point=point.next;
            mid--;
        }
        TreeNode root=new TreeNode(point.val);
        root.left=generate(left,num/2);
        root.right=generate(point.next,num-num/2-1);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int num=0;
        ListNode point=head;
        while(point!=null){
            num++;
            point=point.next;
        }
//        return null;
        return generate(head,num);
    }
}