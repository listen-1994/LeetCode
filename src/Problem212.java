
import java.util.*;

public class Problem212 {
    public class Trie {
        class TreeNode {
            char val;
            boolean end;
            Map<Character, TreeNode> child;

            public TreeNode(char val) {
                this.val = val;
                this.child = new HashMap<>();
            }
        }

        TreeNode treeNode;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            this.treeNode = new TreeNode('a');
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (null == word || word.length() == 0) {
                this.treeNode.end = true;
                return;
            }
            TreeNode point = this.treeNode;
            int i = 0;
            for (; i < word.length(); i++) {
                TreeNode node = point.child.get(word.charAt(i));
                if (node == null) {
                    break;
                }
                point = node;
            }
            if (i >= word.length()) {
                point.end = true;
                return;
            }
            for (; i < word.length(); i++) {
                char character = word.charAt(i);
                TreeNode node = new TreeNode(character);
                point.child.put(character, node);
                point = node;
            }
            point.end = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if (null == word || word.length() == 0) {
                return this.treeNode.end;
            }
            TreeNode point = this.treeNode;
            int i = 0;
            for (; i < word.length(); i++) {
                TreeNode node = point.child.get(word.charAt(i));
                if (node == null) {
                    break;
                }
                point = node;
            }
            if (i < word.length()) {
                return false;
            }
            return point.end;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if (null == prefix || prefix.length() == 0) {
                return true;
            }
            Map<Character, TreeNode> child = this.treeNode.child;
            int i = 0;
            for (; i < prefix.length(); i++) {
                TreeNode node = child.get(prefix.charAt(i));
                if (node == null) {
                    break;
                }
                child = node.child;
            }
            return i >= prefix.length();
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        int max = 0;
        for (String word : words) {
            trie.insert(word);
            max = Math.max(max, word.length());
        }
        Set<String> set = new HashSet<>();
        for (int i =0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                boolean[][] visited = new boolean[board.length][board[0].length];
                core(i,j,board,visited,trie,new StringBuilder(),set,max);
            }
        }

        return new ArrayList<>(set);
    }

    public void core(int i, int j, char[][] board, boolean[][] visited, Trie trie, StringBuilder stringBuilder, Set<String> result, int max) {
        visited[i][j] = true;
        String str = stringBuilder.append(board[i][j]).toString();
        //System.out.println(str);
        if (str.length() > max || !trie.startsWith(str)) {
            visited[i][j] = false;
            return;
        }
        if (trie.search(str)){
            result.add(str);
        }
        if (i>0&&!visited[i-1][j]){
            core(i-1,j,board,visited,trie,new StringBuilder(str),result,max);
        }
        if (i<board.length-1&&!visited[i+1][j]){
            core(i+1,j,board,visited,trie,new StringBuilder(str),result,max);
        }
        if (j>0&&!visited[i][j-1]){
            core(i,j-1,board,visited,trie,new StringBuilder(str),result,max);
        }
        if (j<board[0].length-1&&!visited[i][j+1]){
            core(i,j+1,board,visited,trie,new StringBuilder(str),result,max);
        }
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        Problem212 problem212 = new Problem212();
        char[][] board = new char[][]{
                {'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}
        };
        String[] words = new String[]{
                "abcdefg", "befa", "eaabcdgfa", "gfedcbaaa"
        };
        List<String> result = problem212.findWords(board, words);
        System.out.println(result);
    }
}
