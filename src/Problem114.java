import LinkedList.TreeNode;

public class Problem114 {
    private TreeNode treeNode;
/*    public void flatten(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        dfs(root, nodeList);
        for (int i = 0; i < nodeList.size() - 1; i++) {
            nodeList.get(i).left = null;
            nodeList.get(i).right = nodeList.get(i + 1);
        }
    }

    private void dfs(TreeNode root, List<TreeNode> nodeList) {
        if (null != root) {
            nodeList.add(root);
            dfs(root.left, nodeList);
            dfs(root.right, nodeList);
        }
    }*/

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if (null == root.left && null == root.right) {
            return root;
        }
        TreeNode spliceNode = null;
        if (null != root.left) {
            spliceNode = dfs(root.left);
        }
        TreeNode endNode = spliceNode;
        if (null != root.right) {
            endNode = dfs(root.right);
        }
        if (null != spliceNode) {
            spliceNode.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return endNode;
    }
}
