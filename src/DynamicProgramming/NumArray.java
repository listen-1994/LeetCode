package DynamicProgramming;

/**
 * LeetCode 第303题
 * 数组不可变
 */
public class NumArray {
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }

    /**
     * 其实应该把结果存一下，提高计算速度
     * @param i
     * @param j
     * @return
     */
    public int sumRange(int i, int j) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int result = 0;
        for(int k=i;k<=j;k++){
            result+=nums[k];
        }
        return result;
    }
}
