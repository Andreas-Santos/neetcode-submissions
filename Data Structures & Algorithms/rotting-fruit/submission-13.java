class Solution {
    public int orangesRotting(int[][] grid) {
        
        int ROWS = grid.length;
        int COLS = grid[0].length;

        Queue<int[]> rottenFruits = new LinkedList<>();
        int freshFruits = 0;
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 2) {
                    rottenFruits.offer(new int[]{r, c});
                }
                
                if(grid[r][c] == 1) {
                    freshFruits++;
                }
            }
        }

        int minutes = 0;
        while(freshFruits > 0 && !rottenFruits.isEmpty()) {
            int size = rottenFruits.size();

            for(int i = 0; i < size; i++) {
                int[] coord = rottenFruits.poll();
                int r = coord[0];
                int c = coord[1];
                
                int[][] directions = {
                    {r + 1, c},
                    {r - 1, c},
                    {r, c + 1},
                    {r, c - 1}
                };

                for(int[] dir : directions) {
                    int nextR = dir[0];
                    int nextC = dir[1];

                    if(nextR < 0 || nextR >= ROWS || nextC < 0 || nextC >= COLS || grid[nextR][nextC] != 1){
                        continue;
                    }

                    grid[nextR][nextC] = 2;

                    freshFruits--;
                    rottenFruits.offer(dir);
                }
            }

            minutes++;
        }

        if(freshFruits != 0) {
            return -1;
        }

        return minutes;
    }
}
