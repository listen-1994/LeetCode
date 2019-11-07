import LinkedList.TreeNode;

public class Problem98 {
    public boolean isValidBST(TreeNode root) {
        return core(root);
    }

    public boolean core(TreeNode root) {
        Boolean result = true;
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (root.left != null) {
            int max = getMax(root.left);
            if (val <= max) {
                return false;
            }
            if (!core(root.left)) {
                return false;
            }
        }

        if (root.right != null) {
            int min = getMin(root.right);
            if (val >= min) {
                return false;
            }
            if (!core(root.right)) {
                return false;
            }
        }


        return result;
    }

    public int getMax(TreeNode root) {
        if (root.right == null) {
            return root.val;
        }
        return getMax(root.right);
    }

    public int getMin(TreeNode root) {
        if (root.left == null) {
            return root.val;
        }
        return getMin(root.left);
    }

}
