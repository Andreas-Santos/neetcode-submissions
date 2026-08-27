class Solution {

    private int ROWS;
    private int COLS;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        ROWS = board.length;
        COLS = board[0].length;
        visited = new boolean[ROWS][COLS];

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(board[r][c] == word.charAt(0) 
                    && dfs(board, r, c, 0, word)
                ) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int r, int c, int i, String word) {

        if(r < 0 || r >= ROWS || c < 0 || c >= COLS || visited[r][c]) {
            return false;
        }

        if(i == word.length() - 1 && word.charAt(i) == board[r][c]) {
            return true;
        }

        if(i == word.length() || word.charAt(i) != board[r][c]) {
            return false;
        }

        visited[r][c] = true;

        boolean existsWord = 
                    dfs(board, r + 1, c, i + 1, word) ||
                    dfs(board, r - 1, c, i + 1, word) ||
                    dfs(board, r, c + 1, i + 1, word) ||
                    dfs(board, r, c - 1, i + 1, word);

        visited[r][c] = false;

        return existsWord;
    }
}
