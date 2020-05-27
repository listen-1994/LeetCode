import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem295 {
    //第一次提交
/*    static class MedianFinder {

        Integer medianIndex;
        Boolean flag;
        List<Double> numList;

        */

    /**
     * initialize your data structure here.
     *//*
        public MedianFinder() {
            medianIndex = -1;
            flag = true;
            numList = new ArrayList<>();
        }

        public Boolean checkOddSize() {
            return !flag;
        }

        public Boolean checkEvenSize() {
            return flag;
        }

        public void addNum(int num) {
            if (checkOddSize()) {
                insertNum(num);
            } else {
                insertNum(num);
                medianIndex++;
            }
            flag = !flag;
        }

        public double findMedian() {
            if (numList.isEmpty()) {
                return 0L;
            }
            System.out.println("medianIndex:" + medianIndex);
            System.out.println(numList);
            if (checkOddSize()) {
                return numList.get(medianIndex);
            }
            return (numList.get(medianIndex) + numList.get(medianIndex + 1)) / 2;
        }

        public void insertNum(double num) {
            int beginSize = numList.size();
            boolean added = false;
            for (int i = 0; i < beginSize; i++) {
                if (numList.get(i) >= num) {
                    numList.add(i, num);
                    added = true;
                    break;
                }
            }
            if (!added) {
                numList.add(num);
            }
        }

    }*/

    /**
     * 使用树型结构动态调整，查询时间变为log（n）
     */
    static class MedianFinder {
        TreeNode root;
        boolean oddFlag;
        int leftNum;
        int rightNum;

        class TreeNode {
            TreeNode left;
            TreeNode right;
            TreeNode father;
            int val;

            TreeNode(int val, TreeNode father) {
                this.val = val;
                this.father = father;
            }
        }

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            if (root == null) {
                root = new TreeNode(num, null);
            } else {
                if (num < root.val) {
                    leftNum++;
                } else {
                    rightNum++;
                }
                insertNum(num, root);
            }

            reBalance();
            oddFlag = !oddFlag;
        }

        public TreeNode findLeftMax(TreeNode root) {
            if (root.right != null) {
                return findLeftMax(root.right);
            }
            return root;
        }

        public TreeNode findRightMin(TreeNode root) {
            if (root.left != null) {
                return findRightMin(root.left);
            }
            return root;
        }

        public void insertNum(int num, TreeNode root) {
            if (num < root.val) {
                if (root.left == null) {
                    root.left = new TreeNode(num, root);
                } else {
                    insertNum(num, root.left);
                }
            } else {
                if (root.right == null) {
                    root.right = new TreeNode(num, root);
                } else {
                    insertNum(num, root.right);
                }
            }
        }


        public void reBalance() {
            if (leftNum == rightNum + 1) {
                TreeNode leftMaxNode = findLeftMax(root.left);
                if (leftMaxNode == root.left) {
                    leftMaxNode.right = root;
                    root.father = leftMaxNode;
                    leftMaxNode.father = null;
                    root.left = null;
                    root = leftMaxNode;
                    leftNum--;
                    rightNum++;
                    return;
                }
                leftMaxNode.father.right = null;
                if (leftMaxNode.left != null) {
                    leftMaxNode.left.father = leftMaxNode.father;
                    leftMaxNode.father.right = leftMaxNode.left;
                }
                leftMaxNode.left = root.left;

                leftMaxNode.father = null;

                leftMaxNode.right = root;
                root.father = leftMaxNode;

                root.left = null;

                root = leftMaxNode;
                leftNum--;
                rightNum++;
            }
            if (rightNum == leftNum + 2) {
                TreeNode rightMinNode = findRightMin(root.right);
                if (rightMinNode == root.right) {
                    rightMinNode.left = root;
                    root.father = rightMinNode;
                    rightMinNode.father = null;
                    root.right = null;
                    root = rightMinNode;
                    rightNum--;
                    leftNum++;
                    return;
                }
                rightMinNode.father.left = null;
                if (rightMinNode.right != null) {
                    rightMinNode.right.father = rightMinNode.father;
                    rightMinNode.father.left = rightMinNode.right;
                }

                rightMinNode.right = root.right;

                rightMinNode.father = null;
                rightMinNode.left = root;
                root.father = rightMinNode;
                root.right = null;
                root = rightMinNode;
                rightNum--;
                leftNum++;
            }
        }


        public double findMedian() {
            if (oddFlag) {
                return (double) root.val;
            }
            return (double) (root.val + findRightMin(root.right).val) / 2;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        Double result;
        List<Integer> numList = Arrays.asList(6, 10, 2, 6, 5, 0, 6, 3, 1, 0, 0, 6, 3, 1, 0, 0);
        for (Integer integer : numList) {
            medianFinder.addNum(integer);
            result = medianFinder.findMedian();
            System.out.println(result);
        }
    }
}
