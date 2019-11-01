import javax.annotation.processing.SupportedSourceVersion;
import java.util.*;

public class Problem90 {
    //超时
/*    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Map<Integer, List<Map<Integer, Integer>>> mapResult = new HashMap<>();
        int[] check = new int[nums.length];
        core(mapResult, check, nums);
        return mapResult2ResultList(mapResult);
    }

    public void core(Map<Integer, List<Map<Integer, Integer>>> mapResult, int[] check, int[] nums) {
        uniquePut(mapResult, convert2Map(check, nums));
        for (int i = 0; i < nums.length; i++) {
            if (check[i] != 1) {
                Map<Integer, Integer> subMap = new HashMap<>();
                subMap.put(nums[i], 1);
                uniquePut(mapResult, subMap);
                check[i] = 1;
                core(mapResult, check, nums);
                check[i] = 0;
            }
        }
    }

    public Map<Integer, Integer> convert2Map(int[] check, int[] nums) {
        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < check.length; i++) {
            if (check[i] != 1) {
                if (result.get(nums[i]) == null) {
                    result.put(nums[i], 0);
                }
                result.put(nums[i], result.get(nums[i]) + 1);
            }
        }
        return result;
    }

    public List<List<Integer>> mapResult2ResultList(Map<Integer, List<Map<Integer, Integer>>> mapResult) {
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Map<Integer, Integer>>> entry : mapResult.entrySet()) {
            Integer size = entry.getKey();
            List<Map<Integer, Integer>> valueList = entry.getValue();
            for (Map<Integer, Integer> value : valueList) {
                List<Integer> tmp = new ArrayList<>(size);
                if (value.size() == 0) {
                    result.add(tmp);
                    continue;
                }
                for (Map.Entry<Integer, Integer> subEntry : value.entrySet()) {
                    Integer count = subEntry.getValue();
                    Integer num = subEntry.getKey();
                    for (int i = 0; i < count; i++) {
                        tmp.add(num);
                    }
                }
                result.add(tmp);
            }
        }

        return result;
    }

    public void uniquePut(Map<Integer, List<Map<Integer, Integer>>> mapResult, Map<Integer, Integer> item) {
        if (contains(mapResult, item)) {
            return;
        }
        Integer key = 0;
        for (Map.Entry<Integer, Integer> entry : item.entrySet()) {
            key += entry.getValue();
        }
        if (mapResult.get(key) == null) {
            List<Map<Integer, Integer>> tmp = new ArrayList<>();
            mapResult.put(key, tmp);
        }
        mapResult.get(key).add(item);
    }

    public Boolean contains(Map<Integer, List<Map<Integer, Integer>>> mapResult, Map<Integer, Integer> item) {
        Integer key = 0;
        for (Map.Entry<Integer, Integer> entry : item.entrySet()) {
            key += entry.getValue();
        }

        List<Map<Integer, Integer>> subList = mapResult.get(key);

        if (subList == null) {
            return false;
        }
        for (Map<Integer, Integer> map : subList) {
            if (mapEquals(map, item)) {
                return true;
            }
        }

        return false;
    }

    public Boolean mapEquals(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            Integer key = entry.getKey();
            Integer count = entry.getValue();

            Integer map2Count = map2.get(key);
            if (count != map2Count) {
                return false;
            }
        }
        return true;
    }*/

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        Set<Integer> checkSet = new HashSet<>();
        Set<Integer> numsSet = new HashSet<>();
        for (Integer integer : nums) {

            if (numsMap.get(integer) == null) {
                numsMap.put(integer, 0);
            }
            numsMap.put(integer, numsMap.get(integer) + 1);
        }

        numsSet.addAll(numsMap.keySet());

        List<List<Integer>> result = new LinkedList<>();
        List<Integer> currentResult = new LinkedList<>();
        core(result, numsMap, currentResult, checkSet);
        return result;
    }

    public void core(List<List<Integer>> result, Map<Integer, Integer> numsMap, List<Integer> currentResult, Set<Integer> checkSet) {
        result.add(currentResult);
        for (Integer integer : numsMap.keySet()) {
            if (checkSet.contains(integer)) {
                continue;
            }
            checkSet.add(integer);
            List<Integer> tmp = new LinkedList<>();
            for (int i = 1; i <= numsMap.get(integer); i++) {
                tmp.add(integer);
                List<Integer> nextResult = new LinkedList<>(currentResult);
                nextResult.addAll(tmp);
                core(result, numsMap, nextResult, new HashSet<Integer>(checkSet));
            }
        }
    }


    public static void main(String[] args) {
        Problem90 problem90 = new Problem90();
        System.out.println(problem90.subsetsWithDup(new int[]{1, 1, 2, 2}));
    }
}
