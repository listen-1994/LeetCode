package Arrays;

/**
 * LeetCode 第31题
 * 下一个排列
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    System.out.println("i:" + i + ",j:" + j);
                    for (int k = 0; k < (nums.length - 1 - i) / 2; k++) {
                        System.out.println("1:" + (i + 1 + k) + ",2:" + (nums.length - 1 - k));
                        int tmp2 = nums[i + 1 + k];
                        nums[i + 1 + k] = nums[nums.length - 1 - k];
                        nums[nums.length - 1 - k] = tmp2;
                    }
                    return;
                }
            }
        }

        for (int i = 0; i < nums.length / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = tmp;
        }
        return;
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(new int[]{1, 3, 2});
    }
}
