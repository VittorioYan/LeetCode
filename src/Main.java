import java.util.List;

public class Main {


    public static void main(String[] args) {
        Solution81 solution = new Solution81();
        int[] nums = {1,1,3};
//        ListNode listNode=new ListNode(1);
//        listNode.next=new ListNode(1);
//        listNode.next.next=new ListNode(1);
//        listNode.next.next.next=new ListNode(2);
//        listNode.next.next.next.next=new ListNode(3);
//        listNode.next.next.next.next.next=null;
        String[] strs ={"ate"};
        char[][] sudu={
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
                };

        int[][] martix={
                {1,0}
//                {1,   3,  5,  7},
//                {10, 13, 15, 20},
//                {23, 30, 34, 50}
//                {4,2,1}

        };
        String[] strings={"Listen","to","many,","speak","to","a","few."
        };
        boolean result=solution.search(nums,1);

//        ListNode result=solution.reverseKGroup(listNode,3);
        System.out.println(result);


    }
}
