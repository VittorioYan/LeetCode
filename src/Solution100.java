class Solution100 {
    boolean search(TreeNode p, TreeNode q){
        if(p==null){
            if(q==null)return true;
            else return false;
        }
        if(q==null)return false;
        if(p.val!=q.val)return false;
        return search(p.left,q.left)&&search(p.right,q.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return search(p,q);
    }
}