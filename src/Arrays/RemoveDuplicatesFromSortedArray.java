package Arrays;


/**
 * LeetCode 第26题
 * 删除重复数组中的重复项
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 1;
        while (i < nums.length) {
            if (nums[i] == nums[j - 1]) {
                i++;
            } else {
                nums[j] = nums[i];
                i++;
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args){
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
