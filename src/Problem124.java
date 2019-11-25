import LinkedList.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Problem124 {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Map<TreeNode, int[]> nodeMapOut = new HashMap<>();
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;
        core(nodeMapOut, root, result);
        core2(nodeMapOut, root, result, 0);

        return result[0];
    }

    //三维数组，0-left，1-right，2-father
    public void core(Map<TreeNode, int[]> nodeMapOut, TreeNode root, int[] result) {
        if (root == null) {
            return;
        }
        Integer left = 0;
        Integer right = 0;
        if (root.left != null) {
            if (nodeMapOut.get(root.left) == null || nodeMapOut.get(root.left)[2] == 0) {
                core(nodeMapOut, root.left, result);
            }
            left = nodeMapOut.get(root.left)[2];
        }
        if (root.right != null) {
            if (nodeMapOut.get(root.right) == null || nodeMapOut.get(root.right)[2] == 0) {
                core(nodeMapOut, root.right, result);
            }
            right = nodeMapOut.get(root.right)[2];
        }

        if (nodeMapOut.get(root) == null) {
            nodeMapOut.put(root, new int[3]);
        }
        nodeMapOut.get(root)[2] = Math.max(left + root.val, right + root.val);
        if (nodeMapOut.get(root)[2] > result[0]) {
            result[0] = nodeMapOut.get(root)[2];
        }
    }

    public void core2(Map<TreeNode, int[]> nodeMapOut, TreeNode root, int[] result, int fatherIn) {
        if (root == null) {
            return;
        }
        Integer leftIn = 0;
        Integer rightIn = 0;

        if (root.left != null) {
            leftIn = nodeMapOut.get(root.left)[2];
        }
        if (root.right != null) {
            rightIn = nodeMapOut.get(root.right)[2];
        }

        Integer leftOut = 0;
        Integer rightOut = 0;

        leftOut = Math.max(rightIn + root.val, fatherIn + root.val);
        rightOut = Math.max(leftIn + root.val, fatherIn + root.val);

        if (leftOut > result[0]) {
            result[0] = leftOut;
        }
        if (rightOut > result[0]) {
            result[0] = rightOut;
        }

        if (root.left != null) {
            core2(nodeMapOut, root.left, result, leftOut);
        }
        if (root.right != null) {
            core2(nodeMapOut, root.right, result, rightOut);
        }
    }
}
