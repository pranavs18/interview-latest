import java.util.HashMap;

public class Trie {

    class TrieNode {
        boolean isLeaf;
        HashMap<Character, TrieNode> map;
        int count;

        public TrieNode() {
            map = new HashMap<>();
            count = 0;
        }
    }

    TrieNode root = new TrieNode();


    public void insert(String word) {
        if(word == null || word == "") {
            return;
        }
        TrieNode current = root;
        for(int i=0;i<word.length();i++) {
            Character c = word.charAt(i);
            if(!current.map.containsKey(c)) {
                current.map.put(c, new TrieNode());
                current.count++;
            }

            current = current.map.get(c);
        }
        current.count++;
        current.isLeaf = true;
    }

    public boolean search(String word) {
        if(word == null || word == ""){
            return false;
        }

        TrieNode current = root;
        for(int i=0;i<word.length();i++) {
            Character c = word.charAt(i);
            if(!current.map.containsKey(c)) {
                return false;
            } else {
                current = current.map.get(c);
                if(current == null) {
                    return false;
                }
                else if(i == word.length()-1 && current.isLeaf == true) {
                    return true;
                }
            }
        }
        return false;
    }

    /* Driver program to test above function */
    public static void main(String[] args)
    {
        Trie t = new Trie();
        t.insert("hello");
        t.insert("code");
        t.insert("hello123");

        System.out.println(t.search("hello"));
        System.out.println(t.search("hello12"));
        System.out.println(t.search("hel"));
        System.out.println(t.search("held"));
        System.out.println(t.search("hello123"));
        System.out.println(t.search("code"));


    }
}