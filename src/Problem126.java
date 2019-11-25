import java.util.*;

public class Problem126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        return core(beginWord, endWord, wordList, new HashMap<String, Boolean>());
    }

    public List<List<String>> core(String beginWord, String endWord, List<String> wordList, Map<String, Boolean> save) {

        System.out.println(beginWord + ":" + endWord + ":" + wordList.toString());

        Integer num = Integer.MAX_VALUE;
        List<List<String>> subResult = new ArrayList<>();
        if (wordList.size() == 0) {
            return subResult;
        }
        for (String str : wordList) {
            if (checkString(beginWord, str, save)) {
                if (str.equals(endWord)) {
                    subResult.clear();
                    List<String> sub = new LinkedList<>();
                    sub.add(beginWord);
                    sub.add(endWord);
                    subResult.add(sub);
                    return subResult;
                }
                List<String> wordList2 = new LinkedList<>(wordList);
                wordList2.remove(beginWord);
                List<List<String>> sub = core(str, endWord, wordList2, save);
                if (sub.size() != 0) {
                    if (num > sub.get(0).size()) {
                        subResult.clear();
                        subResult.addAll(sub);
                        num = sub.get(0).size();
                    } else if (num == sub.get(0).size()) {
                        subResult.addAll(sub);
                    }
                }
            }
        }
        for (List<String> sub : subResult) {
            sub.add(0, beginWord);
        }
        return subResult;
    }

    public Boolean checkString(String str1, String str2, Map<String, Boolean> save) {
        String key = str1 + str2;
        if (save.get(key) != null) {
            return save.get(key);
        }
        if (str1.length() != str2.length()) {
            save.put(key, false);
            return false;
        }
        Boolean flag = false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (!flag) {
                    flag = true;
                } else if (flag) {
                    flag = false;
                    break;
                }
            }
        }
        save.put(key, flag);
        return flag;
    }


    public static void main(String[] args) {
        Problem126 problem126 = new Problem126();
        List<List<String>> result = problem126.
                findLadders("qa", "sq", Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));
        System.out.println(result);
    }
}
