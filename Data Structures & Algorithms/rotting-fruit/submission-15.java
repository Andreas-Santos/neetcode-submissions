class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> rotten = new LinkedList<>();
        int fresh = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 2) {
                    rotten.offer(new int[]{r, c});
                }

                if(grid[r][c] == 1) {
                    fresh++;
                }
            } 
        }

        int time = 0;
        while(fresh > 0 && !rotten.isEmpty()) {

            int size = rotten.size();
            for(int i = 0; i < size; i++) {

                int[] current = rotten.poll();
                int r = current[0];
                int c = current[1];

                int[][] directions = {
                    {r + 1, c},
                    {r - 1, c},
                    {r, c + 1},
                    {r, c - 1}
                };

                for(int[] dir : directions) {
                    if(dir[0] < 0 || dir[0] >= ROWS || dir[1] < 0 || dir[1] >= COLS || grid[dir[0]][dir[1]] != 1) {
                        continue;
                    }

                    grid[dir[0]][dir[1]] = 2;
                    fresh--;

                    rotten.offer(dir);
                }
            }
            
            time++;
        }

        System.out.println(fresh);

        if(fresh != 0) {
            return -1;
        }

        return time;
    }
}
