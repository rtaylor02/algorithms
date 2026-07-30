package leetcode;

public class _79_WordSearch {
    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) {
        /*
        Steps:
        1) Iterate through each grid to find the 1st character of the lookup word
        2) Run DFS (Depth First Search) on the 1st grid to find next letters
         */
        this.board = board;
        this.word = word;

        for (int row = 0; row < board.length; row++ ) {
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] == word.charAt(0)) {
                    if (dfs(row, column, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int row, int column, int searchIndex) {
        /*
        Steps:
        1) Replace the character of current grid with '/' temporarily
        2) Crawl adjacent grids if contains the next letter
        3) In case of incomplete word found, replace the '/' to its original content
         */

        // Last letter will have been found if the search index == word's length
        if (searchIndex == word.length()) {
            return true;
        }

        // Ignore out-of-boundary grids and when the letter is not the same as the one it's looking for
        if (row < 0 || column < 0 || row >= board.length || column >= board[0].length || board[row][column] != word.charAt(searchIndex)) {
            return false;
        }

        char temp = board[row][column];
        board[row][column] = '/';

        // Real power of DFS: stack calls
        boolean result = dfs(row + 1, column, searchIndex + 1)
                || dfs(row - 1, column, searchIndex + 1)
                || dfs(row, column + 1, searchIndex + 1)
                || dfs(row, column - 1, searchIndex + 1);

        board[row][column] = temp;

        return result;
    }
}
