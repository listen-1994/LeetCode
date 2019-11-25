import LinkedList.TreeNode;

public class Problem104 {
    public int maxDepth(TreeNode root) {
        return core(root);
    }

    public int core(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(core(node.left), core(node.right)) + 1;
    }
}
