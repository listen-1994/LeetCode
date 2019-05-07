import java.util.*;

public class Problem49 {
    class Word {
        String wordname;
        HashMap<Character, Integer> charMap;

        public Word(String wordname) {
            this.wordname = wordname;
            charMap = new HashMap<>();
            for (int i = 0; i < wordname.length(); i++) {
                if (!charMap.containsKey(wordname.charAt(i))) {
                    charMap.put(wordname.charAt(i), 0);
                }
                charMap.put(wordname.charAt(i), charMap.get(wordname.charAt(i)) + 1);
            }
        }

        @Override
        public boolean equals(Object obj) {
            Word word = (Word) obj;
            return this.charMap.equals(word.charMap);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<Word>> check = new LinkedList<>();
        List<List<String>> result = new LinkedList<>();
        for (int i = 0; i < strs.length; i++) {
            Word word = new Word(strs[i]);
            boolean flag = false;
            for (List<Word> list : check) {
                if (list.get(0).equals(word)) {
                    list.add(word);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                List<Word> newList = new LinkedList<>();
                newList.add(word);
                check.add(newList);
            }
        }
        for (List<Word> list : check) {
            List<String> newList = new LinkedList<>();
            for (Word word : list) {
                newList.add(word.wordname);
            }
            result.add(newList);
        }
        return result;
    }

    public static void main(String[] args) {
        Problem49 problem49 = new Problem49();
        System.out.println(problem49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
