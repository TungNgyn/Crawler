package Main;

import Charaktere.Spieler;
import Skills.Skills;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static Skills.Skills.*;

public class Spiel {
    SpielFrame spielFrame;
    SpielPanel spielPanel;
    static Spieler spieler;

    public Spiel() {
        spieler = new Spieler();
        spielPanel = new SpielPanel();
        spielFrame = new SpielFrame(spielPanel);
    }

    public static void Test() {
        Skill1Aenderung(skillAngriff);
        Skill2Aenderung(skillAnsturm);
        Skill3Aenderung(skillBlitzschlag);
        Skill4Aenderung(skillStampfer);
        Skill5Aenderung(skillBrutalerSchlag);
}
    public static void Skill1Aenderung(Skills x) {
        SpielPanel.skillBtn1.setIcon(x.getBild());
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
                SkillLblInfoUpdate(x.getName(), x.getMod(), x.getKraft());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                SpielPanel.skillLblName.setText("");
                SpielPanel.skillLblKraft.setText("");
                SpielPanel.skillLblMod.setText("");

            }
        });
    }
    public static void Skill2Aenderung(Skills x) {
        SpielPanel.skillBtn2.setIcon(x.getBild());
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
                SkillLblInfoUpdate(x.getName(), x.getMod(), x.getKraft());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                SpielPanel.skillLblName.setText("");
                SpielPanel.skillLblKraft.setText("");
                SpielPanel.skillLblMod.setText("");
            }
        });
    }
    public static void Skill3Aenderung(Skills x) {
        SpielPanel.skillBtn3.setIcon(x.getBild());
        SpielPanel.skillBtn3.addMouseListener(new MouseListener() {
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
                SkillLblInfoUpdate(x.getName(), x.getMod(), x.getKraft());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                SpielPanel.skillLblName.setText("");
                SpielPanel.skillLblKraft.setText("");
                SpielPanel.skillLblMod.setText("");
            }
        });
    }
    public static void Skill4Aenderung(Skills x) {
        SpielPanel.skillBtn4.setIcon(x.getBild());
        SpielPanel.skillBtn4.addMouseListener(new MouseListener() {
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
                SkillLblInfoUpdate(x.getName(), x.getMod(), x.getKraft());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                SpielPanel.skillLblName.setText("");
                SpielPanel.skillLblKraft.setText("");
                SpielPanel.skillLblMod.setText("");
            }
        });
    }
    public static void Skill5Aenderung(Skills x) {
        SpielPanel.skillBtn5.setIcon(x.getBild());
        SpielPanel.skillBtn5.addMouseListener(new MouseListener() {
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
                SkillLblInfoUpdate(x.getName(), x.getMod(), x.getKraft());
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
