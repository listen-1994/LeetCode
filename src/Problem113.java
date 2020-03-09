import LinkedList.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(resultList, root, sum, 0, new ArrayList<Integer>());
        return resultList;
    }

    public void dfs(List<List<Integer>> resultList, TreeNode root, int sum, int subSum, List<Integer> subResult) {
        if (null == root) {
            return;
        }
        if (null == root.left && null == root.right) {
            if (subSum + root.val == sum) {
                subResult.add(root.val);
                resultList.add(subResult);
            }
            return;
        }

        subResult.add(root.val);
        List<Integer> subResultRight = new ArrayList<>(subResult);
        dfs(resultList, root.left, sum, subSum + root.val, subResult);
        dfs(resultList, root.right, sum, subSum + root.val, subResultRight);
    }

    public static void main(String[] args) {
        Problem113 problem113 = new Problem113();
        TreeNode root = new TreeNode(-2);
        TreeNode right = new TreeNode(-3);
        root.right = right;

        List<List<Integer>> result = problem113.pathSum(root, -5);
        System.out.println(result);
    }


}
