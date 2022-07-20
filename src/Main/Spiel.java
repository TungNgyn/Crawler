package Main;

import Charaktere.Gegner;
import Charaktere.Spieler;

public class Spiel {
    SpielFrame spielFrame;
    SpielPanel spielPanel;

    public Spiel() {
        spielPanel = new SpielPanel();
        spielFrame = new SpielFrame(spielPanel);
    }

    public static void Test() {
        Spieler spieler = new Spieler("Test", 50, 20, 0, 1,
                10, 6, 2, 3);
        Gegner gegner = new Gegner("Monster", 30, 10, 5, 1,
                8, 8, 1, 2);
    }


}
