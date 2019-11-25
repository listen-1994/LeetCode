import java.util.HashMap;
import java.util.Map;

public class Problem76 {

    /**
     * 参考博客:https://blog.csdn.net/qq_41231926/article/details/81427851
     * 关键点：滑动窗口
     *
     * @param t
     * @return
     */

    public String minWindow(String s, String t) {
        if (t == null || t.length() == 0) {
            return "";
        }
        String result = "";

        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (tMap.get(t.charAt(i)) == null) {
                tMap.put(t.charAt(i), 0);
            }
            tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
        }

        Integer count = 0;
        Integer i = -1;
        Integer j = 0;

        while (i < s.length() || j < s.length()) {
            if (count < t.length()) {
                if (j == s.length()) {
                    break;
                }
                if (tMap.get(s.charAt(j)) != null) {
                    if (tMap.get(s.charAt(j)) > 0) {
                        count++;
                    }
                    tMap.put(s.charAt(j), tMap.get(s.charAt(j)) - 1);
                    if (count == t.length()) {
                        if (result.length() == 0 || result.length() > j - i) {
                            result = s.substring(i + 1, j + 1);
                        }
                    }
                }
                j++;
                continue;
            }

            if (tMap.get(s.charAt(i + 1)) != null) {
                if (tMap.get(s.charAt(i + 1)) == 0) {
                    count--;
                }
                tMap.put(s.charAt(i + 1), tMap.get(s.charAt(i + 1)) + 1);
            }
            i++;
            if (count == t.length()) {
                if (result.length() == 0 || result.length() > j - i - 1) {
                    result = s.substring(i + 1, j);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem76 problem76 = new Problem76();
        String result = problem76.minWindow("ADOBECODEBANC",  "ABC");
        System.out.println(result);
    }

}
