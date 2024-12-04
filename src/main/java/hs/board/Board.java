package hs.board;
/**
 * Kezeli a játék tábláját, beleértve a darabok hozzáadását
 * és a tábla állapotának ellenőrzését.
 */
public class Board {
    private final char[][] grid;

    /**
     * Létrehoz egy új, 6 sorból és 7 oszlopból álló játék táblát,
     * üres pozíciókkal.
     */
    public Board() {
        grid = new char[6][7];
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                grid[row][col] = '.';
            }
        }
    }

/**
 * Visszaadja a játék táblájának jelenlegi állapotát.
 */
    public char[][] getGrid() {
        return grid;
    }

/**
 * Hozzáad egy darabot a megadott oszlophoz.
 */
    public boolean addPiece(final int column, final char symbol) {
        if (column < 0 || column >= 7) {
            return false;
        }
        for (int row = 5; row >= 0; row--) {
            if (grid[row][column] == '.') {
                grid[row][column] = symbol;
                return true;
            }
        }
        return false;
    }

/**
 * Ellenőrzi, hogy a tábla tele van-e.
 */
    public boolean isFull() {
        for (int col = 0; col < 7; col++) {
            if (grid[0][col] == '.') {
                return false;
            }
        }
        return true;
    }
}
