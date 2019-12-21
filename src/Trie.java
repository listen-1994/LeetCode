import java.util.HashMap;
import java.util.Map;

public class Trie {
    class TreeNode{
        char val;
        boolean end;
        Map<Character,TreeNode> child;

        public TreeNode(char val){
            this.val = val;
            this.child = new HashMap<>();
        }
    }
    TreeNode treeNode;
    /** Initialize your data structure here. */
    public Trie() {
        this.treeNode = new TreeNode('a');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (null==word||word.length()==0){
            return;
        }
        TreeNode point = this.treeNode;
        int i = 0;
        for (;i<word.length();i++){
            TreeNode node = point.child.get(word.charAt(i));
            if (node==null){
                break;
            }
            point = node;
        }
        if (i>=word.length()){
            point.end=true;
            return;
        }
        for (;i<word.length();i++){
            char character = word.charAt(i);
            TreeNode node = new TreeNode(character);
            point.child.put(character,node);
            point = node;
        }
        point.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (null==word||word.length()==0){
            return true;
        }
        TreeNode point= this.treeNode;
        int i = 0;
        for (;i<word.length();i++){
            TreeNode node = point.child.get(word.charAt(i));
            if (node==null){
                break;
            }
            point = node;
        }
        if (i<word.length()){
            return false;
        }
        return point.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (null==prefix||prefix.length()==0){
            return true;
        }
        Map<Character,TreeNode> child = this.treeNode.child;
        int i = 0;
        for (;i<prefix.length();i++){
            TreeNode node = child.get(prefix.charAt(i));
            if (node==null){
                break;
            }
            child = node.child;
        }
        return i>=prefix.length();
    }

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true
    }
}
