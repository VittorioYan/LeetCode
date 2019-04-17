class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode pointer = result;
        int carry=0;
        int midNum;
        while (l1!=null||l2!=null){
            int x=(l1!=null)?l1.val:0;
            int y=(l2!=null)?l2.val:0;
                midNum=x+y+carry;
                if(midNum>=10){
                    pointer.next=new ListNode(midNum%10);
                    pointer=pointer.next;
                    carry=1;
                }
                else {
                    pointer.next=new ListNode(midNum);
                    pointer=pointer.next;
                    carry=0;
                    }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            }
        if (carry==1){
            pointer.next=new ListNode(1);
            pointer=pointer.next;
        }
        return result.next;

        }

    }
