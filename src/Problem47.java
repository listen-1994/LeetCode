import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 47.全排列II
 * 回溯算法
 */
public class Problem47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = core(nums, new LinkedList<Integer>());
        List<List<Integer>> returnresult = new LinkedList<>();
        for (List<Integer> list : result) {
            if (returnresult.contains(list)) {
                continue;
            } else {
                returnresult.add(list);
            }
        }
        return returnresult;
    }

    public List<List<Integer>> core(int[] nums, LinkedList<Integer> index) {
        LinkedList<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!index.contains(i)) {
                index.add(i);
                List<List<Integer>> subResult = core(nums, index);
                if (subResult.size() != 0) {
                    for (List<Integer> list : subResult) {
                        list.add(nums[i]);
                    }
                    result.addAll(subResult);
                } else {
                    LinkedList<Integer> list = new LinkedList<Integer>();
                    list.add(nums[i]);
                    result.add(list);
                }
                index.removeLast();
            }
        }
        return result;
    }
}
