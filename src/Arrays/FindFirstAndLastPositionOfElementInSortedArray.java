package Arrays;

/**
 * LeetCode 第34题
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        int index = core(nums, target, 0, nums.length - 1);
        if (index == -1) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        for (int i = index; i >= 0; i--) {
            if (nums[i] == target) {
                result[0] = i;
            } else {
                break;
            }
        }
        for (int j = index; j < nums.length; j++) {
            if (nums[j] == target) {
                result[1] = j;
            } else {
                break;
            }
        }
        return result;
    }

    public int core(int[] nums, int target, int begin, int end) {
        if(begin>end){
            return -1;
        }
        if (begin == end) {
            if (nums[begin] != target) {
                return -1;
            } else {
                return begin;
            }
        }

        int halfIndex = (begin + end) / 2;
        if (target > nums[halfIndex]) {
            return core(nums, target, halfIndex + 1, end);
        } else if (target == nums[halfIndex]) {
            return halfIndex;
        } else {
            return core(nums, target, begin, halfIndex - 1);
        }
    }
}
