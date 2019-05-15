class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        ListNode point=head.next;
        ListNode last=head;
        while(point!=null){
            if(point.val==last.val){
                last.next=point.next;
                point=point.next;
                continue;
            }
            last=point;
            point=point.next;

        }
        return head;


    }
}