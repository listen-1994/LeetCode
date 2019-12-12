import org.omg.CORBA.StringHolder;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.StringReader;
import java.util.*;

public class Problem126 {
    //超时，貌似进入死循环了
/*    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
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
                if (str.equals(endWord)) { subResult.clear(); List<String> sub = new LinkedList<>(); sub.add(beginWord); sub.add(endWord); subResult.add(sub); return subResult; } List<String> wordList2 = new LinkedList<>(wordList); wordList2.remove(beginWord); List<List<String>> sub = core(str, endWord, wordList2, save); if (sub.size() != 0) { if (num > sub.get(0).size()) { subResult.clear(); subResult.addAll(sub); num = sub.get(0).size(); } else if (num == sub.get(0).size()) { subResult.addAll(sub);
                    }
                }
            }
        }
        for (List<String> sub : subResult) {
            sub.add(0, beginWord);
        }
        return subResult;
    }*/




    //超时
/*    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return Collections.emptyList();
        }

        List<List<String>> result = new ArrayList<>();
        Map<String, List<List<String>>> nextVisit = new HashMap<>();
        List<List<String>> subRsult = new ArrayList<>();
        List<String> subsubResult = new LinkedList<>();
        if (beginWord.equals(endWord)) {
            subsubResult.add(beginWord);
            subRsult.add(subsubResult);
            return subRsult;
        }
        subRsult.add(subsubResult);
        nextVisit.put(beginWord, subRsult);
        core(new HashSet<String>(), nextVisit, endWord,
                new HashSet<String>(wordList), result,
                new HashMap<String, Boolean>());

        return result;
    }

    private void core(Set<String> visited,
                      Map<String, List<List<String>>> nextVisit,
                      String endWord,
                      Set<String> wordList, List<List<String>> result,
                      Map<String, Boolean> save) {
        if (nextVisit.size() == 0) {
            return;
        }
        for (String s : nextVisit.keySet()) {
            if (checkString(s, endWord, save)) {
                List<List<String>> subResult = nextVisit.get(s);
                for (List<String> strings : subResult) {
                    strings.add(s);
                    strings.add(endWord);
                }
                result.addAll(subResult);
            }
        }
        if (result.size() > 0) {
            return;
        }
        visited.addAll(nextVisit.keySet());
        wordList.removeAll(nextVisit.keySet());

        Map<String, List<List<String>>> newNextVisit = new HashMap<>();
        for (String s : nextVisit.keySet()) {
            for (String s1 : wordList) {
*//*                if (visited.contains(s1)) {
                    continue;
                }*//*
                if (!checkString(s, s1, save)) {
                    continue;
                }
                List<List<String>> subResult = new ArrayList<>();
                for (List<String> strings : nextVisit.get(s)) {
                    subResult.add(new LinkedList<String>(strings));
                }
                for (List<String> strings : subResult) {
                    strings.add(s);
                }
                if (newNextVisit.get(s1) == null) {
                    newNextVisit.put(s1, new ArrayList<List<String>>());
                }
                newNextVisit.get(s1).addAll(subResult);
            }
        }
        core(visited, newNextVisit, endWord, wordList, result, save);
    }*/

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.add(beginWord);
        if (!wordSet.contains(endWord)) {
            return Collections.emptyList();
        }
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        wordSet.add(beginWord);
        wordList = new ArrayList<>(wordSet);
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (checkString(wordList.get(i), wordList.get(j))) {
                    if (graph.get(wordList.get(i)) == null) {
                        graph.put(wordList.get(i), new ArrayList<String>());
                    }
                    graph.get(wordList.get(i)).add(wordList.get(j));
                    if (graph.get(wordList.get(j)) == null) {
                        graph.put(wordList.get(j), new ArrayList<String>());
                    }
                    graph.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }
        Set<String> needVisit = new HashSet<>();
        needVisit.add(beginWord);
        Map<String, List<List<String>>> save = new HashMap<String, List<List<String>>>();
        List<String> list1 = new ArrayList<>();
        List<List<String>> list2 = new ArrayList<>();
        list2.add(list1);
        save.put(beginWord, list2);
        core(endWord, needVisit, new HashSet<String>(), graph, result, save);
        return result;
    }

    public void core(String endWord,
                     Set<String> needVisit, Set<String> visited, Map<String, List<String>> graph,
                     List<List<String>> result, Map<String, List<List<String>>> save) {
        if (needVisit.isEmpty()) {
            return;
        }
        if (needVisit.contains(endWord)) {
            List<List<String>> subResult = save.get(endWord);
            if (subResult == null || subResult.size() == 0) {
                subResult = new ArrayList<>();
                subResult.add(Arrays.asList(endWord));
                result.addAll(subResult);
                return;
            }
            for (List<String> strings : subResult) {
                strings.add(endWord);
                result.add(strings);
            }
            return;
        }
        Set<String> nextNeedVisit = new HashSet<>();
        visited.addAll(needVisit);
        for (String s : needVisit) {
            if (null == graph.get(s)) {
                continue;
            }
            for (String s1 : graph.get(s)) {
                if (!visited.contains(s1)) {
                    nextNeedVisit.add(s1);
                    if (null == save.get(s1)) {
                        save.put(s1, new ArrayList<List<String>>());
                    }
                    List<List<String>> subResult = save.get(s1);
                    List<List<String>> frontResult = save.get(s);
                    for (List<String> strings : frontResult) {
                        List<String> newStrings = new ArrayList<>(strings);
                        newStrings.add(s);
                        subResult.add(newStrings);
                    }
                }
            }
        }
        core(endWord, nextNeedVisit, visited, graph, result, save);
    }

    public Boolean checkString(String str1, String str2) {
        String key = str1 + str2;

        if (str1.length() != str2.length()) {
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
        return flag;
    }

    public static void main(String[] args) {
        Problem126 problem126 = new Problem126();
        Long beginTime = System.currentTimeMillis();
        List<List<String>> result = problem126.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        Long endTime = System.currentTimeMillis();
        Long runtime = endTime - beginTime;
        System.out.println(runtime);
        System.out.println(result);
    }
}
