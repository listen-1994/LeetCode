package BackTracking;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 第39题 组合总和
 * 数组，回溯算法
 */
public class Problem39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return core(candidates, target, 0);
    }

    public List<List<Integer>> core(int[] candidates, int target, int index) {
        if (target < 0) {
            return null;
        }
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (target == 0) {
            result.add(new LinkedList<Integer>());
            return result;
        }
        for (int i = index; i < candidates.length; i++) {
            List<List<Integer>> subResult = core(candidates, target - candidates[i], i);
            if (subResult != null) {
                for (List<Integer> list : subResult) {
                    list.add(candidates[i]);
                }
                result.addAll(subResult);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem39 problem39 = new Problem39();
        System.out.println(problem39.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public void printArray(int[] candidates) {
        for (int i = 0; i < candidates.length; i++) {
            System.out.print(candidates[i]);
        }
        System.out.println();
    }
}
