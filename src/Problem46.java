import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 第46题 全排列
 * 回溯算法
 */
public class Problem46 {
    public List<List<Integer>> permute(int[] nums) {

        return core(nums, new LinkedList<Integer>());
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
