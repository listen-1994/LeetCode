/**
 * LeetCode 第45题 跳跃游戏II
 * 贪心算法 数组
 */
public class Problem45 {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        return core(nums, 0);
    }

    public int core(int[] nums, int k) {
        int length = nums[k];
        if (k + length >= nums.length - 1) {
            return 1;
        }
        int max = 0;
        int point = k + 1;
        for (int i = 1; i <= length; i++) {
            if (i + nums[k + i] > max && nums[k + i] != 0) {
                max = i + nums[k + i];
                point = k + i;
            }
        }
        return core(nums, point) + 1;
    }
}
