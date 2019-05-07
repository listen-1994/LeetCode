package DynamicProgramming;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 第95题
 * 不同的二叉搜索树II
 */

/**
 * 这道题其实是个递归问题，而不是DP问题
 */
public class UniqueBinarySearchTreesII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {

        return core(1,n);
    }

    public List<TreeNode> core(int begin,int end){
        List<TreeNode> list = new LinkedList<>();
        if(begin>end){
            return list;
        }
        for(int i=begin;i<=end;i++){
            List<TreeNode> leftList = core(begin,i-1);
            List<TreeNode> rightList = core(i+1,end);
            if(rightList.size()==0&&leftList.size()==0){
                list.add(new TreeNode(i));
                continue;
            }
            if(rightList.size()==0&&leftList.size()!=0){
                for(TreeNode leftNode:leftList){
                    TreeNode root = new TreeNode(i);
                    root.left=leftNode;
                    list.add(root);
                }
                continue;
            }
            if(leftList.size()==0&&rightList.size()!=0){
                for(TreeNode rightNode:rightList){
                    TreeNode root = new TreeNode(i);
                    root.right=rightNode;
                    list.add(root);
                }
                continue;
            }
            for(TreeNode rightNode:rightList){
                for(TreeNode leftNode:leftList){
                    TreeNode root = new TreeNode(i);
                    root.left=leftNode;
                    root.right=rightNode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
