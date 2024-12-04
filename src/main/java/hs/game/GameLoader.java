package hs.game;
import hs.board.Board;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Kezeli a játék betöltését egy fájlból.
 */

public class GameLoader {

/**
 * Betölti a játék állapotát egy fájlból a megadott játékos nevével.
 */
    public boolean loadGame(final Board board, final String playerName) {
        try (BufferedReader reader = new BufferedReader(
                        new FileReader(playerName + "_game.txt"))) {
            String line = reader.readLine();
            boolean isHumanTurn = "H".equals(line);
            char[][] grid = board.getGrid();
            for (int i = 0; i < 6; i++) {
                line = reader.readLine();
                for (int j = 0; j < 7; j++) {
                    grid[i][j] = line.charAt(j);
                }
            }
            return isHumanTurn;
        } catch (IOException e) {
            return false;
        }
    }
}
