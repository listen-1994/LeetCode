package DynamicProgramming;

import java.util.*;

/**
 * LeetCode 第264题
 * 丑数II
 * 击败2.44%的用户，越来越丑陋了╮(￣▽￣)╭
 */
public class UglyNumberII {

    public int nthUglyNumber(int n) {
        int num1 = Integer.MAX_VALUE/2;
        int num2 = Integer.MAX_VALUE/3;
        int num3 = Integer.MAX_VALUE/5;
        if (n == 1) {
            return 1;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);

        for (int i = 2; i <= n; i++) {
            int p = queue.poll();

            if (p<num1&&!queue.contains(p * 2)) {
                queue.add(p * 2);
            }
            if (p<num2&&!queue.contains(p * 3)) {
                queue.add(p * 3);
            }
            if (p<num3&&!queue.contains(p * 5)) {
                queue.add(p * 5);
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        UglyNumberII uglyNumberII = new UglyNumberII();
        System.out.println(uglyNumberII.nthUglyNumber(1407));
    }
}
