package DynamicProgramming;

/**
 * LeetCode 第70题
 * 爬楼梯
 */
public class ClimbingStairs {
    int[] sav;
    public int climbStairs(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        sav=new int[n];
        sav[0]=1;
        sav[1]=2;

        for(int i=2;i<n;i++){
            sav[i]=sav[i-1]+sav[i-2];
        }
        return sav[n-1];
    }

    public static void main(String[] args){
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(1));
    }
}
