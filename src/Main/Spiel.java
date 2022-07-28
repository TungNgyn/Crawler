package Main;

import Charaktere.Gegner;
import Charaktere.Spieler;
import Skills.Skills;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import static Main.SpielPanel.*;


public class Spiel {
    SpielFrame spielFrame;
    SpielPanel spielPanel;
    static Spieler spieler;
    static Gegner gegner;

    //Charaktere(String name, int maxHp, int maxSp, int exp, int lvl, int str, int dex, int kno, int wis)
    static Gegner[] gegnerListeT1 = new Gegner[2];


    public Spiel() {
        spieler = new Spieler();
        gegner = new Gegner();
        spielPanel = new SpielPanel();
        spielFrame = new SpielFrame(spielPanel);
        gegnerInitialisieren();
    }
    public static void gegnerInitialisieren() {
        gegnerListeT1[0] = Gegner.fledermaus;
        gegnerListeT1[1] = Gegner.schneemann;
    }
    public static void Test() {
        spielerHpBar.setValue(spieler.getHp());
        spielerSpBar.setValue(spieler.getSp());
        spielerExpBar.setValue(spieler.getExp());

        JFrame adminFrame = new JFrame("Admin");
        JPanel adminPanel = new JPanel();

        JButton hpDownBtn = new JButton("-5 HP");
        JButton hpUpBtn = new JButton("+5 HP");
        JButton spDownBtn = new JButton("-5 SP");
        JButton spUpBtn = new JButton("+5 SP");
        JButton encBtn = new JButton("Random Encounter");


        hpDownBtn.addActionListener(e -> {
            spieler.setHp(spieler.getHp()-5);
            UpdateSpieler();
        });
        hpUpBtn.addActionListener(e -> {
            spieler.setHp(spieler.getHp()+5);
            UpdateSpieler();
        });
        spDownBtn.addActionListener(e -> {
            spieler.setSp(spieler.getSp()-5);
            UpdateSpieler();
        });
        spUpBtn.addActionListener(e -> {
            spieler.setSp(spieler.getSp()+5);
            UpdateSpieler();
        });
        encBtn.addActionListener(e -> {
            Random rnd = new Random();
            int i = rnd.nextInt(2);
            Encounter(gegnerListeT1[i],1);
        });


        adminPanel.add(hpDownBtn);
        adminPanel.add(hpUpBtn);
        adminPanel.add(spDownBtn);
        adminPanel.add(spUpBtn);
        adminPanel.add(encBtn);

        adminFrame.add(adminPanel);
        adminFrame.setPreferredSize(new Dimension(400,400));
        adminFrame.pack();
        adminFrame.setResizable(false);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setVisible(true);
    }
    public static void UpdateSpieler(){
        spielerHp.setText(spieler.getHp() + "/" + spieler.getMaxHp());
        spielerHpBar.setValue(spieler.getHp());
        spielerSp.setText(spieler.getSp() + "/" + spieler.getMaxSp());
        spielerSpBar.setValue(spieler.getSp());
    }
    public static void Encounter(Gegner x, int lvl) {
        //Charaktere(String name, int maxHp, int maxSp, int exp, int lvl, int str, int dex, int kno, int wis, ImageIcon bild)
        gegner.setName(x.getName());
        gegner.setMaxHp(x.getMaxHp()+(10*lvl));
        gegner.setHp(gegner.getMaxHp());
        gegner.setMaxSp(x.getMaxSp()+(10*lvl));
        gegner.setSp(gegner.getMaxSp());
        gegner.setExp(x.getExp()+(10*lvl));
        gegner.setStr(x.getStr()+(1*lvl));
        gegner.setDex(x.getDex()+(1*lvl));
        gegner.setKno(x.getKno()+(1*lvl));
        gegner.setWis(x.getWis()+(1*lvl));
        gegner.setLvl(lvl);
        gegnerBildLbl.setIcon(x.getBild());
        gegnerNameLbl.setText(x.getName() + " Lvl " + lvl);
        gegnerHpBar.setMaximum(gegner.getMaxHp());
        gegnerHpBar.setValue(gegner.getHp());
    }
    //region skilländerung
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
                SkillLblInfoUpdate(x.getName(), x.getKraft(), x.getGenauigkeit(), x.getMod());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                SpielPanel.skillLblName.setText("");
                SpielPanel.skillLblKraft.setText("");
                SpielPanel.skillLblGenauigkeit.setText("");

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
                SkillLblInfoUpdate(x.getName(), x.getKraft(), x.getGenauigkeit(), x.getMod());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                SpielPanel.skillLblName.setText("");
                SpielPanel.skillLblKraft.setText("");
                SpielPanel.skillLblGenauigkeit.setText("");
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
                SkillLblInfoUpdate(x.getName(), x.getKraft(), x.getGenauigkeit(), x.getMod());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                SpielPanel.skillLblName.setText("");
                SpielPanel.skillLblKraft.setText("");
                SpielPanel.skillLblGenauigkeit.setText("");
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
                SkillLblInfoUpdate(x.getName(), x.getKraft(), x.getGenauigkeit(), x.getMod());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                SpielPanel.skillLblName.setText("");
                SpielPanel.skillLblKraft.setText("");
                SpielPanel.skillLblGenauigkeit.setText("");
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
                SkillLblInfoUpdate(x.getName(), x.getKraft(), x.getGenauigkeit(), x.getMod());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                SpielPanel.skillLblName.setText("");
                SpielPanel.skillLblKraft.setText("");
                SpielPanel.skillLblGenauigkeit.setText("");
            }
        });
    }
    public static void SkillLblInfoUpdate(String name, int kraft, int genauigkeit, String mod) {
        SpielPanel.skillLblName.setText(name);
        SpielPanel.skillLblGenauigkeit.setText(genauigkeit + "%");

        switch (mod) {
            case "str":
                SpielPanel.skillLblKraft.setText("<html>Kraft: <font color='#ff0000'>" + kraft);
                break;
            case "dex":
                SpielPanel.skillLblKraft.setText("<html>Kraft: <font color='#3cb371'>" + kraft);
                break;
        }
        
    }
    //endregion
}
