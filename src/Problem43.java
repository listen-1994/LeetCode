import java.util.LinkedList;

/**
 * LeetCode 第43题 字符串相乘
 * 数学，字符串
 */
public class Problem43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        LinkedList<String> resultList = new LinkedList<>();
        for (int i = num2.length() - 1; i >= 0; i--) {
            resultList.add(oneMultiply(num1, num2.substring(i, i + 1)));
        }
        return add(resultList);
    }

    public String oneMultiply(String num1, String num2) {
        LinkedList<String> result = new LinkedList<>();
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int b = Integer.valueOf(num2);
        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = Integer.valueOf(num1.substring(i, i + 1));
            result.add(String.valueOf(a * b));
        }
        return add(result);
    }

    public String add(LinkedList<String> resultList) {
        String result = resultList.get(0);
        String digits = "0";
        for (int i = 1; i < resultList.size(); i++) {
            result = stringAdd(resultList.get(i) + digits, result);
            digits += "0";
        }
        return result;
    }

    public String stringAdd(String num1, String num2) {
        String result = "";
        if (num1.length() > num2.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        int carry = 0;
        for (int j = 0; j < num1.length(); j++) {
            int digit1 = num1.charAt(num1.length() - 1 - j) - '0';
            int digit2 = num2.charAt(num2.length() - 1 - j) - '0';
            int a = digit1 + digit2 + carry;
            if (a > 9) {
                carry = 1;
                char subResult = (char) ('0' + a - 10);
                result = String.valueOf(subResult) + result;
            } else {
                carry = 0;
                char subResult = (char) (a + '0');
                result = String.valueOf(subResult) + result;
            }
        }
        for (int j = num1.length(); j < num2.length(); j++) {
            int digit2 = num2.charAt(num2.length() - 1 - j) - '0';
            int a = digit2 + carry;
            if (a > 9) {
                carry = 1;
                char subResult = (char) ('0' + (a - 10));
                result = String.valueOf(subResult) + result;
            } else {
                carry = 0;
                char subResult = (char) ('0' + a);
                result = String.valueOf(subResult) + result;
            }
        }
        if (carry == 1) {
            result = "1" + result;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem43 problem43 = new Problem43();
        System.out.println(problem43.multiply("881095803", "61"));
    }
}
