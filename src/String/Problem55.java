package String;

/**
 * LeetCode 第55题 跳跃游戏
 * 贪心算法 数组
 */
public class Problem55 {
    public boolean canJump(int[] nums) {
        return core(nums,0);
    }

    public boolean core(int[] nums, int k) {
        int length = nums[k];
        if (k + length >= nums.length - 1) {
            return true;
        }
        if(nums[k]==0){
            return false;
        }
        int max = 0;
        int point = k + 1;
        for (int i = 1; i <= length; i++) {
            if (i + nums[k + i] > max) {
                max = i + nums[k + i];
                point = k + i;
            }
        }
        if (nums[point] == 0) {
            return false;
        }
        return core(nums, point);
    }
}
