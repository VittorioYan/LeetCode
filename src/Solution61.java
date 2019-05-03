class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)return null;

        ListNode point=head;
        int len=1;
        while (point.next!=null){
            point=point.next;
            len++;
        }
        point.next=head;
        point=head;
        for(int i=0;i<len-k%len;i++)point=point.next;
        ListNode result=point;
        while(point.next!=result)point=point.next;
        point.next=null;
        return result;

    }
}