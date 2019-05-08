import java.util.List;

public class Main {


    public static void main(String[] args) {
        Solution77 solution = new Solution77();
        int[] nums = {2,0,2,1,1,0};
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
                {}
//                {1,   3,  5,  7},
//                {10, 13, 15, 20},
//                {23, 30, 34, 50}
//                {4,2,1}

        };
        String[] strings={"Listen","to","many,","speak","to","a","few."
        };
        List<List<Integer>> result=solution.combine(1,1);

//        ListNode result=solution.reverseKGroup(listNode,3);
//        System.out.println(result);


    }
}
