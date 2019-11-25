import LinkedList.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class Problem105 {

    //超时
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        List<Integer> pre = new ArrayList<>();
        List<Integer> ino = new ArrayList<>();
        for (Integer integer : preorder) {
            pre.add(integer);
        }
        for (Integer integer : inorder) {
            ino.add(integer);
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
        /*Problem105 problem105 = new Problem105();
        problem105.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});*/
        String pre = "[1,9](\\d*)$|[1,9](\\d*\\.\\d*)$|[0](.\\d*)[1,9]$";
        Boolean result = Pattern.matches(pre, "0.00");
        System.out.println(result);
    }
}
