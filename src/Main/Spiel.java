package Main;

import Charaktere.Gegner;
import Charaktere.Spieler;
import Skills.Skills;
import Util.Eingabe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import static Main.SpielPanel.*;


public class Spiel {
    static SpielFrame spielFrame;
    static SpielPanel spielPanel;
    static Eingabe eingabe;
    static Spieler spieler;
    static Gegner gegner;
    static boolean kampf;
    static ActionListener Skill1;

    //Charaktere(String name, int maxHp, int maxSp, int exp, int lvl, int str, int dex, int kno, int wis)
    static Gegner[] gegnerListeT1 = new Gegner[2];
    static int expNeed = 50;

    public Spiel() {
        spieler = new Spieler();
        gegner = new Gegner();
        spielPanel = new SpielPanel();
        spielFrame = new SpielFrame(spielPanel);
        eingabe = new Eingabe(spielPanel);
        spielPanel.addKeyListener(eingabe);
        gegnerInitialisieren();
    }
    public static void gegnerInitialisieren() {
        gegnerListeT1[0] = Gegner.fledermaus;
        gegnerListeT1[1] = Gegner.schneemann;
    }
    public static void Test() {
        UpdateSpieler();
        JFrame adminFrame = new JFrame("Admin");
        JPanel adminPanel = new JPanel();
        adminPanel.addKeyListener(eingabe);
        adminPanel.setFocusable(true);


        //region admin button
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

        //endregion

        adminFrame.add(adminPanel);
        adminFrame.setPreferredSize(new Dimension(400,400));
        adminFrame.pack();
        adminFrame.setResizable(false);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setVisible(true);
    }
    public static void UpdateSpieler(){
        if (!spieler.amLeben()) spielPanel.setGameOverScreen();
        if (spieler.getHp() > spieler.getMaxHp()) spieler.setHp(spieler.getMaxHp());
        if (spieler.getSp() > spieler.getMaxSp()) spieler.setSp(spieler.getMaxSp());

        spielerNameLbl.setText(spieler.getName() + " Lvl " + spieler.getLvl());
        spielerHp.setText(spieler.getHp() + "/" + spieler.getMaxHp());
        spielerHpBar.setValue(spieler.getHp());
        spielerSp.setText(spieler.getSp() + "/" + spieler.getMaxSp());
        spielerSpBar.setValue(spieler.getSp());
        spielerExp.setText("" + spieler.getExp());
        spielerExpBar.setValue(spieler.getExp());
        spielerAtk.setText("" + spieler.getAtk());
        spielerDef.setText("" + spieler.getDef());
        spielerStr.setText("" + spieler.getStr());
        spielerDex.setText("" + spieler.getDex());
        spielerKno.setText("" + spieler.getKno());
        spielerWis.setText("" + spieler.getWis());
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
        KampfBeginn();
    }
    public static void KampfBeginn() {
        kampf = true;
        skillBtn1.setEnabled(true);
        skillBtn2.setEnabled(true);
        skillBtn3.setEnabled(true);
        skillBtn4.setEnabled(true);
        skillBtn5.setEnabled(true);
        SpielPanel.gegnerPanel.setVisible(true);
    }
    public static void KampfEnde() {
        kampf = false;
        skillBtn1.setEnabled(false);
        skillBtn2.setEnabled(false);
        skillBtn3.setEnabled(false);
        skillBtn4.setEnabled(false);
        skillBtn5.setEnabled(false);
        SpielPanel.gegnerPanel.setVisible(false);
    }
    public static void Kampf() {
        Timer timer = new Timer(100, e -> {
            if (spieler.amLeben() & gegner.amLeben()) {
                int angriff = spieler.angriff("str", 100);
                gegner.setHp(gegner.getHp() - angriff);
                gegnerHpBar.setValue(gegner.getHp());
                textLog.append("\n" + spieler.getName() + " verursacht " + angriff + " Schaden an " + gegner.getName() + "!");

                Timer timer2 = new Timer(700, e1 -> {
                    if (gegner.amLeben() & spieler.amLeben()) {
                        int gegnerAngriff = gegner.angriff("str", 100);
                        spieler.setHp(spieler.getHp() - gegnerAngriff);
                        spielerHp.setText(spieler.getHp() + "/" + spieler.getMaxHp());
                        spielerHpBar.setValue(spieler.getHp());
                        textLog.append("\n" + gegner.getName() + " verursacht " + gegnerAngriff + " Schaden an " + spieler.getName() + "!");

                        Timer timer3 = new Timer(700, e2 -> {
                            if (!spieler.amLeben()) {
                                System.out.println("Verloren");
                                KampfEnde();
                                spielPanel.setGameOverScreen();
                            }
                        });
                        timer3.setRepeats(false);
                        timer3.start();
                    } else if (!gegner.amLeben()) {
                        System.out.println("Gewonnen");
                        UpdateExp(gegner.getExp());
                        KampfEnde();
                        textLog.append("\nKampf gewonnen!\n" + gegner.getExp() + " Erfahrungspunkte erhalten.");
                    } else if (!spieler.amLeben()) {
                        System.out.println("Verloren");
                        KampfEnde();
                        spielPanel.setGameOverScreen();
                    }
                });
                timer2.setRepeats(false);
                timer2.start();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    public static void UpdateExp(int x) {
        spieler.setExp(spieler.getExp()+x);
        spielerExp.setText("" + spieler.getExp());
        spielerExpBar.setValue(spieler.getExp());
        CheckLevelUp();
    }
    public static void CheckLevelUp() {
        if ((spieler.getExp()) >= (expNeed)) {
            spieler.setLvl(spieler.getLvl()+1);
            UpdateSpieler();
            expNeed = (int) ((5000/11)*((Math.pow(1.11,(spieler.getLvl())))-1));
        }
    }
    //region skill button
    public static void SkillInit(){
        skillBtn1.addActionListener(e -> {
            Kampf();
        });
    }
    public static void Skill1Aenderung(Skills x) {
        skillBtn1.setIcon(x.getBild());
        skillBtn1.addMouseListener(new MouseListener() {
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
                skillInfoPanel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                SpielPanel.skillLblName.setText("");
                SpielPanel.skillLblKraft.setText("");
                SpielPanel.skillLblGenauigkeit.setText("");
                skillInfoPanel.setVisible(false);

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
                skillInfoPanel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                SpielPanel.skillLblName.setText("");
                SpielPanel.skillLblKraft.setText("");
                SpielPanel.skillLblGenauigkeit.setText("");
                skillInfoPanel.setVisible(false);
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
                skillInfoPanel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                SpielPanel.skillLblName.setText("");
                SpielPanel.skillLblKraft.setText("");
                SpielPanel.skillLblGenauigkeit.setText("");
                skillInfoPanel.setVisible(false);
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
                skillInfoPanel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                SpielPanel.skillLblName.setText("");
                SpielPanel.skillLblKraft.setText("");
                SpielPanel.skillLblGenauigkeit.setText("");
                skillInfoPanel.setVisible(false);
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
                skillInfoPanel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                SpielPanel.skillLblName.setText("");
                SpielPanel.skillLblKraft.setText("");
                SpielPanel.skillLblGenauigkeit.setText("");
                skillInfoPanel.setVisible(false);
            }
        });
    }
    public static void SkillLblInfoUpdate(String name, int kraft, int genauigkeit, String mod) {
        skillLblName.setText(name);
        skillLblGenauigkeit.setText(genauigkeit + "%");

        switch (mod) {
            case "str":
                skillLblKraft.setText("<html>Kraft: <font color='#ff0000'>" + kraft);
                break;
            case "dex":
                skillLblKraft.setText("<html>Kraft: <font color='#3cb371'>" + kraft);
                break;
        }
        
    }
    //endregion
}
