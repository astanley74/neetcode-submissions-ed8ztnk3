class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
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
        return search(word, this.root);
    }

    public boolean search(String word, TrieNode curr) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!curr.children.containsKey(ch)) {
                if (ch == '.') {
                    for (char c : curr.children.keySet()) {
                        TrieNode child = curr.children.get(c);
                        if (search(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                curr = curr.children.get(ch);
            }
        }
        return curr.word;
    }
}

public class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean word = false;
}
