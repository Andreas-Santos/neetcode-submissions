class PrefixTree {

    TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for(char c : word.toCharArray()) {
            if(!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }

            current = current.children.get(c);
        }

        current.isWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;

        for(char c : word.toCharArray()) {
            if(!current.children.containsKey(c)){
                return false;
            }

            current = current.children.get(c);
        }

        return current.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for(char c : prefix.toCharArray()) {
            if(!current.children.containsKey(c)) {
                return false;
            }

            current = current.children.get(c);
        }

        return true;
    }
}

class TrieNode {

    boolean isWord;
    Map<Character, TrieNode> children;

    public TrieNode() {
        this.isWord = false;
        this.children = new HashMap<>();
    }

}