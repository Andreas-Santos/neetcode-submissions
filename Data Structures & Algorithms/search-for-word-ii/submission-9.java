class Solution {

    Set<String> foundWords;
    
    public List<String> findWords(char[][] board, String[] words) {
        
        Trie trie = new Trie();
        foundWords = new HashSet<>();

        for(String word : words) {
            trie.add(word);
        }

        int ROWS = board.length;
        int COLS = board[0].length;
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                dfs(board, r, c, trie.root);
            }
        }

        return new ArrayList<>(foundWords);
    }

    public void dfs(char[][] board, int r, int c, TrieNode node) {

        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return;
        }
        
        char curChar = board[r][c];
        if(!Character.isLetter(curChar) || !node.children.containsKey(curChar)) {
            return;
        }

        board[r][c] = '#';
        node = node.children.get(curChar);
        if(node.word != null) {
            foundWords.add(node.word);
        }
        dfs(board, r + 1, c, node);
        dfs(board, r - 1, c, node);
        dfs(board, r, c + 1, node);
        dfs(board, r, c - 1, node);
        
        board[r][c] = curChar;
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void add(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()) {
            if(!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }

            current = current.children.get(c);
        }

        current.word = word;
    }
}

class TrieNode {

    String word;
    Map<Character, TrieNode> children;

    public TrieNode() {
        word = null;
        children = new HashMap<>();
    }
}   
