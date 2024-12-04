package hs.checker;

/**
 * Ellenőrzi a játék tábláján a függőleges nyerő kombinációkat.
 */
public class VerticalChecker {

/**
 * Ellenőrzi, hogy van-e nyerő kombináció a függőleges sorokban.
 */
    public boolean check(final char[][] grid) {
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row < 3; row++) {
                if (grid[row][col] != '.'
                        && grid[row][col] == grid[row + 1][col]
                        && grid[row][col] == grid[row + 2][col]
                        && grid[row][col] == grid[row + 3][col]) {
                    return true;
                }
            }
        }
        return false;
    }
}
