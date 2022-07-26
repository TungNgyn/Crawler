package Main;

import Charaktere.Gegner;
import Charaktere.Spieler;
import Skills.SkillsRitter;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

        SpielPanel.skillBtn1.setIcon(SkillsRitter.skillAngriff.getBild());
        SpielPanel.skillBtn2.setIcon(SkillsRitter.skillSchuss.getBild());
        SpielPanel.skillBtn1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                SkillLblInfoUpdate(SkillsRitter.skillAngriff.getName(), SkillsRitter.skillAngriff.getMod(), SkillsRitter.skillAngriff.getKraft());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                SpielPanel.skillLblName.setText("");
                SpielPanel.skillLblKraft.setText("");
                SpielPanel.skillLblMod.setText("");

            }
        });
        SpielPanel.skillBtn2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                SkillLblInfoUpdate(SkillsRitter.skillSchuss.getName(), SkillsRitter.skillSchuss.getMod(), SkillsRitter.skillSchuss.getKraft());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                SpielPanel.skillLblName.setText("");
                SpielPanel.skillLblKraft.setText("");
                SpielPanel.skillLblMod.setText("");

            }
        });


}
    public static void SkillLblInfoUpdate(String name, String mod, int kraft) {
        SpielPanel.skillLblName.setText(name);
        SpielPanel.skillLblKraft.setText("Kraft: " + kraft);

        switch (mod){
            case "str":
                SpielPanel.skillLblMod.setText("Stärke");
                SpielPanel.skillLblMod.setForeground(Color.RED);
                break;
            case "dex":
                SpielPanel.skillLblMod.setText("Geschick");
                SpielPanel.skillLblMod.setForeground(Color.GREEN);
                break;
            case "kno":
                SpielPanel.skillLblMod.setText("Intelligenz");
                SpielPanel.skillLblMod.setForeground(Color.BLUE);
                break;
            case "wis":
                SpielPanel.skillLblMod.setText("Weisheit");
                SpielPanel.skillLblMod.setForeground(Color.YELLOW);
                break;
        }
    }
}
