import LinkedList.TreeNode;

public class Problem101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return core(root.left, root.right);
    }

    public boolean core(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && core(left.left, right.right) && core(left.right, right.left);
    }

}
