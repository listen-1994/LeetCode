import java.util.HashMap;
import java.util.Map;

public class Problem128 {

    //稀疏，跨度大，则时间复杂度和空间复杂度爆炸
    /*public int longestConsecutive(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        int[] save = new int[max - min + 1];
        if (save.length == 1) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            save[nums[i] - min] = 1;
        }
        int result = 0;
        int tmpResult = 0;
        for (int i = 0; i < save.length; i++) {
            if (save[i] == 1) {
                tmpResult++;
                if (tmpResult > result) {
                    result = tmpResult;
                }
            }
            if (save[i] == 0) {
                tmpResult = 0;
            }
        }
        return result;
    }
*/
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> save = new HashMap<>();
        for (int num : nums) {
            save.put(num, 1);
        }
        int result = 0;
        for (int num : nums) {
            if (num == Integer.MIN_VALUE) {
                continue;
            }
            Integer tmp = merge(num, save);
            if (tmp > result) {
                result = tmp;
            }
        }
        return result;
    }

    public Integer merge(Integer current, Map<Integer, Integer> save) {
        if (null == save.get(current)) {
            return 0;
        }
        if (save.get(current) > 1) {
            return save.get(current);
        }
        Integer currentSum = merge(current - 1, save) + 1;
        save.put(current, currentSum);
        return currentSum;
    }


    public static void main(String[] args) {
        Problem128 problem128 = new Problem128();
        Integer result = problem128.longestConsecutive(new int[]{2147483646, -2147483647, 0, 2, 2147483644, -2147483645, 2147483645});
        System.out.println(result);
    }
}
