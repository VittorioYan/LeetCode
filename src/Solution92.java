/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode result=new ListNode(0);
        result.next=head;
        if(n<2)return head;
        int i=0;
        ListNode point=result;
        ListNode before=result;
        ListNode temp;
        ListNode left=result;
        ListNode right;
        while(i<=n){
            if(i==m-1)before=point;
            if(i==m)left=point;
            point=point.next;
            i++;
        }
        right=point;
        i=n-m;
        while(i>=0){
            temp=left.next;
            left.next=right;
            right=left;
            left=temp;
            i--;
        }
        before.next=right;
        return result.next;

    }
}