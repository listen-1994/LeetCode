/**
 * LeetCode 第38题 报数
 * 字符串
 */
public class Problem38 {
    public static final String FIRST = "1";

    public String countAndSay(int n) {
        if (n == 1) {
            System.out.println(FIRST);
            return FIRST;
        } else {
            String front = countAndSay(n - 1);
            String result = "";
            int count = 1;
            for (int i = 1; i < front.length(); i++) {
                if (front.charAt(i) != front.charAt(i - 1)) {
                    result = result + String.valueOf(count) + front.charAt(i - 1);
                    count = 1;
                } else {
                    count++;
                }
            }
            result = result + String.valueOf(count) + front.charAt(front.length() - 1);
            return result;
        }
    }

    public static void main(String[] args) {
        Problem38 problem38 = new Problem38();
        System.out.println(problem38.countAndSay(4));
    }
}
