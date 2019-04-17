class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null)return null;
        ListNode result=new ListNode(1);
        result.next=head;
        ListNode resultPoint=result;
        ListNode nextPoint=head;
        ListNode left;
        ListNode right;
        if(k==1)return head;
        int pointer;
        int turns;
        while (nextPoint!=null){
            left=nextPoint;
            right=left;
            turns=k;
            pointer=turns;
            while (turns>0){
                while(right!=null&&pointer>1){

                    right=right.next;
                    pointer--;
                }

                if(right==null){
                    resultPoint.next=left;
                    return result.next;

                }
                if(turns==k)nextPoint=right.next;
                resultPoint.next=right;
                resultPoint=resultPoint.next;
                right=left;
                turns--;
                pointer=turns;
            }

        }
        resultPoint.next=null;


        return result.next;


    }
}