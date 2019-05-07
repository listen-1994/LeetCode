package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 第140题
 * 单词拆分II
 */
public class WordBreakII {

    HashMap<Integer, List<String>> sav;

    /**
     * 回溯改dp
     *
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        sav = new HashMap<>();
        return core(s, wordDict, 0);
    }

    public List<String> core(String s, List<String> wordDict, int index) {
        List<String> result = new LinkedList<>();
        for (String word : wordDict) {
            if (index + word.length() > s.length()) {
                continue;
            }
            if (!s.substring(index, index + word.length()).equals(word)) {
                continue;
            }
            if (index + word.length() == s.length()) {
                result.add(word);
            }

            List<String> subResult;
            if (!sav.containsKey(index + word.length())) {
                core(s, wordDict, index + word.length());
            }
            subResult = sav.get(index + word.length());
            for (String string : subResult) {
                result.add(word + " " + string);
            }
        }
        sav.put(index, result);
        return result;
    }

    public static void main(String[] args) {
        WordBreakII wordBreak = new WordBreakII();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak.wordBreak("leetcode", wordDict));
    }
}
