
public class Problem233 {
    /**
     * 数位dp
     *
     * @param n
     * @return
     */
    Integer length;
    String nString;
    Integer[][] dp;
    boolean[][] check;

    public int countDigitOne(int n) {
        nString = String.valueOf(n);
        length = nString.length();
        dp = new Integer[length][2];
        check = new boolean[length][2];
        dfs(0, true);
        return dp[0][1];
    }

    /**
     * @param pos   位置
     * @param limit 上限
     */
    public void dfs(int pos, boolean limit) {
        Character character = nString.charAt(pos);
        Character posNum = '0';
        Character limitChar = '9';

        Integer subResult = 0;
        if (limit) {
            limitChar = character;
        }

        //跳出dp
        if (pos == length - 1) {
            while (posNum <= limitChar) {
                if (checkDigitOne(posNum)) {
                    subResult++;
                }
                posNum++;
            }
            dp[pos][limit ? 1 : 0] = subResult;
            check[pos][limit ? 1 : 0] = true;
            return;
        }
        while (posNum <= limitChar) {
            Boolean nextLimit = limit && posNum == limitChar;
            Boolean checkDigitOne = checkDigitOne(posNum);
            if (!check[pos + 1][nextLimit ? 1 : 0]) {
                dfs(pos + 1, nextLimit);
            }
            Integer nextDigitOne = dp[pos + 1][nextLimit ? 1 : 0];
            subResult += nextDigitOne;
            if (checkDigitOne) {
                subResult += calNums(pos, nextLimit);
            }
            posNum++;
        }
        dp[pos][limit ? 1 : 0] = subResult;
        check[pos][limit ? 1 : 0] = true;
    }

    private boolean checkDigitOne(Character character) {
        return character == '1';
    }

    private Integer calNums(Integer pos, Boolean nextLimit) {
        Integer result = 1;
        if (!nextLimit) {
            for (int i = 1; i < length - pos; i++) {
                result = result * 10;
            }
        } else {
            result += Integer.valueOf(nString.substring(pos + 1));
        }
        return result;
    }


    public Integer test(Integer n) {
        Integer result = 0;
        for (int i = 0; i <= n; i++) {
            result += testDigitOne(i);
        }
        return result;
    }

    public Integer testDigitOne(Integer n) {
        Integer result = 0;
        String nString = n.toString();
        for (int i = 0; i < nString.length(); i++) {
            if (checkDigitOne(nString.charAt(i))) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem233 problem233 = new Problem233();
        Integer result = problem233.countDigitOne(312);
        Integer trueResult = problem233.test(312);
        System.out.println("标准答案：" + trueResult);
        System.out.println("计算结果：" + result);
    }
}
