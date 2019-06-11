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
class Solution116 {
    public Node connect(Node root) {
        Node point=root;
        if(root==null)return null;
        int maxInt=1;
        int turns=1;
        LinkedList<Node> list=new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()){
            Node thisTurn=list.poll();
            if(turns!=maxInt)
            point.next=thisTurn;
            point=thisTurn;
            turns--;
            if(turns==0){
                maxInt<<=1;
                turns=maxInt;
                point.next=null;
            }
            if(thisTurn.left!=null)list.add(thisTurn.left);
            if(thisTurn.right!=null)list.add(thisTurn.right);
        }
        return root;
    }
}