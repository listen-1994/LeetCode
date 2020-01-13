import java.util.Stack;

public class Problem224 {
    private static final char plus = '+';
    private static final char minus = '-';
    private static final char leftBrackets = '(';
    private static final char rightBrackets = ')';

    public int calculate(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        //存放后缀
        Stack<String> s2 = new Stack<>();
        //存放操作数
        Stack<String> s1 = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (checkOperateChar(currentChar)) {
                sb.append(currentChar);
                s2.push(sb.toString());
                sb = new StringBuilder();
                String currentOperateChar = s1.isEmpty()?null:s1.peek();
                if (currentChar == leftBrackets) {
                    s1.push(String.valueOf(currentChar));
                    continue;
                }
                if (currentChar == plus || currentChar == minus) {
                    if (null == currentOperateChar || stringEqualsChar(currentOperateChar, leftBrackets)) {
                        s1.push(String.valueOf(currentChar));
                        continue;
                    }
                    if (stringEqualsChar(currentOperateChar, plus) || stringEqualsChar(currentOperateChar, minus)) {
                        s1.pop();
                        s1.push(String.valueOf(currentChar));
                        s2.push(currentOperateChar);
                        continue;
                    }
                }
                if (currentChar == rightBrackets) {
                    s1.pop();
                    s1.pop();
                    s2.push(currentOperateChar);
                }
            } else {
                sb.append(currentChar);
            }
        }
        return 0;
    }

    private boolean checkOperateChar(char checkChar) {
        return checkChar == plus || checkChar == minus || checkChar == leftBrackets || checkChar == rightBrackets;
    }

    private boolean stringEqualsChar(String checkString, char checkChar) {
        if (null == checkString) {
            return false;
        }
        return checkString.equals(String.valueOf(checkChar));
    }

    public static void main(String[] args) {
        Problem224 problem224 = new Problem224();
        problem224.calculate("(1+(4+5+2)-3)+(6+8)");
    }
}
