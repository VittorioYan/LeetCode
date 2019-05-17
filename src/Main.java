import java.util.List;

public class Main {


    public static void main(String[] args) {
        Solution85 solution = new Solution85();
        int[] nums = {2,1,5,6,2,3};
//        ListNode listNode=new ListNode(1);
//        listNode.next=new ListNode(1);
//        listNode.next.next=new ListNode(1);
//        listNode.next.next.next=new ListNode(2);
//        listNode.next.next.next.next=new ListNode(3);
//        listNode.next.next.next.next.next=null;
        String[] strs ={"ate"};
        char[][] sudu={
                {'1','1','0','1','1'},
                {'1','0','0','0','1'},
                {'1','1','0','1','1'},
                {'1','1','1','1','1'},
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
        int result=solution.maximalRectangle(sudu);

//        ListNode result=solution.reverseKGroup(listNode,3);
        System.out.println(result);


    }
}
