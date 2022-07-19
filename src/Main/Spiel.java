package Main;

public class Spiel {
    SpielFrame spielFrame;
    SpielPanel spielPanel;

    public Spiel() {
        spielPanel = new SpielPanel();
        spielFrame = new SpielFrame(spielPanel);
    }
}
