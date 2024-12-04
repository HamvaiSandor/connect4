package hs.org.example.model;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Egy játékost jelöl a játékban, amely tartalmazza a nevét
 * és a játék állapotát.
 */
@XmlRootElement
public class Player {
    private String name;
    private String gameState;

    /**
     * Alapértelmezett konstruktor a JAXB számára.
     */
    public Player() {
    }

/**
 * Létrehoz egy új játékos objektumot a megadott névvel
 * és játék állapottal.
 */
    public String getName() {
        return name;
    }

    /**
     * Beállítja a játékos nevét.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Visszaadja a játékos játék állapotát.
     */
    public String getGameState() {
        return gameState;
    }

    /**
     * Beállítja a játékos játék állapotát.
     */
    public void setGameState(final String gameState) {
        this.gameState = gameState;
    }

/**
 * Visszaadja a játékos nevét.
 */
    public Player(final String name, final String gameState) {
        this.name = name;
        this.gameState = gameState;
    }

/**
 * Visszaadja a játékos adatait string formátumban.
 */
    @Override
    public String toString() {
        return "Player{"
                + "name='" + name + '\''
                + ", gameState='"
                + gameState
                + '\''
                +
                '}';
    }
}
