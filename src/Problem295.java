import java.util.ArrayList;
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

    static class MedianFinder {
        TreeNode root;
        boolean oddFlag;

        class TreeNode {
            TreeNode left;
            TreeNode right;
            int val1;
            Integer val2;

            TreeNode(int val1) {
                this.val1 = val1;
            }
        }

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            if (root == null) {
                root = new TreeNode(num);
            } else {
                insertNum(num, root);
            }
            if (num <= root.val1) {
            } else {
            }

            oddFlag = !oddFlag;
        }

        public TreeNode insertNum(int num, TreeNode root) {
            if (num <= root.val) {
                if (null == root.left) {
                    root.left = new TreeNode(num);
                } else {
                    insertNum(num, root.left);
                }
            } else {
                if (null == root.right) {
                    root.right = new TreeNode(num);
                } else {
                    insertNum(num, root.right);
                }
            }
        }

        public double findMedian() {
            if (oddFlag) {
                return (double) root.val;
            }
            return (double) (root.val + root.right.val) / 2;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        Double result;
        for (int i = -1; i > -6; i--) {
            medianFinder.addNum(i);
            result = medianFinder.findMedian();
            System.out.println(result);
        }
    }
}
