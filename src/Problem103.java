import LinkedList.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Problem103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> currentLevel = new LinkedList<>();
        currentLevel.add(root);
        List<TreeNode> nextLevel = new LinkedList<>();
        Boolean flag = false;
        core(result, currentLevel, nextLevel, flag);
        return result;
    }

    public void core(List<List<Integer>> result, List<TreeNode> currentLevel, List<TreeNode> nextLevel, Boolean flag) {
        if (currentLevel.isEmpty()) {
            return;
        }
        List<Integer> subResult = new LinkedList<>();
        for (TreeNode treeNode : currentLevel) {
            subResult.add(treeNode.val);
            if (flag) {
                if (treeNode.right != null) {
                    nextLevel.add(0, treeNode.right);
                }
                if (treeNode.left != null) {
                    nextLevel.add(0, treeNode.left);
                }
            }
            if(!flag){
                if (treeNode.left != null) {
                    nextLevel.add(0, treeNode.left);
                }
                if (treeNode.right != null) {
                    nextLevel.add(0, treeNode.right);
                }
            }
        }
        result.add(subResult);
        currentLevel.clear();
        core(result,nextLevel,currentLevel,!flag);
    }
}
