/**
 * LeetCode 第74题 搜索二维矩阵
 * 二分查找问题
 * 击败了99.58% 的用户
 * 代码写的太丑陋了，有空拿递归重写一遍吧
 */
public class Problem74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m==0){
            return false;
        }
        int n = matrix[0].length;
        if(n==0){
            return false;
        }
        int pointP = 0;
        int pointQ = m - 1;
        while (pointQ - pointP > 1) {
            int half = (pointP + pointQ) / 2;
            if (target >= matrix[half][0] && target <= matrix[pointQ][n-1]) {
                pointP = half;
                continue;
            }
            if (target <= matrix[half][n-1] && target >= matrix[pointP][0]) {
                pointQ = half;
                continue;
            }
            return false;
        }
        if (pointQ - pointP == 1) {
            if (target >= matrix[pointQ][0] && target <= matrix[pointQ][n-1]) {
                pointP = pointQ;
            } else if (target >= matrix[pointP][0] && target <= matrix[pointP][n-1]) {
                pointQ = pointP;
            } else {
                return false;
            }
        }

        int pointX = 0;
        int pointY = n - 1;
        while (pointY - pointX > 1) {
            int half = (pointY + pointX) / 2;
            if (matrix[pointP][pointX] <= target && matrix[pointP][half] >= target) {
                pointY = half;
                continue;
            }
            if (matrix[pointP][half] <= target && matrix[pointP][pointY] >= target) {
                pointX = half;
                continue;
            }
            return false;
        }

        return matrix[pointP][pointX] == target || matrix[pointP][pointY] == target;
    }
}
