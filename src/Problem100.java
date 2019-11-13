import LinkedList.TreeNode;

public class Problem100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return core(p, q);
    }

    public boolean core(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return core(p.left, q.left) && core(p.right, q.right);
    }

}
