package hs.player;

/**
 * Egy játékost jelöl a játékban.
 */
public class Player {
    private char playerSymbol;
    private String name;

     public Player(final char symbol, final String playerName) {
        this.playerSymbol = symbol;
        this.name = playerName;
    }

    /**
     * Visszaadja a játékoshoz társított szimbólumot.
     * Nem szabad felülírni ezt a metódust a konzisztencia miatt.
     */
    public char getSymbol() {
        return playerSymbol;
    }

    /**
     * Visszaadja a játékos nevét.
     */
    public String getName() {
        return name;
    }
}
