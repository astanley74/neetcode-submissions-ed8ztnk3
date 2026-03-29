class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode(); 
    }

    public void insert(String word) {
        TrieNode curr = this.root;
        for (char ch : word.toCharArray()) {
            if (!curr.children.containsKey(ch)) {
                curr.children.put(ch, new TrieNode());
            }
            curr = curr.children.get(ch);
        }
        curr.word = true;
    }

    public boolean search(String word) {
        TrieNode curr = this.root;
        for (char ch : word.toCharArray()) {
            if (!curr.children.containsKey(ch)) {
                return false;
            }
            curr = curr.children.get(ch);
        }
        return curr.word;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for (char ch : prefix.toCharArray()) {
            if (!curr.children.containsKey(ch)) {
                return false;
            }
            curr = curr.children.get(ch);
        }
        return true;
    }
}

public class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean word = false;
}
