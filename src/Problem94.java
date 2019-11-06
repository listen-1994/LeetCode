
import LinkedList.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        core(result, root);
        return result;
    }

    public void core(List<Integer> result, TreeNode root) {
        if (root.left != null) {
            core(result, root.left);
        }
        result.add(root.val);
        if (root.right != null) {
            core(result, root.right);
        }
    }
}
