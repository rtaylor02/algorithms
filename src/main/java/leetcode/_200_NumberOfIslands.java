package leetcode;

public class _200_NumberOfIslands {
    public int calculateNumberOfIslands(char[][] grid) {
        /*
        Steps:
        1. Iterate the 2D adjacency matrix one grid at a time to find the 1st letter of the look-up word
        2. Read the surrounding grid to see if it contains the 2nd letter.
        3. If found, continue to see if the grids around the 2nd letter contains the 3rd letter.
           If not found, return to the caller, i.e. the 1st letter crawler.
        4. The search mechanism is called DFS (Depth First Search), because when it found the 1st one, it keeps digging
           all the way until it's not valid/found anymore.
         */

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }


        return count;
    }

    private void dfs(char[][] grid, int currentRow, int currentColumn) {
        /*
        Steps:
        1) Replace '1' with '0'. This is to prevent cyclic detection by the adjacent '1's
        2) Crawl the adjacent grids by calling dfs() on each of the adjacent grid '
         */

        // No need to proceed if current grid is invalid or water ('0')
        if (currentRow < 0 || currentColumn < 0 || currentRow >= grid.length || currentColumn >= grid[0].length || grid[currentRow][currentColumn] == '0') {
            return;
        }

        // Here onwards: process an island ('1')
        grid[currentRow][currentColumn] = '0'; // Turn into water to prevent cyclic detection
        dfs(grid, currentRow + 1, currentColumn);
        dfs(grid, currentRow - 1, currentColumn);
        dfs(grid, currentRow, currentColumn + 1);
        dfs(grid, currentRow, currentColumn - 1);
    }
}
