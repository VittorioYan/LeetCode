class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode large=new ListNode(0);
        if(head==null)return head;
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode largeFirst=large;
        ListNode point=head;
        ListNode pointBefore=result;
        while(point!=null){
            if(point.val<x){
                large.next=new ListNode(point.val);
                large=large.next;
                pointBefore.next=point.next;
                point=point.next;
                continue;
            }
            point=point.next;
            pointBefore=pointBefore.next;
        }
        large.next=result.next;
        return largeFirst.next;

    }
}