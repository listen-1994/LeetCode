/**
 * LeetCode 第50题 pow
 * 数学，二分查找
 *
 * 爆栈的时候，退一步再算
 */
public class Problem50 {
    public double myPow(double x, int n) {
        if (x == 1.0) {
            return x;
        }
        if (n < 0) {
            if(n==Integer.MIN_VALUE){
                return 1/x*myPow(x,n+1);
            }
            return 1.0 / myPow(x, -n);
        } else if (n == 0) {
            return 1;
        } else {
            double v = myPow(x, n / 2);
            if (n % 2 == 1) {
                return v * v * x;
            } else {
                return v * v;
            }
        }
    }

    public static void main(String[] args) {
        Problem50 problem50 = new Problem50();
        System.out.println(problem50.myPow(2.0, -2147483648));
    }
}
