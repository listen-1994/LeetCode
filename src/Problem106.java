import LinkedList.TreeNode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        List<Integer> pre = new ArrayList<>();
        List<Integer> ino = new ArrayList<>();
        for (int i = postorder.length - 1; i >= 0; i--) {
            pre.add(postorder[i]);
        }
        for (int i = 0; i < inorder.length; i++) {
            ino.add(inorder[i]);
        }
        return core(pre, ino);
    }

    public TreeNode core(List<Integer> preorder, List<Integer> inorder) {
        if (preorder == null || preorder.size() == 0) {
            return null;
        }
        TreeNode node = new TreeNode(preorder.get(0));

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        HashSet<Integer> leftSet = new HashSet<>();
        HashSet<Integer> rightSet = new HashSet<>();

        int index = 0;
        for (int i = 0; i < inorder.size(); i++) {
            if (inorder.get(i).compareTo(preorder.get(0)) == 0) {
                index = i;
                break;
            }
        }
        for (int i = 0; i < index; i++) {
            left.add(inorder.get(i));
            leftSet.add(inorder.get(i));
        }
        for (int i = index + 1; i < inorder.size(); i++) {
            right.add(inorder.get(i));
            rightSet.add(inorder.get(i));
        }

        List<Integer> leftPre = new ArrayList<>();
        List<Integer> rightPre = new ArrayList<>();
        for (Integer integer : preorder) {
            if (leftSet.contains(integer)) {
                leftPre.add(integer);
            }
            if (rightSet.contains(integer)) {
                rightPre.add(integer);
            }
        }
        node.left = core(leftPre, left);
        node.right = core(rightPre, right);
        return node;
    }

    public static void main(String[] args) {
        System.out.println(new BigDecimal("a.b"));
    }

}
