import java.util.List;

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
        for (int i = 0; i < s.length(); i++) {
            if (checkOperator(s.charAt(i)) || i == s.length() - 1) {
                Integer num = string2Integer(s.substring(lastIndex, i));
            }
        }
    }

    private Boolean checkOperator(Character character) {
        return character == '+' || character == '-' || character == '*';
    }

}
