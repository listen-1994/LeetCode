/**
 * LeetCode 第65题 有效的数字
 * 困难
 * 数学 字符串
 */

/**
 * 编译原理问题 词法分析器
 * 什么破题
 */
public class Problem65 {


    /*这题有毒，有限状态机，写到" 005047e+6"，1463 / 1481 个通过测试用例不想改了
    public enum NumberType {
        start(0), normal(1), decimals(2), exponent(3), onlysymbol(4), afterDecimals(5),afterE(6);

        private int type;

        private NumberType(int type)
            this.type = type;
        }
    }

    class Number {
        public NumberType numberType;
        public String s;

        public Number(NumberType type, String s) {
            this.numberType = type;
            this.s = s;
        }

        public void add(char c) {
            this.s = this.s + String.valueOf(c);
        }
    }

    public boolean isNumber(String s) {
        Number number = new Number(NumberType.start, "");

        //两边有空格需要忽略
        String sTrim = s.trim();

        //空的算false
        if (sTrim.equals("") || sTrim.equals("e") || sTrim.equals(".")||sTrim.equals("+.")||sTrim.equals("-.")) {
            return false;
        }
        for (int i = 0; i < sTrim.length(); i++) {
            if (!check(number, sTrim.charAt(i))) {
                return false;
            }
        }
        if (number.s.charAt(number.s.length() - 1) == 'e') {
            return false;
        }
        return true;
    }

    public boolean check(Number number, char c) {
        if (number.numberType == NumberType.start) {
            if (c == '+' || c == '-') {
                number.numberType = NumberType.onlysymbol;
                number.add(c);
            } else if ('0' <= c && c <= '9') {
                number.numberType = NumberType.normal;
                number.add(c);
            }
            //".1"算正确
            else if (c == '.') {
                number.numberType = NumberType.afterDecimals;
                number.add(c);
            } else {
                return false;
            }
            return true;
        }

        if (number.numberType == NumberType.normal) {
            if ('0' <= c && c <= '9') {
                number.add(c);
            } else if (c == '.') {
                number.numberType = NumberType.afterDecimals;
                number.add(c);
            } else if (c == 'e') {
                number.numberType = NumberType.exponent;
                number.add(c);
            } else {
                return false;
            }
            return true;
        }

        if (number.numberType == NumberType.decimals) {
            if ('0' <= c && c <= '9') {
                number.add(c);
            } else if (c == 'e') {
                number.numberType = NumberType.exponent;
                number.add(c);
            } else {
                return false;
            }
            return true;
        }

        if (number.numberType == NumberType.exponent) {
            if ('0' <= c && c <= '9') {
                number.add(c);
            }
            else {
                return false;
            }
            return true;
        }

        if (number.numberType == NumberType.afterDecimals) {
            if ('0' <= c && c <= '9') {
                number.numberType = NumberType.decimals;
                number.add(c);
            } else if(c=='e'){
                if(number.s.length()==1){
                    return false;
                }
                number.numberType= NumberType.exponent;
                number.add(c);
            }
            else {
                return false;
            }
            return true;
        }

        if (number.numberType == NumberType.onlysymbol) {
            if ('0' <= c && c <= '9') {
                number.numberType = NumberType.normal;
                number.add(c);
            } else if (c == '.') {
                number.numberType = NumberType.afterDecimals;
                number.add(c);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem65 problem65 = new Problem65();
        System.out.println(problem65.isNumber("+++"));
    }
    */

    public boolean isNumber(String s) {
        if (s.matches("\\s*[+-]?[0-9]+(e[+-]?[0-9]+)?\\s*") || s.matches("\\s*[+-]?0+\\s*")
                || s.matches("\\s*[+-]?[0-9]+\\.[0-9]*(e[+-]?[0-9]+)?\\s*") ||
                s.matches("\\s*[+-]?0*\\.[0-9]*(e[+-]?[0-9]+)?\\s*") && !s.matches("\\s*[+-]?\\.(e[+-]?[0-9]+)?\\s*"))
            return true;
        return false;
    }
}
