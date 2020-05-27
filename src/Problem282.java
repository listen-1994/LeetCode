import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Problem282 {
    public List<String> addOperators(String num, int target) {
        List<String> result = new LinkedList<>();
        if (null == num || num.length() == 0) {
            return result;
        }
        dfs(num.substring(0, 1), num, target, result, 0, num.length(), false);
        return result;
    }

    private void dfs(String s, String num, int target, List<String> result, int index, int length, Boolean startZero) {
        if (index == length - 1) {
            if (checkString(s, target))
                result.add(s);
            return;
        }
        StringBuilder sb1 = new StringBuilder(s);
        StringBuilder sb2 = new StringBuilder(s);
        StringBuilder sb3 = new StringBuilder(s);
        sb3.append('*');
        sb3.append(num.charAt(index + 1));
        sb1.append('+');
        sb1.append(num.charAt(index + 1));
        sb2.append('-');
        sb2.append(num.charAt(index + 1));


        Boolean nextStartZero = false;
        if (num.charAt(index + 1) == '0') {
            nextStartZero = true;
        }

        dfs(sb3.toString(), num, target, result, index + 1, length, nextStartZero);
        dfs(sb2.toString(), num, target, result, index + 1, length, nextStartZero);
        dfs(sb1.toString(), num, target, result, index + 1, length, nextStartZero);


        if (!startZero) {
            StringBuilder sb4 = new StringBuilder(s);
            sb4.append(num.charAt(index + 1));
            dfs(sb4.toString(), num, target, result, index + 1, length, nextStartZero);
        }
    }

    private Long string2Long(String s) {
        return Long.valueOf(s);
    }

    private Boolean checkString(String s, int target) {
        return calculateString(s) == (target);
    }

    private Long calculateString(String s) {
        int lastIndex = 0;
        Stack<Long> numStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (checkOperator(s.charAt(i)) || i == s.length() - 1) {
                Long num = 0L;
                if (i == s.length() - 1) {
                    num = string2Long(s.substring(lastIndex, i + 1));
                } else {
                    num = string2Long(s.substring(lastIndex, i));
                }

                lastIndex = i + 1;
                numStack.push(num);
                Character currentOperator = s.charAt(i);
                while (!currentOperator.equals('*') && (!operatorStack.isEmpty() && operatorStack.peek().equals('*'))) {
                    Long num1 = numStack.pop();
                    Long num2 = numStack.pop();
                    operatorStack.pop();
                    numStack.push(num1 * num2);
                }
                if (i != s.length() - 1) {
                    operatorStack.push(currentOperator);
                }
            }
        }
        return calculateStack(numStack, operatorStack);
    }

    private Long calculateStack(Stack<Long> numStack, Stack<Character> operatorStack) {
        Stack<Long> numStack2 = new Stack<>();
        while(!numStack.isEmpty()){
            
        }
        while (!operatorStack.isEmpty()) {
            Long num1 = numStack.pop();
            Long num2 = numStack.pop();
            if (operatorStack.peek() == '+') {
                numStack.push(num1 + num2);
            } else if (operatorStack.peek() == '-') {
                numStack.push(num2 - num1);
            } else if (operatorStack.peek() == '*') {
                numStack.push(num1 * num2);
            }
            operatorStack.pop();
        }
        return numStack.pop();
    }

    private Boolean checkOperator(Character character) {
        return character == '+' || character == '-' || character == '*';
    }

    public static void main(String[] args) {
        Problem282 problem282 = new Problem282();
        List<String> result = problem282.addOperators("3456237490", 9191);
        System.out.println(result);
    }
}
