package hs;

import hs.board.Board;
import hs.board.BoardPrinter;
import hs.checker.DiagonalChecker;
import hs.checker.HorizontalChecker;
import hs.checker.VerticalChecker;
import hs.checker.WinChecker;
import hs.game.GameController;
import hs.game.GameLoader;
import hs.game.GameSaver;
import hs.game.GameLoop;
import hs.game.GameSetup;
import hs.game.HumanPlayerTurn;
import hs.game.ComputerPlayerTurn;
import hs.game.CommandHandler;
import java.util.Scanner;

/**
 * A fő alkalmazás osztály, amely elindítja a játékot.
 */
 public final class Main {
    private Main() {
        throw new UnsupportedOperationException("Utility class");
    }
/**
 * Az alkalmazás belépési pontja.
 */
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        BoardPrinter boardPrinter = new BoardPrinter();
        HorizontalChecker horizontalChecker = new HorizontalChecker();
        VerticalChecker verticalChecker = new VerticalChecker();
        DiagonalChecker diagonalChecker = new DiagonalChecker();
        WinChecker winChecker = new WinChecker(
                horizontalChecker, verticalChecker, diagonalChecker);
        GameSetup gameSetup = new GameSetup();
        GameSaver gameSaver = new GameSaver();
        GameLoader gameLoader = new GameLoader();
        CommandHandler commandHandler = new CommandHandler(gameSaver, scanner);
        HumanPlayerTurn humanPlayerTurn = new HumanPlayerTurn(commandHandler);
        ComputerPlayerTurn computerPlayerTurn = new ComputerPlayerTurn();
        GameLoop gameLoop = new GameLoop(
                board, boardPrinter, winChecker,
                humanPlayerTurn, computerPlayerTurn, gameSaver,
                null, null, true
        );


        GameController gameController = new GameController(
                board, boardPrinter, winChecker, gameSetup,
                gameLoop, gameSaver, gameLoader, humanPlayerTurn,
                computerPlayerTurn, commandHandler
        );
        gameController.start();
    }
}
