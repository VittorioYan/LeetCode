import java.util.LinkedList;
import java.util.List;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution117 {
    public Node connect(Node root) {
        Node point=root;
        if(root==null)return null;
        int maxInt=0;
        int turns=0;
        int numRec=1;
        LinkedList<Node> list=new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()){
            Node thisTurn=list.poll();
            if(thisTurn.left!=null){
                list.add(thisTurn.left);
                maxInt++;
            }
            if(thisTurn.right!=null){
                list.add(thisTurn.right);
                maxInt++;
            }
            if(turns!=0)
                point.next=thisTurn;
            point=thisTurn;
            turns++;
            if(turns==numRec){
                turns=0;
                numRec=maxInt;
                maxInt=0;
                point.next=null;
            }

        }
        return root;
    }
}