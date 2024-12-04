package hs.game;
import hs.board.Board;
import hs.player.Player;
import java.util.Random;

/**
 * Kezeli a számítógépes játékos lépéseit a játék során.
 */
public class ComputerPlayerTurn {
    private final Random rand = new Random();

/**
 * Végrehajtja a számítógépes játékos lépését.
 */
    public void executeTurn(final Board board, final Player computer) {
        int col;
        do {
            col = rand.nextInt(7);
        } while (!board.addPiece(col, computer.getSymbol()));
        System.out.println("Computer chose column: " + (char) ('a' + col));
    }
}
