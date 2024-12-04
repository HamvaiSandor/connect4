package hs.game;
import hs.board.Board;
import hs.board.BoardPrinter;
import hs.checker.WinChecker;
import hs.player.Player;

/**
 * Kezeli a játék irányítását, beleértve a játék beállítását,
 * mentését és betöltését.
 */

public class GameController {
    private final GameSetup gameSetup;
    private final GameLoop gameLoop;
    private final GameSaver gameSaver;
    private final GameLoader gameLoader;
    private final Board board;
    private final BoardPrinter boardPrinter;
    private final WinChecker winChecker;
    private final HumanPlayerTurn humanPlayerTurn;
    private final ComputerPlayerTurn computerPlayerTurn;
    private final CommandHandler commandHandler;


/**
 * Létrehoz egy új GameController példányt a megadott paraméterekkel.
 */
    public GameController(
            final Board board,
            final BoardPrinter boardPrinter,
            final WinChecker winChecker,
            final GameSetup gameSetup,
            final GameLoop gameLoop,
            final GameSaver gameSaver,
            final GameLoader gameLoader,
            final HumanPlayerTurn humanPlayerTurn,
            final ComputerPlayerTurn computerPlayerTurn,
            final CommandHandler commandHandler) {
        this.board = board;
        this.boardPrinter = boardPrinter;
        this.winChecker = winChecker;
        this.gameSetup = gameSetup;
        this.gameLoop = gameLoop;
        this.gameSaver = gameSaver;
        this.gameLoader = gameLoader;
        this.humanPlayerTurn = humanPlayerTurn;
        this.computerPlayerTurn = computerPlayerTurn;
        this.commandHandler = commandHandler;
    }

    /**
     * Visszaadja a játék fő ciklusát kezelő objektumot.
     */
    public GameLoop getGameLoop() {
        return gameLoop;
    }

    /**
     * Visszaadja a parancs kezelőt.
     */
    public CommandHandler getCommandHandler() {
        return commandHandler;
    }

    /**
     * Elindítja a játékot, beállítja a játékosokat,
     * betölti a játékot és elindítja a fő ciklust.
     */

    public void start() {
        Player human = gameSetup.setupHumanPlayer();
        Player computer = gameSetup.setupComputerPlayer();
        boolean isHumanTurn = gameLoader.loadGame(board, human.getName());
        gameSetup.welcomePlayer(human);
        GameLoop gameLoop = new GameLoop(board, boardPrinter, winChecker,
                humanPlayerTurn, computerPlayerTurn, gameSaver,
                human, computer, isHumanTurn);
        gameLoop.start();
    }
}
