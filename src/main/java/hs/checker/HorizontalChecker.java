package hs.checker;

/**
 * Ellenőrzi a játék tábláján a vízszintes nyerő kombinációkat.
 */
public class HorizontalChecker {

/**
 * Ellenőrzi, hogy van-e nyerő kombináció a vízszintes sorokban.
 */
    public boolean check(final char[][] grid) {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                if (grid[row][col] != '.'
                        && grid[row][col] == grid[row][col + 1]
                        && grid[row][col] == grid[row][col + 2]
                        && grid[row][col] == grid[row][col + 3]) {
                    return true;
                }
            }
        }
        return false;
    }
}
