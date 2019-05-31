import java.util.List;

public class Main {


    public static void main(String[] args) {
        Solution110 solution = new Solution110();
        int[] nums = {0,1,2,3,4,5};
        int[] nums1 = {};
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(2);

        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        TreeNode treeNode4=new TreeNode(3);
        treeNode2.left=treeNode4;
        treeNode4.left=new TreeNode(4);
        treeNode2.right=new TreeNode(3);
//        treeNode3.left=new TreeNode(4);
        treeNode3.right=new TreeNode(4);


        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=null;
//        listNode.next.next.next=new ListNode(4);
//        listNode.next.next.next.next=new ListNode(5);
//        listNode.next.next.next.next.next=new ListNode(2);
//        listNode.next.next.next.next.next.next=null;
        String[] strs ={"ate"};
        char[][] sudu={
//                {'1','0','1','0','1'},
//                {'1','1','1','0','1'},
//                {'1','1','1','0','1'},
//                {'1','1','1','1','1'},
                {'0','1','1','0','0','1','0','1','0','1'},
                {'0','0','1','0','1','0','1','0','1','0'},
                {'1','0','0','0','0','1','0','1','1','0'},
                {'0','1','1','1','1','1','1','0','1','0'},
                {'0','0','1','1','1','1','1','1','1','0'},
                {'1','1','0','1','0','1','1','1','1','0'},
                {'0','0','0','1','1','0','0','0','1','0'},
                {'1','1','0','1','1','0','0','1','1','1'},
                {'0','1','0','1','1','0','1','0','1','1'}
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
//        List<TreeNode> result=solution.generateTrees(5);
        boolean result=solution.isBalanced(treeNode1);

//        ListNode result=solution.reverseKGroup(listNode,3);
        System.out.println(result);


    }
}
