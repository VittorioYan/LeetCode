/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(1);
        ListNode pointer=result;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                pointer.next=new ListNode(l1.val);
                l1=l1.next;
            }
            else {
                pointer.next=new ListNode(l2.val);
                l2=l2.next;
            }
            pointer=pointer.next;
        }
        if(l1==null){
            pointer.next=l2;
        }
        if(l2==null){
            pointer.next=l1;
        }
        return result.next;

    }
}