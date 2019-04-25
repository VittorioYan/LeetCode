import java.util.List;

public class Main {


    public static void main(String[] args) {
        Solution39 solution = new Solution39();
        int[] nums = {2,3,6,7};
//        ListNode listNode=new ListNode(1);
//        listNode.next=new ListNode(2);
//        listNode.next.next=new ListNode(3);
//        listNode.next.next.next=new ListNode(4);
//        listNode.next.next.next.next=new ListNode(5);
//        listNode.next.next.next.next.next=new ListNode(6);
        String[] strs ={"aa","aa","aa"};
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
        List<List<Integer>> result=solution.combinationSum(nums,7);



//        ListNode result=solution.reverseKGroup(listNode,3);
        System.out.println(result);


    }
}
