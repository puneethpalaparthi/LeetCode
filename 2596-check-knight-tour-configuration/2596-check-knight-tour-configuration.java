class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        
        int n = grid.length;
        int[][] pos = new int[n * n][2];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pos[grid[i][j]][0] = i;
                pos[grid[i][j]][1] = j;
            }
        }
        
        for (int i = 1; i < n * n; i++) {
            int dx = Math.abs(pos[i][0] - pos[i - 1][0]);
            int dy = Math.abs(pos[i][1] - pos[i - 1][1]);
            
            if (!((dx == 1 && dy == 2) || (dx == 2 && dy == 1))) {
                return false;
            }
        }
        
        return true;
    }
}