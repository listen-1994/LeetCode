/**
 * LeetCode 第58题
 * 最后一个单词的长度
 * 简单
 * 字符串
 */
public class Problem58 {
    public int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        if (strings.length == 0) {
            return 0;
        } else {
            return strings[strings.length - 1].length();
        }
    }
}
