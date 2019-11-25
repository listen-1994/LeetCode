import LinkedList.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem102 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> currentLevel = new LinkedList<>();
        List<TreeNode> nextLevel = new LinkedList<>();
        currentLevel.add(root);
        core(result, currentLevel, nextLevel);
        return result;
    }

    public void core(List<List<Integer>> result, List<TreeNode> currentLevel, List<TreeNode> nextLevel) {
        if (currentLevel.isEmpty()) {
            return;
        }
        List<Integer> subResult = new LinkedList<>();
        for (TreeNode node : currentLevel) {
            subResult.add(node.val);
            if (node.left != null) {
                nextLevel.add(node.left);
            }
            if (node.right != null) {
                nextLevel.add(node.right);
            }
        }
        result.add(subResult);
        currentLevel.clear();
        core(result, nextLevel, currentLevel);
    }
}
