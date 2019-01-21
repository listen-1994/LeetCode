package DynamicProgramming;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * LeetCode 第279题
 * 完全平方数
 * 回溯转dp  ´ ▽ ` )ﾉ
 */
public class PerfectSquares {
    int[] dp;

    public int numSquares(int n) {
        dp = new int[n + 1];
        core(n);
        return dp[n];
    }

    public void core(int n) {
        int result = Integer.MAX_VALUE;
        int i = 1;
        int a = i * i;
        while (a <= n) {
            if (a == n) {
                dp[n] = 1;
                return;
            }
            if(dp[n-a]==0){
                core(n-a);
            }
            if (dp[n-a]+1<result) {
                result = dp[n-a]+1;
            }
            i++;
            a=i*i;
        }
        dp[n]=result;
    }

    public static void main(String[] args){
        PerfectSquares perfectSquares = new PerfectSquares();
        System.out.println(perfectSquares.numSquares(13));
    }
}
