import java.util.List;

public class Main {


    public static void main(String[] args) {
        Solution70 solution = new Solution70();
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
                {1,3,1},
                {4,5,1},
//                {4,2,1}

        };
        int result=solution.climbStairs(5);

//        ListNode result=solution.reverseKGroup(listNode,3);
        System.out.println(result);


    }
}
