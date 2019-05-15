class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        if(head.next==null)return head;

        ListNode result=new ListNode(Integer.MAX_VALUE-2573);
        result.next=head;

        ListNode point=result.next;
        ListNode last=result;

        while(point!=null&&point.next!=null){
            if(point.next.val==point.val){
                while(point.next!=null&&point.val==point.next.val)point=point.next;
                last.next=point.next;
                point=point.next;
            }else {
                point=point.next;
                last=last.next;

            }



        }
        return result.next;


    }
}