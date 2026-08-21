class Solution {

    boolean[][] visited;
    Set<String> foundWords;

    public List<String> findWords(char[][] board, String[] words) {
        
        int ROWS = board.length;
        int COLS = board[0].length;

        visited = new boolean[ROWS][COLS];
        foundWords = new HashSet<>();
        Trie trie = new Trie();

        for(String word : words) {
            trie.add(word);
        }

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++) {
                dfs(board, r, c, trie.root, "");
            }
        }

        return new ArrayList<>(foundWords);
    }

    public void dfs(char[][] board, int r, int c, TrieNode node, String word) {
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return;
        } 

        if(visited[r][c] || !node.children.containsKey(board[r][c])) {
            return;
        }


        visited[r][c] = true;
        node = node.children.get(board[r][c]);
        word += board[r][c];
        if(node.isWord) {
            foundWords.add(word);
        }
        
        dfs(board, r + 1, c, node, word);
        dfs(board, r - 1, c, node, word);
        dfs(board, r, c + 1, node, word);
        dfs(board, r, c - 1, node, word);

        visited[r][c] = false;
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

        current.isWord = true;
    }
}

class TrieNode {

    boolean isWord;
    Map<Character, TrieNode> children;

    public TrieNode() {
        isWord = false;
        children = new HashMap<>();
    }

}