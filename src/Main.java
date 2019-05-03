import java.util.List;

public class Main {


    public static void main(String[] args) {
        Solution61 solution = new Solution61();
        int[] nums = {};
        ListNode listNode=new ListNode(1);
        listNode.next=null;
//        listNode.next.next=new ListNode(3);
//        listNode.next.next.next=null;
//        listNode.next.next.next.next=new ListNode(5);
//        listNode.next.next.next.next.next=null;
        String[] strs ={"ate"};
        char[][] sudu={
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        int[][] martix={
                {1,5},
//                {3,5},
//                {6,7},
//                {8,10},
//                {12,16}

//                {2,4,8,10},
//                {13, 3, 6, 7},
//                {15,14,12,16}
        };
        ListNode result=solution.rotateRight(listNode,4);
//        double result=solution.myPow(1.0000000001,Integer.MAX_VALUE);


//        ListNode result=solution.reverseKGroup(listNode,3);
        System.out.println(result);


    }
}
