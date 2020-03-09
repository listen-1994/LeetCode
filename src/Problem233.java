import java.util.List;

public class Problem233 {
    /**
     * 数位dp
     *
     * @param n
     * @return
     */
    Integer result = 0;
    Integer length;
    String nString;
    Integer[][] dp;
    Boolean[][] check;

    public int countDigitOne(int n) {
        nString = String.valueOf(n);
        length = nString.length();
        dp = new Integer[length][2];
        check = new Boolean[length][2];
        dfs(0, true, true);
        return result;
    }

    /**
     * @param pos   位置
     * @param head  前置0
     * @param limit 上限
     */
    public void dfs(int pos, boolean head, boolean limit) {
        Character character = nString.charAt(pos);
        Character posNum = '0';
        Character limitChar = '9';
        if (limit) {
            limitChar = character;
        }
        while (posNum <= character) {
            dfs(pos + 1, head && posNum == '0', limit && posNum == character);
            posNum++;
        }
    }

    public static void main(String[] args) {

    }
}
