package Main;

import Charaktere.Gegner;
import Charaktere.Spieler;
import Navigation.Navigation;
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
import static Navigation.Navigation.naviKampf;
import static Navigation.Navigation.naviLager;
import static Skills.Skills.*;
import static Skills.Skills.skillWyvernSchuss;


public class Spiel {
    static SpielFrame spielFrame;
    static SpielPanel spielPanel;
    static Eingabe eingabe;
    static Spieler spieler;
    static Gegner gegner;
    static boolean kampf;
    static ActionListener Skill1,Skill2,Skill3,Skill4,Skill5,Navi1,Navi2,Navi3,Navi4,Navi5,Navi6;

    static Gegner[] gegnerListeT1 = new Gegner[2];
    static Navigation[] naviListe = new Navigation[4];
    static int expNeed = 50;
    static int skillpunkte = 0;

    public Spiel() {
        spieler = new Spieler();
        gegner = new Gegner();
        spielPanel = new SpielPanel();
        spielFrame = new SpielFrame(spielPanel);
        eingabe = new Eingabe(spielPanel);
        spielPanel.addKeyListener(eingabe);
        GegnerInitialisieren();
        NaviInitialisieren();
    }
    public static void GegnerInitialisieren() {
        gegnerListeT1[0] = Gegner.fledermaus;
        gegnerListeT1[1] = Gegner.schneemann;
    }
    public static void NaviInitialisieren() {
        naviListe[0] = naviKampf;
        naviListe[1] = Navigation.naviLager;
        naviListe[2] = Navigation.naviEvent;
        naviListe[3] = Navigation.naviBoss;
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
        JButton lvlUpBtn = new JButton("Level up");


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
        lvlUpBtn.addActionListener(e -> {
            spieler.setExp(expNeed);
            CheckLevelUp();
        });


        adminPanel.add(hpDownBtn);
        adminPanel.add(hpUpBtn);
        adminPanel.add(spDownBtn);
        adminPanel.add(spUpBtn);
        adminPanel.add(encBtn);
        adminPanel.add(lvlUpBtn);

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
    //region battle
    public static void Encounter(Gegner x, int lvl) {
        naviPanel.setVisible(false);
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
        gegner.setMod(x.getMod());
        gegner.setAtk(x.getAtk());
        gegner.setDef(x.getDef());
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
        Timer timer = new Timer(1500, e -> {
            kampf = false;
            skillBtn1.setEnabled(false);
            skillBtn2.setEnabled(false);
            skillBtn3.setEnabled(false);
            skillBtn4.setEnabled(false);
            skillBtn5.setEnabled(false);
            gegnerPanel.setVisible(false);
            naviPanel.setVisible(true);
        });
        timer.setRepeats(false);
        timer.start();
    }
    public static void Kampf(String mod, int kraft, int genauigkeit) {
        skillBtn1.removeActionListener(Skill1);
        skillBtn2.removeActionListener(Skill2);
        skillBtn3.removeActionListener(Skill3);
        skillBtn4.removeActionListener(Skill4);
        skillBtn5.removeActionListener(Skill5);
        int treffer = (int) (Math.random()*100);
        Timer timer = new Timer(100, e -> {
            if (spieler.amLeben() & gegner.amLeben()) {
                if ((treffer < genauigkeit) & (treffer > 0)) {
                    SpielerAngriff(mod,kraft,genauigkeit);
                    Timer timer2 = new Timer(700, e1 -> {
                        if (gegner.amLeben() & spieler.amLeben()) {
                            GegnerAngriff(gegner.getMod(),kraft,genauigkeit);
                            Timer timer3 = new Timer(700, e2 -> {
                                if (!spieler.amLeben()) {
                                    KampfEnde();
                                    spielPanel.setGameOverScreen();
                                }
                                if (!gegner.amLeben()) {
                                    UpdateExp(gegner.getExp());
                                    KampfEnde();
                                    textLog.append("\nKampf gewonnen!\n" + gegner.getExp() + " Erfahrungspunkte erhalten.");
                                }
                                setSkills();
                            });
                            timer3.setRepeats(false);
                            timer3.start();
                        } else if (!gegner.amLeben()) {
                            UpdateExp(gegner.getExp());
                            KampfEnde();
                            textLog.append("\nKampf gewonnen!\n" + gegner.getExp() + " Erfahrungspunkte erhalten.");
                            setSkills();
                        } else if (!spieler.amLeben()) {
                            System.out.println("Verloren");
                            KampfEnde();
                            spielPanel.setGameOverScreen();
                        }
                    });
                    timer2.setRepeats(false);
                    timer2.start();
                } else if (treffer >= genauigkeit) {
                    textLog.append("\nVerfehlt...");
                    Timer timer2 = new Timer(700, e1 -> {
                        if (gegner.amLeben() & spieler.amLeben()) {
                            GegnerAngriff(gegner.getMod(), kraft, genauigkeit);
                            Timer timer3 = new Timer(700, e2 -> {
                                if (!spieler.amLeben()) {
                                    KampfEnde();
                                    spielPanel.setGameOverScreen();
                                }
                                if (!gegner.amLeben()) {
                                    System.out.println("Gewonnen");
                                    UpdateExp(gegner.getExp());
                                    KampfEnde();
                                    textLog.append("\nKampf gewonnen!\n" + gegner.getExp() + " Erfahrungspunkte erhalten.");
                                }
                                setSkills();
                            });
                            timer3.setRepeats(false);
                            timer3.start();
                        } else if (!gegner.amLeben()) {
                            UpdateExp(gegner.getExp());
                            KampfEnde();
                            textLog.append("\nKampf gewonnen!\n" + gegner.getExp() + " Erfahrungspunkte erhalten.");
                            setSkills();
                        } else if (!spieler.amLeben()) {
                            KampfEnde();
                            spielPanel.setGameOverScreen();
                        }
                    });
                    timer2.setRepeats(false);
                    timer2.start();
                } else if (treffer == 0) {
                    textLog.append("\nKritischer Treffer!");
                    SpielerAngriff(mod, kraft*2, genauigkeit);
                    Timer timer2 = new Timer(700, e1 -> {
                        if (gegner.amLeben() & spieler.amLeben()) {
                            GegnerAngriff(gegner.getMod(),kraft,genauigkeit);
                            Timer timer3 = new Timer(700, e2 -> {
                                if (!spieler.amLeben()) {
                                    KampfEnde();
                                    spielPanel.setGameOverScreen();
                                }
                                if (!gegner.amLeben()) {
                                    UpdateExp(gegner.getExp());
                                    KampfEnde();
                                    textLog.append("\nKampf gewonnen!\n" + gegner.getExp() + " Erfahrungspunkte erhalten.");
                                }
                                setSkills();
                            });
                            timer3.setRepeats(false);
                            timer3.start();
                        } else if (!gegner.amLeben()) {
                            UpdateExp(gegner.getExp());
                            KampfEnde();
                            textLog.append("\nKampf gewonnen!\n" + gegner.getExp() + " Erfahrungspunkte erhalten.");
                            setSkills();
                        } else if (!spieler.amLeben()) {
                            KampfEnde();
                            spielPanel.setGameOverScreen();
                        }
                    });
                    timer2.setRepeats(false);
                    timer2.start();
                }
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    public static void SpielerAngriff(String mod, int kraft, int genauigkeit) {
        int gegnerVerteidigung = gegner.verteidigung(mod);
        int spielerAngriff = spieler.angriff(mod, kraft) - gegnerVerteidigung;
        if (spielerAngriff <= 0) spielerAngriff = 0;
        gegner.setHp(gegner.getHp() - spielerAngriff);
        gegnerHpBar.setValue(gegner.getHp());
        textLog.append("\n" + spieler.getName() + " verursacht " + spielerAngriff + " Schaden an " + gegner.getName() + "!");
    }
    public static void GegnerAngriff(String mod, int kraft, int genauigkeit) {
        int spielerVerteidigung = spieler.verteidigung(gegner.getMod());
        int gegnerAngriff = gegner.angriff(gegner.getMod(), 100) - spielerVerteidigung;
        if (gegnerAngriff <= 0) gegnerAngriff = 0;
        spieler.setHp(spieler.getHp() - gegnerAngriff);
        spielerHp.setText(spieler.getHp() + "/" + spieler.getMaxHp());
        spielerHpBar.setValue(spieler.getHp());
        textLog.append("\n" + gegner.getName() + " verursacht " + gegnerAngriff + " Schaden an " + spieler.getName() + "!");
    }
    //endregion
    //region exp/lvl
    public static void UpdateExp(int x) {
        spieler.setExp(spieler.getExp()+x);
        spielerExp.setText("" + spieler.getExp());
        spielerExpBar.setValue(spieler.getExp());
        CheckLevelUp();
    }
    public static void CheckLevelUp() {
        //lvl up
        if ((spieler.getExp()) >= (expNeed)) {
            spielerExpBar.setMinimum(expNeed);
            spieler.setLvl(spieler.getLvl()+1);
            UpdateSpieler();
            expNeed = (int) ((5000/11)*((Math.pow(1.11,(spieler.getLvl())))-1));
            spielerExpBar.setMaximum(expNeed);
            SkillPunkte();
        }
    }
    //endregion
    //region navigation
    public static void Navi1Button(Navigation x) {
        navi1Btn.setIcon(x.getBild());
        Navi1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (x.getName()) {
                    case "Kampf":
                        Random rnd = new Random();
                        int i = rnd.nextInt(2);
                        Encounter(gegnerListeT1[i],1);
                        break;
                }
            }
        };
        navi1Btn.addActionListener(Navi1);
    }
    public static void Navi2Button(Navigation x) {
        Navi2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (x.getName()) {
                    case "Kampf":
                        Random rnd = new Random();
                        int i = rnd.nextInt(2);
                        Encounter(gegnerListeT1[i],1);
                        break;
                }
            }
        };
        navi2Btn.addActionListener(Navi2);
    }
    //endregion
    public static void setSkills() {
        switch (spieler.getName()) {
            case "Krieger":
                Skill1Aenderung(skillAngriff);
                Skill2Aenderung(skillAnsturm);
                Skill3Aenderung(skillDoppelschlag);
                Skill4Aenderung(skillStampfer);
                Skill5Aenderung(skillBrutalerSchlag);
                break;
            case "Jäger":
                Skill1Aenderung(skillSchuss);
                Skill2Aenderung(skillGezielterSchuss);
                Skill3Aenderung(skillMehrfachSchuss);
                Skill4Aenderung(skillAutomatischerSchuss);
                Skill5Aenderung(skillWyvernSchuss);
                break;
        }
    }
    public static void setNavi() {
        Navi1Button(naviKampf);
        Navi2Button(naviLager);
    }
    //region Skillpoints
    public static void SkillPunkte() {
        skillpunkte += 2;
        strUpBtn.setVisible(true);
        dexUpBtn.setVisible(true);
        knoUpBtn.setVisible(true);
        wisUpBtn.setVisible(true);
        statUpLbl.setVisible(true);
        statUpLbl.setText("(" + skillpunkte + ") Skillpunkte verfügbar!");
        System.out.println(skillpunkte);
    }
    public static void setStatUpBtn() {
        strUpBtn.addActionListener(e -> {
            skillpunkte -= 1;
            spieler.setStr(spieler.getStr()+1);
            spieler.setMaxHp(spieler.getMaxHp()+2);
            spieler.setHp(spieler.getHp()+2);
            spieler.setMaxSp(spieler.getMaxSp()+2);
            spieler.setSp(spieler.getSp()+2);
            spieler.setAtk(spieler.getAtk()+2);
            spieler.setDef(spieler.getDef()+2);
            statUpLbl.setText("(" + skillpunkte + ") Skillpunkte verfügbar!");
            if (skillpunkte <= 0){
                strUpBtn.setVisible(false);
                dexUpBtn.setVisible(false);
                knoUpBtn.setVisible(false);
                wisUpBtn.setVisible(false);
                statUpLbl.setVisible(false);
            }
            UpdateSpieler();
            System.out.println(skillpunkte);
        });
        dexUpBtn.addActionListener(e -> {
            skillpunkte -= 1;
            spieler.setDex(spieler.getDex()+1);
            spieler.setMaxHp(spieler.getMaxHp()+1);
            spieler.setHp(spieler.getHp()+1);
            spieler.setMaxSp(spieler.getMaxSp()+3);
            spieler.setSp(spieler.getSp()+3);
            spieler.setAtk(spieler.getAtk()+3);
            spieler.setDef(spieler.getDef()+1);
            statUpLbl.setText("(" + skillpunkte + ") Skillpunkte verfügbar!");
            if (skillpunkte <= 0){
                strUpBtn.setVisible(false);
                dexUpBtn.setVisible(false);
                knoUpBtn.setVisible(false);
                wisUpBtn.setVisible(false);
                statUpLbl.setVisible(false);
            }
            UpdateSpieler();
            System.out.println(skillpunkte);
        });
        knoUpBtn.addActionListener(e -> {
            skillpunkte -= 1;
            spieler.setKno(spieler.getKno()+1);
            spieler.setMaxHp(spieler.getMaxHp()+1);
            spieler.setHp(spieler.getHp()+1);
            spieler.setMaxSp(spieler.getMaxSp()+3);
            spieler.setSp(spieler.getSp()+3);
            spieler.setAtk(spieler.getAtk()+3);
            spieler.setDef(spieler.getDef()+1);
            statUpLbl.setText("(" + skillpunkte + ") Skillpunkte verfügbar!");
            if (skillpunkte <= 0){
                strUpBtn.setVisible(false);
                dexUpBtn.setVisible(false);
                knoUpBtn.setVisible(false);
                wisUpBtn.setVisible(false);
                statUpLbl.setVisible(false);
            }
            UpdateSpieler();
            System.out.println(skillpunkte);
        });
        wisUpBtn.addActionListener(e -> {
            skillpunkte -= 1;
            spieler.setWis(spieler.getWis()+1);
            spieler.setMaxHp(spieler.getMaxHp()+2);
            spieler.setHp(spieler.getHp()+2);
            spieler.setMaxSp(spieler.getMaxSp()+2);
            spieler.setSp(spieler.getSp()+2);
            spieler.setAtk(spieler.getAtk()+1);
            spieler.setDef(spieler.getDef()+3);
            statUpLbl.setText("(" + skillpunkte + ") Skillpunkte verfügbar!");
            if (skillpunkte <= 0){
                strUpBtn.setVisible(false);
                dexUpBtn.setVisible(false);
                knoUpBtn.setVisible(false);
                wisUpBtn.setVisible(false);
                statUpLbl.setVisible(false);
            }
            UpdateSpieler();
            System.out.println(skillpunkte);
        });
    }
    //endregion
    //region skill button
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
        Skill1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kampf(x.getMod(),x.getKraft(),x.getGenauigkeit());
            }
        };
        skillBtn1.addActionListener(Skill1);

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
        Skill2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kampf(x.getMod(),x.getKraft(),x.getGenauigkeit());
            }
        };
        skillBtn2.addActionListener(Skill2);
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
        Skill3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kampf(x.getMod(),x.getKraft(),x.getGenauigkeit());
            }
        };
        skillBtn3.addActionListener(Skill3);

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
        Skill4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kampf(x.getMod(),x.getKraft(),x.getGenauigkeit());
            }
        };
        skillBtn4.addActionListener(Skill4);

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
        Skill5 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kampf(x.getMod(),x.getKraft(),x.getGenauigkeit());
            }
        };
        skillBtn5.addActionListener(Skill5);
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
