class TrieNode {

    boolean isWord;
    Map<Character, TrieNode> children;

    public TrieNode() {
        isWord = false;
        children = new HashMap<>();
    }

}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        return search(word, 0, root);
    }

    public boolean search(String word, int index, TrieNode node) {
        TrieNode current = node;

        for(int i = index; i < word.length(); i++) {
            char c = word.charAt(i);

            if(c == '.') {
                for(char x : current.children.keySet()) {
                    TrieNode child = current.children.get(x);
                    if(search(word, i + 1, child)) {
                        return true;
                    }
                }

                return false;
            }

            if(!current.children.containsKey(c)) {
                return false;
            }

            current = current.children.get(c);
        }

        return current.isWord;
    }
}
