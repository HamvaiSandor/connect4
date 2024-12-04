package hs.board;

/**
 * Kezeli a játék tábla megjelenítését.
 */
public class BoardPrinter {

/**
 * Kinyomtatja a játék tábla jelenlegi állapotát.
 */
    public void printBoard(final char[][] grid) {
        System.out.println(" a b c d e f g");
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                System.out.print(" " + grid[row][col]);
            }
            System.out.println();
        }
    }
}
