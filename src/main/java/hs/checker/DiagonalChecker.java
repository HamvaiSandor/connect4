package hs.checker;

/**
 * Ellenőrzi a játék tábláján az átlóban elhelyezkedő
 * nyerő kombinációkat.
 */
public class DiagonalChecker {

    /**
     * Ellenőrzi, hogy van-e nyerő kombináció az átlók mentén.
     */
    public boolean check(final char[][] grid) {
        for (int row = 3; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                if (grid[row][col] != '.'
                        && grid[row][col] == grid[row - 1][col + 1]
                        && grid[row][col] == grid[row - 2][col + 2]
                        && grid[row][col] == grid[row - 3][col + 3]) {
                    return true;
                }
            }
        }
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 4; col++) {
                if (grid[row][col] != '.'
                        && grid[row][col] == grid[row + 1][col + 1]
                        && grid[row][col] == grid[row + 2][col + 2]
                        && grid[row][col] == grid[row + 3][col + 3]) {
                    return true;
                }
            }
        }
        return false;
    }
}
