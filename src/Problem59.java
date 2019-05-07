/**
 * LeetCode 第59题 螺旋矩阵II
 * 中等
 * 数组
 */
public class Problem59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        core(result, 0, 1, n);
        return result;
    }

    public void core(int[][] result, int index, int num, int n) {
        if (index > n - 1 - index) {
            return;
        }
        for (int i = index; i < n - index; i++) {
            result[index][i] = num++;
        }
        for (int i = index + 1; i < n - index; i++) {
            result[i][n - 1 - index] = num++;
        }
        for (int i = n - 2 - index; i >= index; i--) {
            result[n - 1 - index][i] = num++;
        }
        for (int i = n - 2 - index; i >= index + 1; i--) {
            result[i][index] = num++;
        }
        core(result, index + 1, num, n);
    }
}
