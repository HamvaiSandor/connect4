package hs.game;

import hs.board.Board;
import hs.player.Player;

/**
 * Kezeli az emberi játékos lépéseit a játék során.
 */
public class HumanPlayerTurn {
    private final CommandHandler commandHandler;

    /**
     * Létrehoz egy új HumanPlayerTurn példányt a megadott CommandHandler-rel.
     */
    public HumanPlayerTurn(final CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

/**
 * Végrehajtja az emberi játékos lépését.
 */
    public boolean executeTurn(final Board board, final Player human,
                               final boolean isHumanTurn) {
        System.out.print("Enter column (a-g) or EXIT to quit: ");
        String input = commandHandler.readCommand();
        if ("EXIT".equalsIgnoreCase(input)) {
            commandHandler.handleExitCommand(
                    board, human.getName(), isHumanTurn);
        }
        int col = input.charAt(0) - 'a';
        return board.addPiece(col, human.getSymbol());
    }
}
