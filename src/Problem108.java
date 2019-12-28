public class Problem108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (null == nums || nums.length == 0) {
            return null;
        }
        return core(nums, 0, nums.length - 1);
    }

    public TreeNode core(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int half = (left + right) / 2;
        TreeNode treeNode = new TreeNode(nums[half]);

        treeNode.left = core(nums, left, half - 1);
        treeNode.right = core(nums, half + 1, right);
        return treeNode;
    }
}
