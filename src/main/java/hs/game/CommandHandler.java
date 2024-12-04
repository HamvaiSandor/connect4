package hs.game;

import hs.board.Board;
import java.util.Scanner;

/**
 * Kezeli a parancsok beolvasását és feldolgozását a játék során.
 */

public class CommandHandler {
   private final GameSaver gameSaver;
   private final Scanner scanner;

/**
 * Létrehoz egy új CommandHandler példányt a megadott paraméterekkel.
 */
    public CommandHandler(final GameSaver gameSaver, final Scanner scanner) {
        this.gameSaver = gameSaver;
        this.scanner = scanner;
    }

/**
 * Beolvassa a felhasználó által megadott parancsot.
 */
    public String readCommand() {
        String command = scanner.nextLine();
        if ("EXIT".equalsIgnoreCase(command)) {
            return "EXIT";
        }
        return command;
    }

/**
 * Kezeli az "EXIT" parancsot, elmentve a játék állapotát
 * és kilépve a programból.
 */
    public void handleExitCommand(
            final Board board,
            final String playerName,
            final boolean isHumanTurn
    ) {
        gameSaver.saveGame(board, playerName, isHumanTurn);
        System.out.println("Game saved. Exiting...");
        System.exit(0);
    }
}
