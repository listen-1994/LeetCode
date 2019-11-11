import LinkedList.TreeNode;
import sun.reflect.generics.tree.Tree;

import javax.transaction.TransactionRequiredException;
import java.util.ArrayList;
import java.util.List;

public class Problem99 {
    public void recoverTree(TreeNode root) {
        List<TreeNode> numberList = new ArrayList<>();
        core(root, numberList);
        if (numberList.size() == 0 || numberList.size() == 1) {
            return;
        }
        TreeNode first = null;
        TreeNode second = null;
        int i = 0;
        int j = numberList.size() - 1;
        while (i != j) {

            if (numberList.get(i).val > numberList.get(i + 1).val) {
                first = numberList.get(i);
            }
            if (numberList.get(j).val < numberList.get(j - 1).val) {
                second = numberList.get(j);
            }
            if (first == null) {
                i++;
            }
            if (second == null) {
                j--;
            }
            if(first!=null&&second!=null){
                break;
            }
        }
        if (first != null && second != null && first != second) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

    public void core(TreeNode root, List<TreeNode> numberList) {
        if (null == root) {
            return;
        }
        if (root.left != null) {
            core(root.left, numberList);
        }
        numberList.add(root);
        if (root.right != null) {
            core(root.right, numberList);
        }
    }

    public static void main(String[] args) {
        Problem99 problem99 = new Problem99();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        problem99.recoverTree(root);
    }
}
