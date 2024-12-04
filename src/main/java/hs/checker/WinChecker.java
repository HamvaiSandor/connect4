package hs.checker;

/**
 * Ellenőrzi, hogy van-e nyerő kombináció a játék tábláján.
 */
public class WinChecker {
    private final HorizontalChecker horizontalChecker;
    private final VerticalChecker verticalChecker;
    private final DiagonalChecker diagonalChecker;

/**
 * Létrehoz egy új WinChecker példányt a megadott ellenőrökkel.
 */
    public WinChecker(final HorizontalChecker horizontalChecker,
                      final VerticalChecker verticalChecker,
                      final DiagonalChecker diagonalChecker) {
        this.horizontalChecker = horizontalChecker;
        this.verticalChecker = verticalChecker;
        this.diagonalChecker = diagonalChecker;
    }

/**
 * Ellenőrzi, hogy van-e nyerő kombináció a táblán.
 */
    public boolean checkWin(final char[][] grid) {
        return horizontalChecker.check(grid)
                || verticalChecker.check(grid)
                || diagonalChecker.check(grid);
    }
}
