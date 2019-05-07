package BackTracking;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 第40题 组合总和II
 * 数组，回溯算法
 */
public class Problem40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = core(candidates, target, 0);
        List<List<Integer>> returnresult = new LinkedList<>();
        for (List<Integer> list : result) {
            Collections.sort(list);
            if (returnresult.contains(list)) {
                continue;
            } else {
                returnresult.add(list);
            }
        }
        return returnresult;
    }

    public List<List<Integer>> core(int[] candidates, int target, int index) {
        if (target < 0) {
            return null;
        }
        if (target == 0) {
            LinkedList<List<Integer>> result = new LinkedList<>();
            result.add(new LinkedList<Integer>());
            return result;
        }
        LinkedList<List<Integer>> result = new LinkedList<>();
        for (int i = index; i < candidates.length; i++) {
            List<List<Integer>> subResult = core(candidates, target - candidates[i], i + 1);
            if (subResult != null) {
                for (List<Integer> list : subResult) {
                    list.add(candidates[i]);
                }
                result.addAll(subResult);
            }
        }
        return result;
    }
}
