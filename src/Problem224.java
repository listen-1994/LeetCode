import java.util.ArrayList;
import java.util.List;
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
        List<String> s2 = new ArrayList<>();
        //存放操作数
        Stack<String> s1 = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar==' '){
                continue;
            }
            if (checkOperateChar(currentChar)) {
                if(sb.length()!=0){
                    s2.add(sb.toString());
                }
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
                        s2.add(currentOperateChar);
                        continue;
                    }
                }
                if (currentChar == rightBrackets) {
                    while(!s1.peek().equals(String.valueOf(leftBrackets))){
                        s1.pop();
                    }
                    s1.pop();
                    if (!currentOperateChar.equals(String.valueOf(leftBrackets))){
                        s2.add(currentOperateChar);
                    }
                }
            } else {
                sb.append(currentChar);
            }
        }
        if (sb.length()!=0){
            s2.add(sb.toString());
        }
        while(!s1.isEmpty()){
            s2.add(s1.pop());
        }
        Stack<Integer> integerStack = new Stack<>();
        Integer operate1 = 0;
        Integer operate2 = 0;
        for (String s3 : s2) {
            if (checkOperateChar(s3)){
                operate1 = integerStack.pop();
                operate2 = integerStack.pop();
                int result = 0;
                if (s3.equals(String.valueOf(plus))){
                    result = operate1+operate2;
                }else if (s3.equals(String.valueOf(minus))) {
                    result = operate2 - operate1;
                }
                integerStack.push(result);
            }else{
                integerStack.push(Integer.valueOf(s3));
            }
        }

        return integerStack.pop();
    }

    private boolean checkOperateChar(char checkChar) {
        return checkChar == plus || checkChar == minus || checkChar == leftBrackets || checkChar == rightBrackets;
    }

    private boolean checkOperateChar(String checkString){
        return checkString.equals(String.valueOf(plus)) || checkString.equals(String.valueOf(minus)) || checkString.equals(String.valueOf(leftBrackets)) || checkString.equals(String.valueOf(rightBrackets));
    }

    private boolean stringEqualsChar(String checkString, char checkChar) {
        if (null == checkString) {
            return false;
        }
        return checkString.equals(String.valueOf(checkChar));
    }

    public static void main(String[] args) {
        Problem224 problem224 = new Problem224();
        Integer result = problem224.calculate("(１)");
        System.out.println(result);
    }
}
