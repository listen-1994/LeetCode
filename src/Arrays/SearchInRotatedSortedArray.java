package Arrays;

/**
 * LeetCode 第33题
 * 搜索旋转排序数组
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        return core(nums, target, 0, nums.length - 1);
    }

    public int core(int[] nums, int target, int begin, int end) {
        if (begin == end) {
            if (nums[begin] != target) {
                return -1;
            } else {
                return begin;
            }
        }
        int index = (begin + end) / 2;
        int half = nums[index];
        if (half >= nums[begin]) {
            if (target >= nums[begin] && target <= half) {
                return core(nums, target, begin, index);
            } else {
                return core(nums, target, index + 1, end);
            }
        } else {
            if (target >= half && target <= nums[end]) {
                return core(nums, target, index, end);
            } else {
                return core(nums, target, begin, index - 1);
            }
        }
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        System.out.println(searchInRotatedSortedArray.search(new int[]{4,5,6,7,0,1,2}, 3));
    }
}
