package hs.game;

import hs.player.Player;
import java.util.Scanner;

/**
 * Kezeli a játékosok beállítását és üdvözlését a játék során.
 */

public class GameSetup {

/**
 * Beállítja az emberi játékost a megadott név alapján.
 */
    public Player setupHumanPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        return new Player('O', playerName); // O for Yellow
        }

/**
 * Beállítja a számítógépes játékost.
 */
        public Player setupComputerPlayer() {
        return new Player('X', "Computer"); // X for Red
            }

/**
 * Üdvözli az emberi játékost a játékban.
 */
            public void welcomePlayer(final Player human) {
        System.out.println("Welcome to Connect4, " + human.getName() + "!");
    }
}
