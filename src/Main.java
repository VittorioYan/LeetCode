import java.util.List;

public class Main {


    public static void main(String[] args) {
        Solution29 solution = new Solution29();
        int[] nums = {0,1};
        //int[] strs={-1, 0, 1, 2, -1, -4};
        int target=3;
//        ListNode listNode=new ListNode(1);
//        listNode.next=new ListNode(2);
//        listNode.next.next=new ListNode(3);
//        listNode.next.next.next=new ListNode(4);
//        listNode.next.next.next.next=new ListNode(5);
//        listNode.next.next.next.next.next=new ListNode(6);

        int result=solution.divide(2147483647,3);

//        ListNode result=solution.reverseKGroup(listNode,3);
        System.out.println(result);


    }
}

