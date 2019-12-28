import LinkedList.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root==null){
            return result;
        }
        List<TreeNode> visit = new ArrayList<>();
        visit.add(root);
        while(!visit.isEmpty()){
            List<Integer> subResult = new ArrayList<>();
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode treeNode : visit) {
                if (null!=treeNode.left){
                    next.add(treeNode.left);
                }
                if (null!=treeNode.right){
                    next.add(treeNode.right);
                }
                subResult.add(treeNode.val);
            }
            result.add(0,subResult);
            visit = next;
        }
        return result;
    }
}
