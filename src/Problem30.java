import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 第30题 串联所有单词的子串
 * 哈希表 双指针 字符串
 */
public class Problem30 {

    HashMap<String, Integer> checkSet = new HashMap<>();

    public List<Integer> findSubstring(String s, String[] words) {

        LinkedList<Integer> result = new LinkedList<>();
        if(s.equals("")||words.length==0){
            return result;
        }
        for (String str : words) {
            if (!checkSet.containsKey(str)) {
                checkSet.put(str, 0);
            }
            checkSet.put(str, checkSet.get(str) + 1);
        }
        int length = words.length * words[0].length();
        for (int i = 0; i <= s.length() - length; i++) {
            if (core(s.substring(i, i + length), words)) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean core(String s, String[] words) {
        HashMap<String, Integer> check = new HashMap<>();
        int n = words[0].length();
        for (int i = 0; i < s.length(); i += n) {
            String str = s.substring(i, i + n);
            if (!check.containsKey(str)) {
                check.put(str, 0);
            }
            check.put(str, check.get(str) + 1);
        }
        return check.equals(checkSet);
    }

    public static void main(String[] args){
        Problem30 problem30 = new Problem30();
        System.out.println(problem30.findSubstring("goodgoodbestword",new String[]{"word","good","best","good"}));
    }
}
