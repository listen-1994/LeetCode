package DynamicProgramming;


import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 第139题
 * 分割单词
 *
 * @author listen
 */
public class WordBreak {
    /**
     * 这题用回溯也可以A
     * 这么写，反而复杂，时间也没提升
     */
    //递归转DP
    int[] sav;

    public boolean wordBreak(String s, List<String> wordDict) {
        sav = new int[s.length()];
        core(s, wordDict, 0);
        for (int i = 0; i < sav.length; i++) {
            System.out.println(i + ":" + sav[i]);
        }
        return sav[0] == 1;

    }

    public boolean core(String s, List<String> wordDict, int index) {
        boolean result = false;
        if (s.length() - index == 0) {
            return true;
        }
        for (String word : wordDict) {
            if (index + word.length() > s.length()) {
                continue;
            }
            if (s.substring(index, index + word.length()).equals(word)) {
                if (index + word.length() == s.length()) {
                    sav[index] = 1;
                    return true;
                }
                if (sav[index + word.length()] == 1) {
                    sav[index] = 1;
                    result = true;
                } else if (sav[index + word.length()] == 2) {
                    sav[index] = 2;
                    result = false;
                } else {
                    result = core(s, wordDict, index + word.length()) || result;
                }
            }
            if (result == true) {
                sav[index] = 1;
                return true;
            }
        }
        sav[index] = 2;
        return result;
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak.wordBreak("leetcode", wordDict));
    }
}
