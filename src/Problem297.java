import LinkedList.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Problem297 {
    public String serialize(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        StringBuilder treeStringBuilder = new StringBuilder("[");
        dfs(treeStringBuilder, nodeQueue);
        //移除最后多出来的逗号
        if (treeStringBuilder.length() > 1) {
            treeStringBuilder.deleteCharAt(treeStringBuilder.length() - 1);
        }
        treeStringBuilder.append("]");
        return treeStringBuilder.toString();
    }

    public void dfs(StringBuilder treeStringBuilder, Queue<TreeNode> nodeQueue) {
        if (nodeQueue.isEmpty() || checkAllNull(nodeQueue)) {
            return;
        }
        TreeNode root = nodeQueue.poll();
        if (root == null) {
            treeStringBuilder.append("null,");
        } else {
            treeStringBuilder.append(root.val).append(",");
            nodeQueue.add(root.left);
            nodeQueue.add(root.right);
        }

        dfs(treeStringBuilder, nodeQueue);
    }

    public boolean checkAllNull(Queue<TreeNode> nodeQueue) {
        for (TreeNode treeNode : nodeQueue) {
            if (null != treeNode) {
                return false;
            }
        }
        return true;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (null == data || data.length() <= 2 || data.charAt(0) != '[' || data.charAt(data.length() - 1) != ']') {
            return null;
        }
        StringBuilder treeStringBuilder = new StringBuilder(data.trim());
        //移除最前和最后的方括号
        treeStringBuilder.deleteCharAt(0);
        treeStringBuilder.deleteCharAt(treeStringBuilder.length() - 1);
        if (treeStringBuilder.length() == 0) {
            return null;
        }
        String[] nodeArray = treeStringBuilder.toString().split(",");

        TreeNode root = new TreeNode(Integer.valueOf(nodeArray[0]));
        Queue<TreeNode> levelNodeQueue = new LinkedList<TreeNode>();
        levelNodeQueue.add(root);
        int i = 1;
        while (i < nodeArray.length) {
            Queue<TreeNode> newLevelQueue = new LinkedList<TreeNode>();
            while (!levelNodeQueue.isEmpty()) {
                TreeNode currentNode = levelNodeQueue.poll();
                if (i >= nodeArray.length) {
                    return root;
                }
                currentNode.left = generateTreeNode(nodeArray[i++]);
                if (i >= nodeArray.length) {
                    return root;
                }
                currentNode.right = generateTreeNode(nodeArray[i++]);
                newLevelAddNotNull(newLevelQueue, currentNode.left);
                newLevelAddNotNull(newLevelQueue, currentNode.right);
            }
            levelNodeQueue = newLevelQueue;
        }
        return root;
    }

    private void newLevelAddNotNull(Queue<TreeNode> newLevelQueue, TreeNode node) {
        if (null != node) {
            newLevelQueue.add(node);
        }
    }

    private TreeNode generateTreeNode(String nodeString) {
        if (nodeString.equals("null")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(nodeString));
    }

    public static void main(String[] args) {
        Problem297 problem297 = new Problem297();
        TreeNode root = problem297.deserialize("[1,2]");
        String nodeString = problem297.serialize(root);
        System.out.println(nodeString);
        //LinkedList
    }
}
