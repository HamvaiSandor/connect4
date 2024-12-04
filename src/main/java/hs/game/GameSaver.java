package hs.game;
import hs.board.Board;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Kezeli a játék állapotának fájlba történő mentését.
 *
 * <p>Megjegyzés: A GameSaver alosztályozása során ügyeljen arra,
 * hogy a saveGame metódus viselkedését ne változtassa meg a
 * váratlan játékállapot-problémák elkerülése érdekében.</p>
 */
public class GameSaver {

    /**
    * Menteni a jelenlegi játékállapotot egy fájlba.
     */

    public void saveGame(final Board board, final String playerName,
                          final boolean isHumanTurn) {
        try (FileWriter writer = new FileWriter(playerName + "_game.txt")) {
            writer.write(isHumanTurn ? "H\n" : "C\n");
            for (char[] row : board.getGrid()) {
                writer.write(new String(row) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
