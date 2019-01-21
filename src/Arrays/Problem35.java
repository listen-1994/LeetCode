package Arrays;

/**
 * LeetCode 第35题
 * 搜索插入位置
 * 数组 二分查找
 */
public class Problem35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return core(nums, target, 0, nums.length - 1);
    }

    public int core(int[] nums, int target, int begin, int end) {

        if (begin == end) {
            if (nums[begin] == target) {
                return begin;
            } else {
                if (target < nums[begin]) {
                    return begin;
                } else {
                    return end + 1;
                }
            }
        }
        int index = (begin + end) / 2;
        if (nums[index] > target) {
            if(begin>index-1){
                return begin;
            }
            return core(nums, target, begin, index - 1);
        } else if (nums[index] < target) {
            if(index+1>end){
                return end+1;
            }
            return core(nums, target, index + 1, end);
        } else {
            return index;
        }
    }

    public static void main(String[] args) {
        Problem35 problem35 = new Problem35();
        System.out.println(problem35.searchInsert(new int[]{1,3},0));
    }
}