import LinkedList.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem111 {
    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int result = 0;
        List<TreeNode> treeNodeList = new LinkedList<>();
        treeNodeList.add(root);
        begin:
        while (!treeNodeList.isEmpty()) {
            List<TreeNode> subList = new LinkedList<>();
            result++;
            for (TreeNode treeNode : treeNodeList) {
                if (null == treeNode.right && null == treeNode.left) {
                    break begin;
                }
                if (null != treeNode.left) {
                    subList.add(treeNode.left);
                }
                if (null != treeNode.right) {
                    subList.add(treeNode.right);
                }
            }
            treeNodeList = subList;
        }
        return result;
    }
}
