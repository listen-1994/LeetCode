import java.util.List;
import java.util.Stack;

public class Problem282 {
    public List<String> addOperators(String num, int target) {

    }

    private Integer string2Integer(String s) {
        return Integer.valueOf(s);
    }

    private Boolean checkString(String s, int target) {
        return calculateString(s).equals(target);
    }

    private Integer calculateString(String s) {
        int lastIndex = 0;
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (checkOperator(s.charAt(i)) || i == s.length() - 1) {
                Integer num = string2Integer(s.substring(lastIndex, i));
                numStack.push(num);
                Character currentOperator = s.charAt(i);
                while (!currentOperator.equals('*') && (!operatorStack.isEmpty() && operatorStack.peek().equals('*'))) {

                }
                operatorStack.push(currentOperator);
            }
        }
        return calculateStack(numStack, operatorStack);
    }

    private Integer calculateStack(Stack<Integer> numStack, Stack<Character> operatorStack) {

    }

    private Boolean checkOperator(Character character) {
        return character == '+' || character == '-' || character == '*';
    }

}
