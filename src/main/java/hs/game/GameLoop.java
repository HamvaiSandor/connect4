package hs.game;

import hs.board.Board;
import hs.board.BoardPrinter;
import hs.checker.WinChecker;
import hs.player.Player;

/**
 * Kezeli a játék fő ciklusát, ahol a játékosok felváltva lépnek.
*/
public class GameLoop {
    private final Board board;
    private final BoardPrinter boardPrinter;
    private final WinChecker winChecker;
    private final HumanPlayerTurn humanPlayerTurn;
    private final ComputerPlayerTurn computerPlayerTurn;
    private final GameSaver gameSaver;
    private final Player human;
    private final Player computer;
    private boolean isHumanTurn;

/**
 * Létrehoz egy új GameLoop példányt a megadott paraméterekkel.
 */

    public GameLoop(final Board board,
                    final BoardPrinter boardPrinter,
                    final WinChecker winChecker,
                    final HumanPlayerTurn humanPlayerTurn,
                    final ComputerPlayerTurn computerPlayerTurn,
                    final GameSaver gameSaver,
                    final Player human,
                    final Player computer,
                    final boolean isHumanTurn) {
        this.board = board;
        this.boardPrinter = boardPrinter;
        this.winChecker = winChecker;
        this.humanPlayerTurn = humanPlayerTurn;
        this.computerPlayerTurn = computerPlayerTurn;
        this.gameSaver = gameSaver;
        this.human = human;
        this.computer = computer;
        this.isHumanTurn = isHumanTurn;
    }

    /**
     * Elindítja a játékot, ahol a játékosok felváltva lépnek,
     * amíg valaki győzelmet nem arat, vagy a játék döntetlennel végződik.
     */
    public void start() {
        boardPrinter.printBoard(board.getGrid());
        while (true) {
            boolean pieceAdded;
            if (isHumanTurn) {
                pieceAdded = humanPlayerTurn.executeTurn(
                        board, human, isHumanTurn);
                if (!pieceAdded) {
                    System.out.println("Column full! Try again.");
                    continue;
                }
            } else {
                computerPlayerTurn.executeTurn(board, computer);
            }
            boardPrinter.printBoard(board.getGrid());
            if (winChecker.checkWin(board.getGrid())) {
                System.out.println((isHumanTurn
                        ? human.getName() : "Computer") + " wins!");
                break;
            }
            if (board.isFull()) {
                System.out.println("The game is a draw!");
                break;
            }
            isHumanTurn = !isHumanTurn;
        }
    }
}
