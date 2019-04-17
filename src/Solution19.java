import java.util.LinkedList;
import java.util.List;

class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result=new ListNode(1);
        List<Integer> list=new LinkedList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        list.remove(list.size()-n);
        ListNode pointer=result;
        for(int i=0;i<list.size();i++){
            pointer.next=new ListNode(list.get(i));
            pointer=pointer.next;
        }
        result=result.next;



        return result;

    }
}