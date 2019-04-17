
import java.util.PriorityQueue;

class Solution23 {
    class ListClass implements Comparable<ListClass>{
        public int listNo;
        public int thisNumber;

        public int compareTo(ListClass listClass){
                return this.thisNumber-listClass.thisNumber;
        }

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result=new ListNode(1);
        ListNode pointer=result;

        PriorityQueue<ListClass> listQueue=new PriorityQueue<>();
        int n=lists.length;
        for(int i=0;i<n;i++){
            if(lists[i]!=null){
                ListClass temp=new ListClass();
                temp.listNo=i;
                temp.thisNumber=lists[i].val;
                listQueue.add(temp);
            }

        }
        ListClass temp=listQueue.poll();
        while (temp!=null){
            ListNode mid=new ListNode(temp.thisNumber);
            int listNo=temp.listNo;
            pointer.next=mid;
            pointer=pointer.next;
            lists[listNo]=lists[listNo].next;
            if(lists[listNo]!=null){
                ListClass theListC=new ListClass();
                theListC.listNo=listNo;
                theListC.thisNumber=lists[listNo].val;
                listQueue.add(theListC);
            }
            temp=listQueue.poll();


        }


        return result.next;

    }
}