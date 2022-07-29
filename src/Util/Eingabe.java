package Util;

import Main.SpielPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static Main.SpielPanel.*;

public class Eingabe implements KeyListener {
    SpielPanel spielPanel;

    public Eingabe(SpielPanel spielPanel) {
        this.spielPanel = spielPanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_1:
                skillBtn1.doClick();
                break;
            case KeyEvent.VK_2:
                skillBtn2.doClick();
                break;
            case KeyEvent.VK_3:
                skillBtn3.doClick();
                break;
            case KeyEvent.VK_4:
                skillBtn4.doClick();
                break;
            case KeyEvent.VK_5:
                skillBtn5.doClick();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
