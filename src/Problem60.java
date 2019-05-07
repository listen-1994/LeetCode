import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 第60题 第K个排列
 * 中等
 * 数学 回溯算法
 */
public class Problem60 {
    public String getPermutation(int n, int k) {
        List<Integer> list = new LinkedList<>();
        String result = "";
        int check = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            check *= i;
        }
        for (int i = n; i >= 1; i--) {
            check = check / i;
            int index = (k - 1) / check;
            k = k % check;
            if (k == 0) {
                k = check;
            }
            result += list.get(index);
            list.remove(index);
        }
        return result;
    }

    public static void main(String[] args) {
        Problem60 problem60 = new Problem60();
        System.out.println(problem60.getPermutation(3, 3));
    }
}
