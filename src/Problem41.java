/**
 * LeetCode 第41题 缺失的第一个正数
 * 数组
 */
public class Problem41 {
    public int firstMissingPositive(int[] nums) {
        int n = 1024 * 1024 * 8 / 32;
        int[] check = new int[n];
        int result = 0;
        for (int i : nums) {
            if (i > 0) {
                check[i - 1] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (check[i] == 0) {
                result = i + 1;
                break;
            }
        }
        return result;
    }
}
