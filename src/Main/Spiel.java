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
import java.util.ArrayList;
import java.util.Random;

import static Charaktere.Gegner.*;
import static Main.SpielPanel.*;
import static Navigation.Navigation.*;
import static Skills.Skills.*;


public class Spiel {
    static SpielFrame spielFrame;
    static SpielPanel spielPanel;
    static Eingabe eingabe;
    static Spieler spieler;
    static Gegner gegner;
    static boolean kampf;
    static ActionListener Skill1,Skill2,Skill3,Skill4,Skill5,Navi1,Navi2,Navi3,Navi4,Navi5,Navi6;

    static ArrayList<Gegner> gegnerListeT1 = new ArrayList<>();
    static ArrayList<Gegner> gegnerListeT2 = new ArrayList<>();
    static ArrayList<Navigation> naviListe = new ArrayList<>();
    static ArrayList<Gegner> bossListe = new ArrayList<>();
    static int expNeed = 50;
    static int skillpunkte = 0;
    static int raumCounter = 0;
    static int ebeneCounter = 1;
    static int kampfRunde = 0;

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
        gegnerListeT1.add(fledermaus);
        gegnerListeT1.add(hornisse);
        gegnerListeT1.add(ratte);
        gegnerListeT1.add(schlange);
        gegnerListeT1.add(skorpion);
        gegnerListeT1.add(zombie);
        gegnerListeT2.add(minotaurus);
        gegnerListeT2.add(oger);
        gegnerListeT2.add(werwolf);
        bossListe.add(behemoth);
        bossListe.add(daemon);
        bossListe.add(drache);
        bossListe.add(dunklerLord);
    }
    public static void NaviInitialisieren() {
        naviListe.removeAll(naviListe);
        if (raumCounter < 10) {
            for (int i = 0; i < 35; i++) {
                naviListe.add(naviKampf);
            }
            for (int i = 0; i < 25; i++) {
                naviListe.add(naviLager);
            }
            for (int i = 0; i < 10; i++) {
                naviListe.add(naviLaden);
            }
            for (int i = 0; i < 10; i++) {
                naviListe.add(naviSchatz);
            }
            for (int i = 0; i < 10; i++) {
                naviListe.add(naviEvent);
            }
            for (int i = 0; i < 10; i++) {
                naviListe.add(naviBoss);
            }
        }
        if ((raumCounter >= 10) & (raumCounter < 25)){
            for (int i = 0; i < 25; i++) {
                naviListe.add(naviKampf);
            }
            for (int i = 0; i < 20; i++) {
                naviListe.add(naviLager);
            }
            for (int i = 0; i < 10; i++) {
                naviListe.add(naviLaden);
            }
            for (int i = 0; i < 10; i++) {
                naviListe.add(naviSchatz);
            }
            for (int i = 0; i < 15; i++) {
                naviListe.add(naviEvent);
            }
            for (int i = 0; i < 15; i++) {
                naviListe.add(naviBoss);
            }
        }
        if (raumCounter >= 25) {
            for (int i = 0; i < 15; i++) {
                naviListe.add(naviKampf);
            }
            for (int i = 0; i < 20; i++) {
                naviListe.add(naviLager);
            }
            for (int i = 0; i < 10; i++) {
                naviListe.add(naviLaden);
            }
            for (int i = 0; i < 10; i++) {
                naviListe.add(naviSchatz);
            }
            for (int i = 0; i < 15; i++) {
                naviListe.add(naviEvent);
            }
            for (int i = 0; i < 30; i++) {
                naviListe.add(naviBoss);
            }
        }
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
        JButton schneemannEncBtn = new JButton("Schneemann Encounter");
        JButton lvlUpBtn = new JButton("Level up");
        JButton t2EncBtn = new JButton("T2 Encounter");
        JButton bossEncBtn = new JButton("Boss Encounter");
        JButton schatzRaum = new JButton("Schatzraum");
        JButton ladenRaum = new JButton("Ladenraum");


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
        schneemannEncBtn.addActionListener(e -> {
            gegnerListeT1.removeAll(gegnerListeT1);
            gegnerListeT1.add(schneemann);
            NavigationKampf();
            GegnerInitialisieren();
        });
        lvlUpBtn.addActionListener(e -> {
            spieler.setExp(expNeed);
            CheckLevelUp();
        });
        t2EncBtn.addActionListener(e -> {
            Random rnd = new Random();
            int i = rnd.nextInt(gegnerListeT2.size());
            Encounter(gegnerListeT2.get(i),ebeneCounter);
        });
        bossEncBtn.addActionListener(e -> {
            NavigationBoss();
        });
        schatzRaum.addActionListener(e -> {
            NavigationSchatz();
        });
        ladenRaum.addActionListener(e -> {
            NavigationLaden();
        });


        adminPanel.add(hpDownBtn);
        adminPanel.add(hpUpBtn);
        adminPanel.add(spDownBtn);
        adminPanel.add(spUpBtn);
        adminPanel.add(schneemannEncBtn);
        adminPanel.add(lvlUpBtn);
        adminPanel.add(t2EncBtn);
        adminPanel.add(bossEncBtn);
        adminPanel.add(schatzRaum);
        adminPanel.add(ladenRaum);

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
        if (spieler.getHp() <= 0) spieler.setHp(0);
        if (spieler.getSp() > spieler.getMaxSp()) spieler.setSp(spieler.getMaxSp());
        if (spieler.getSp() <= 0) spieler.setSp(0);

        spielerNameLbl.setText(spieler.getName() + " Lvl " + spieler.getLvl());
        spielerHp.setText(spieler.getHp() + "/" + spieler.getMaxHp());
        spielerHpBar.setMaximum(spieler.getMaxHp());
        spielerHpBar.setValue(spieler.getHp());
        spielerSp.setText(spieler.getSp() + "/" + spieler.getMaxSp());
        spielerSpBar.setMaximum(spieler.getMaxSp());
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
        Random rnd = new Random();
        double range1, range2;

        naviPanel.setVisible(false);
        gegner.setName(x.getName());
        gegner.setMaxHp(x.getMaxHp()+(10*lvl));
        gegner.setHp(gegner.getMaxHp());
        gegner.setMaxSp(x.getMaxSp()+(10*lvl));
        gegner.setSp(gegner.getMaxSp());
        gegner.setStr(x.getStr()+(1*lvl));
        gegner.setDex(x.getDex()+(1*lvl));
        gegner.setKno(x.getKno()+(1*lvl));
        gegner.setWis(x.getWis()+(1*lvl));
        gegner.setMod(x.getMod());
        gegner.setAtk(x.getAtk()+(1*lvl));
        gegner.setDef(x.getDef()+(1*lvl));
        gegner.setLvl(ebeneCounter);
        range1 = x.getGold()/1.5;
        range2 = x.getGold()*1.5;
        gegner.setGold(((int) rnd.nextDouble(range1,range2))+(2*lvl));
        range1 = x.getExp()/1.5;
        range2 = x.getExp()*1.5;
        gegner.setExp(((int) rnd.nextDouble(range1,range2))+(2*lvl));
        gegnerBildLbl.setIcon(x.getBild());
        gegnerNameLbl.setText(x.getName() + " Lvl " + lvl);
        gegnerHpBar.setMaximum(gegner.getMaxHp());
        gegnerHpBar.setValue(gegner.getHp());
        KampfBeginn();
    }
    public static void KampfBeginn() {
        kampf = true;
        EnableSkillButtons();
        SpielPanel.gegnerPanel.setVisible(true);
        kampfRunde = 0;
    }
    public static void KampfEnde() {
        Timer timer = new Timer(1500, e -> {
            kampf = false;
            DisableSkillButtons();
            gegnerPanel.setVisible(false);
            naviPanel.setVisible(true);
        });
        timer.setRepeats(false);
        timer.start();
    }
    public static void DisableSkillButtons() {
        skillBtn1.setEnabled(false);
        skillBtn2.setEnabled(false);
        skillBtn3.setEnabled(false);
        skillBtn4.setEnabled(false);
        skillBtn5.setEnabled(false);
    }
    public static void EnableSkillButtons() {
        skillBtn1.setEnabled(true);
        skillBtn2.setEnabled(true);
        skillBtn3.setEnabled(true);
        skillBtn4.setEnabled(true);
        skillBtn5.setEnabled(true);

        if ((skill1.getHpKosten() > spieler.getHp()) | (skill1.getSpKosten() > spieler.getSp())) {
            skillBtn1.setEnabled(false);
        }
        if ((skill2.getHpKosten() > spieler.getHp()) | (skill2.getSpKosten() > spieler.getSp())) {
            skillBtn2.setEnabled(false);
        }
        if ((skill3.getHpKosten() > spieler.getHp()) | (skill3.getSpKosten() > spieler.getSp())) {
            skillBtn3.setEnabled(false);
        }
        if ((skill4.getHpKosten() > spieler.getHp()) | (skill4.getSpKosten() > spieler.getSp())) {
            skillBtn4.setEnabled(false);
        }
        if ((skill5.getHpKosten() > spieler.getHp()) | (skill5.getSpKosten() > spieler.getSp())) {
            skillBtn5.setEnabled(false);
        }
    }
    public static void Kampf(String mod, int kraft, int genauigkeit, int anzahl) {
        DisableSkillButtons();
        kampfRunde++;
        System.out.println("Kampfrunde: " + kampfRunde);
        int treffer = (int) (Math.random()*100);
        System.out.println("Treffer: " + treffer);
        Timer timer = new Timer(100, e -> {
            if (spieler.amLeben() & gegner.amLeben()) {
                if ((treffer < genauigkeit) & (treffer > 0)) {
                    SpielerAngriff(mod, kraft, genauigkeit);
                    for(int i = 1; i < anzahl; i++) {
                        int treffer2 = (int) (Math.random()*100);
                        if ((treffer2 < genauigkeit) & (treffer2 > 0)) {
                            SpielerAngriff(mod, kraft, genauigkeit);
                        } else if (treffer2 == 0) {
                            SpielerAngriff(mod, kraft*2, genauigkeit);
                        } else if (treffer2 >= genauigkeit) {
                            textLog.append("\n Der Angriff verfehlt...");
                        }
                    }
                    Timer timer2 = new Timer(700, e1 -> {
                        if (gegner.amLeben() & spieler.amLeben()) {
                            GegnerAngriff(gegner.getMod(),kraft,genauigkeit);
                            Timer timer3 = new Timer(700, e2 -> {
                                if (!spieler.amLeben()) {
                                    KampfEnde();
                                    spielPanel.setGameOverScreen();
                                }
                                if (!gegner.amLeben()) {
                                    KampfGewonnen();
                                }
                                if (spieler.amLeben() & (gegner.amLeben())) {
                                    EnableSkillButtons();
                                }
                            });
                            timer3.setRepeats(false);
                            timer3.start();
                        } else if (!gegner.amLeben()) {
                            KampfGewonnen();
                        } else if (!spieler.amLeben()) {
                            KampfEnde();
                            spielPanel.setGameOverScreen();
                        }
                    });
                    timer2.setRepeats(false);
                    timer2.start();
                } else if (treffer >= genauigkeit) {
                    textLog.append("\n Der Angriff verfehlt...");
                    for(int i = 1; i < anzahl; i++) {
                        int treffer2 = (int) (Math.random()*100);
                        if ((treffer2 < genauigkeit) & (treffer2 > 0)) {
                            SpielerAngriff(mod, kraft, genauigkeit);
                        } else if (treffer2 == 0) {
                            SpielerAngriff(mod, kraft*2, genauigkeit);
                        } else if (treffer2 >= genauigkeit) {
                            textLog.append("\n Der Angriff verfehlt...");
                        }
                    }
                    Timer timer2 = new Timer(700, e1 -> {
                        if (gegner.amLeben() & spieler.amLeben()) {
                            GegnerAngriff(gegner.getMod(), kraft, genauigkeit);
                            Timer timer3 = new Timer(700, e2 -> {
                                if (!spieler.amLeben()) {
                                    KampfEnde();
                                    spielPanel.setGameOverScreen();
                                }
                                if (!gegner.amLeben()) {
                                    KampfGewonnen();
                                }
                                if (spieler.amLeben() & (gegner.amLeben())) {
                                    EnableSkillButtons();
                                }
                            });
                            timer3.setRepeats(false);
                            timer3.start();
                        } else if (!gegner.amLeben()) {
                            KampfGewonnen();
                        } else if (!spieler.amLeben()) {
                            KampfEnde();
                            spielPanel.setGameOverScreen();
                        }
                    });
                    timer2.setRepeats(false);
                    timer2.start();
                } else if (treffer == 0) {
                    textLog.append("\n Kritischer Treffer!");
                    SpielerAngriff(mod, kraft*2, genauigkeit);
                    for(int i = 1; i < anzahl; i++) {
                        int treffer2 = (int) (Math.random()*100);
                        if ((treffer2 < genauigkeit) & (treffer2 > 0)) {
                            SpielerAngriff(mod, kraft, genauigkeit);
                        } else if (treffer2 == 0) {
                            SpielerAngriff(mod, kraft*2, genauigkeit);
                        } else if (treffer2 >= genauigkeit) {
                            textLog.append("\n Der Angriff verfehlt...");
                        }
                    }
                    Timer timer2 = new Timer(700, e1 -> {
                        if (gegner.amLeben() & spieler.amLeben()) {
                            GegnerAngriff(gegner.getMod(),kraft,genauigkeit);
                            Timer timer3 = new Timer(700, e2 -> {
                                if (!spieler.amLeben()) {
                                    KampfEnde();
                                    spielPanel.setGameOverScreen();
                                }
                                if (!gegner.amLeben()) {
                                    KampfGewonnen();
                                }
                                if (spieler.amLeben() & (gegner.amLeben())) {
                                    EnableSkillButtons();
                                }
                            });
                            timer3.setRepeats(false);
                            timer3.start();
                        } else if (!gegner.amLeben()) {
                            KampfGewonnen();
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
        textLog.append("\n Du verursachst " + spielerAngriff + " Schaden!");
    }
    public static void GegnerAngriff(String mod, int kraft, int genauigkeit) {
        int spielerVerteidigung = spieler.verteidigung(gegner.getMod());
        int gegnerAngriff = gegner.angriff(gegner.getMod(), 100) - spielerVerteidigung;
        if (gegnerAngriff <= 0) gegnerAngriff = 0;
        spieler.setHp(spieler.getHp() - gegnerAngriff);
        spielerHp.setText(spieler.getHp() + "/" + spieler.getMaxHp());
        spielerHpBar.setValue(spieler.getHp());
        textLog.append("\n " + gegner.getName() + " verursacht " + gegnerAngriff + " Schaden!");
    }
    public static void KampfGewonnen() {
        UpdateExp(gegner.getExp());
        UpdateGold(gegner.getGold());
        KampfEnde();
        textLog.append("\n Kampf gewonnen!");
        textLog.append("\n " + gegner.getExp() + " Erfahrungspunkte erhalten.");
        textLog.append("\n " + gegner.getGold() + " Gold erhalten.");
    }
    //endregion
    //region exp/lvl
    public static void UpdateGold(int x) {
        spieler.setGold(spieler.getGold() + x);
        spielerGold.setText("" + spieler.getGold());
    }
    public static void UpdateExp(int x) {
        spieler.setExp(spieler.getExp() + x);
        spielerExp.setText("" + spieler.getExp());
        spielerExpBar.setValue(spieler.getExp());
        CheckLevelUp();
    }
    public static void CheckLevelUp() {
        //lvl up
        if ((spieler.getExp()) >= (expNeed)) {
            spielerExpBar.setMinimum(expNeed);
            spieler.setLvl(spieler.getLvl()+1);
            expNeed = (int) ((5000/11)*((Math.pow(1.11,(spieler.getLvl())))-1));
            spielerExpBar.setMaximum(expNeed);
            SkillPunkte();
            textLog.append("\n Level Up!");
            spieler.setHp(spieler.getMaxHp());
            spieler.setSp(spieler.getMaxSp());
            UpdateSpieler();
        }
    }
    //endregion
    //region navigation
    public static void setNavi() {
        Random rnd = new Random();
        int a = rnd.nextInt(naviListe.size());
        int b = rnd.nextInt(naviListe.size());
        int c = rnd.nextInt(naviListe.size());
        int d = rnd.nextInt(naviListe.size());
        int e = rnd.nextInt(naviListe.size());
        int f = rnd.nextInt(naviListe.size());

        Navi1Button(naviListe.get(a), naviListe.get(c), naviListe.get(d));
        Navi2Button(naviListe.get(b), naviListe.get(e), naviListe.get(f));
        Navi3Button(naviListe.get(c));
        Navi4Button(naviListe.get(d));
        Navi5Button(naviListe.get(e));
        Navi6Button(naviListe.get(f));

        navi3Btn.setEnabled(false);
        navi4Btn.setEnabled(false);
        navi5Btn.setEnabled(false);
        navi6Btn.setEnabled(false);

//        navi2Btn.setIcon(naviListe[b].getBild());
//        navi3Btn.setIcon(naviListe[c].getBild());
//        navi4Btn.setIcon(naviListe[d].getBild());
//        navi5Btn.setIcon(naviListe[e].getBild());
//        navi6Btn.setIcon(naviListe[f].getBild());
    }
    public static void Navi1Button(Navigation x, Navigation y, Navigation z) {
        navi1Btn.setIcon(x.getBild());
        Navi1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rnd = new Random();
                raumCounter++;
                System.out.println("RaumCounter: " + raumCounter);
                NaviInitialisieren();
                int a = rnd.nextInt(naviListe.size());
                int b = rnd.nextInt(naviListe.size());
                int c = rnd.nextInt(naviListe.size());
                int d = rnd.nextInt(naviListe.size());

                switch (x.getName()) {
                    case "Kampf" ->
                        NavigationKampf();
                    case "Lager" ->
                        NavigationLager();
                    case "Event" ->
                        NavigationEvent();
                    case "Schatz" ->
                        NavigationSchatz();
                    case "Laden" ->
                        NavigationLaden();
                    case "Boss" ->
                        NavigationBoss();
                }
                navi1Btn.removeActionListener(Navi1);
                navi1Btn.setIcon(y.getBild());
                navi2Btn.removeActionListener(Navi2);
                navi2Btn.setIcon(z.getBild());
                navi3Btn.setIcon(naviListe.get(a).getBild());
                navi4Btn.setIcon(naviListe.get(b).getBild());
                navi5Btn.setIcon(naviListe.get(c).getBild());
                navi6Btn.setIcon(naviListe.get(d).getBild());
                Navi1Button(y, naviListe.get(a), naviListe.get(b));
                Navi2Button(z, naviListe.get(c), naviListe.get(d));
            }
        };
        navi1Btn.addActionListener(Navi1);
        navi1Btn.addMouseListener(new MouseListener() {
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
                NaviInfoUpdate(x.getName());
                naviInfoPanel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                naviInfoLbl.setText("");
                naviInfoPanel.setVisible(false);
            }
        });
    }
    public static void Navi2Button(Navigation x, Navigation y, Navigation z) {
        navi2Btn.setIcon(x.getBild());
        Navi2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rnd = new Random();
                raumCounter++;
                System.out.println("RaumCounter: " + raumCounter);
                NaviInitialisieren();
                int a = rnd.nextInt(naviListe.size());
                int b = rnd.nextInt(naviListe.size());
                int c = rnd.nextInt(naviListe.size());
                int d = rnd.nextInt(naviListe.size());

                switch (x.getName()) {
                    case "Kampf" ->
                        NavigationKampf();
                    case "Lager" ->
                        NavigationLager();
                    case "Event" ->
                        NavigationEvent();
                    case "Schatz" ->
                        NavigationSchatz();
                    case "Laden" ->
                        NavigationLaden();
                    case "Boss" ->
                        NavigationBoss();
                }
                navi2Btn.removeActionListener(Navi2);
                navi2Btn.setIcon(z.getBild());
                navi1Btn.removeActionListener(Navi1);
                navi1Btn.setIcon(y.getBild());
                navi3Btn.setIcon(naviListe.get(a).getBild());
                navi4Btn.setIcon(naviListe.get(b).getBild());
                navi5Btn.setIcon(naviListe.get(c).getBild());
                navi6Btn.setIcon(naviListe.get(d).getBild());
                Navi2Button(z, naviListe.get(c), naviListe.get(d));
                Navi1Button(y, naviListe.get(a), naviListe.get(b));
            }
        };
        navi2Btn.addActionListener(Navi2);
        navi2Btn.addMouseListener(new MouseListener() {
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
                NaviInfoUpdate(x.getName());
                naviInfoPanel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                naviInfoLbl.setText("");
                naviInfoPanel.setVisible(false);
            }
        });
    }
    public static void Navi3Button(Navigation x) {
        navi3Btn.setIcon(x.getBild());
        navi3Btn.addMouseListener(new MouseListener() {
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
                NaviInfoUpdate(x.getName());
                naviInfoPanel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                naviInfoLbl.setText("");
                naviInfoPanel.setVisible(false);
            }
        });
    }
    public static void Navi4Button(Navigation x) {
        navi4Btn.setIcon(x.getBild());
        navi4Btn.addMouseListener(new MouseListener() {
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
                NaviInfoUpdate(x.getName());
                naviInfoPanel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                naviInfoLbl.setText("");
                naviInfoPanel.setVisible(false);
            }
        });
    }
    public static void Navi5Button(Navigation x) {
        navi5Btn.setIcon(x.getBild());
        navi5Btn.addMouseListener(new MouseListener() {
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
                NaviInfoUpdate(x.getName());
                naviInfoPanel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                naviInfoLbl.setText("");
                naviInfoPanel.setVisible(false);
            }
        });
    }
    public static void Navi6Button(Navigation x) {
        navi6Btn.setIcon(x.getBild());
        navi6Btn.addMouseListener(new MouseListener() {
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
                NaviInfoUpdate(x.getName());
                naviInfoPanel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                naviInfoLbl.setText("");
                naviInfoPanel.setVisible(false);
            }
        });
    }
    public static void NavigationKampf() {
        Random rnd = new Random();
        int i = rnd.nextInt(gegnerListeT1.size());
        Encounter(gegnerListeT1.get(i),ebeneCounter);
        textLog.append("\n " + gegner.getName() + " ist erschienen!");
    }
    public static void NavigationLager() {
        lagerPanel.setVisible(true);
        naviPanel.setVisible(false);
        spieler.setHp(spieler.getMaxHp());
        spieler.setSp(spieler.getMaxSp());
        UpdateSpieler();
        textLog.append("\n Du erholst dich am Lagerfeuer.");
        Timer timer = new Timer(2000, e -> {
            lagerPanel.setVisible(false);
            naviPanel.setVisible(true);
            textLog.append("\n HP und SP wurden wiederhergestellt!");
        });
        timer.setRepeats(false);
        timer.start();
    }
    public static void NavigationEvent() {
    }
    public static void NavigationSchatz() {
        schatzPanel.setVisible(true);
        naviPanel.setVisible(false);
        spieler.setHp(spieler.getMaxHp());
        spieler.setSp(spieler.getMaxSp());
        UpdateSpieler();
        textLog.append("\n Du hast eine Truhe gefunden!");
    }
    public static void SchatzEncounter() {
        Random rnd = new Random();
        int chance = (int) (Math.random()*100);
        int gold = rnd.nextInt(50,300);

        if (chance <= 40) {
            textLog.append("\n Du hast " + gold + " Gold gefunden!");
            schatzBildLbl.setIcon(new ImageIcon("src/res/NaviBilder/SchatzGold.png"));
            UpdateGold(gold);
            schatzAuf.setVisible(false);
            schatzIgno.setVisible(false);
            Timer timer = new Timer(2000, e -> {
                schatzAuf.setVisible(true);
                schatzIgno.setVisible(true);
                schatzPanel.setVisible(false);
                naviPanel.setVisible(true);
                schatzBildLbl.setIcon(new ImageIcon("src/res/NaviBilder/Schatz.png"));
            });
            timer.setRepeats(false);
            timer.start();
        } else {
            textLog.append("\n Die Truhe war eine Falle!");
            schatzBildLbl.setIcon(mimic.getBild());
            schatzAuf.setVisible(false);
            schatzIgno.setVisible(false);
            Timer timer = new Timer(2000, e -> {
                gegnerListeT1.removeAll(gegnerListeT1);
                gegnerListeT1.add(mimic);
                NavigationKampf();
                GegnerInitialisieren();
                schatzAuf.setVisible(true);
                schatzIgno.setVisible(true);
                schatzPanel.setVisible(false);
                naviPanel.setVisible(true);
                gegnerListeT1.remove(mimic);
                schatzBildLbl.setIcon(new ImageIcon("src/res/NaviBilder/Schatz.png"));
            });
            timer.setRepeats(false);
            timer.start();
        }
    }
    public static void NavigationLaden() {
        ladenPanel.setVisible(true);
        naviPanel.setVisible(false);
        textLog.append("\n Du hast einen Laden gefunden");
        Timer timer = new Timer(2000, e -> {
            lagerPanel.setVisible(false);
            naviPanel.setVisible(true);
        });
        timer.setRepeats(false);
        timer.start();
    }
    public static void NavigationBoss() {
        Random rnd = new Random();
        int i = rnd.nextInt(bossListe.size());
        Encounter(bossListe.get(i),ebeneCounter);
        textLog.append("\n " + gegner.getName() + " ist erschienen!");
        ebeneCounter++;
        raumCounter = 0;
        naviEbeneLbl.setText("Ebene " + ebeneCounter);
    }
    public static void NaviInfoUpdate(String name) {
        naviInfoLbl.setText("Raum: " + name);
    }
    //endregion
    //region Skillpoints
    public static void SkillPunkte() {
        skillpunkte += 2;
        strUpBtn.setVisible(true);
        dexUpBtn.setVisible(true);
        knoUpBtn.setVisible(true);
        wisUpBtn.setVisible(true);
        statUpLbl.setVisible(true);
        statUpLbl.setText("(" + skillpunkte + ") Skillpunkte verfügbar!");
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
        });
    }
    //endregion
    //region character
    public static void setCharBtn() {
        EquipButton();
        SkillungButton();
        ZauberbuchButton();
    }
    public static void EquipButton() {
        equipBtn.addMouseListener(new MouseListener() {
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
                CharInfoUpdate("Ausrüstung");
                charInfoPanel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                charInfoLbl.setText("");
                charInfoPanel.setVisible(false);
            }
        });
        equipBtn.addActionListener(e -> {
            if (!equipPanel.isVisible()) {
                equipPanel.setVisible(true);
                buchPanel.setVisible(false);
                treePanel.setVisible(false);
            } else {
                equipPanel.setVisible(false);
            }
        });
    }
    public static void SkillungButton() {
        treeBtn.addMouseListener(new MouseListener() {
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
                CharInfoUpdate("Skillung");
                charInfoPanel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                charInfoLbl.setText("");
                charInfoPanel.setVisible(false);
            }
        });
        treeBtn.addActionListener(e -> {
            if (!treePanel.isVisible()) {
                treePanel.setVisible(true);
                buchPanel.setVisible(false);
                equipPanel.setVisible(false);
            } else {
                treePanel.setVisible(false);
            }
        });
    }
    public static void ZauberbuchButton() {
        zauberbuchBtn.addMouseListener(new MouseListener() {
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
                CharInfoUpdate("Fähigkeiten");
                charInfoPanel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                charInfoLbl.setText("");
                charInfoPanel.setVisible(false);
            }
        });
        zauberbuchBtn.addActionListener(e -> {
            if (!buchPanel.isVisible()) {
                buchPanel.setVisible(true);
                treePanel.setVisible(false);
                equipPanel.setVisible(false);
            } else {
                buchPanel.setVisible(false);
            }
        });
    }

    public static void CharInfoUpdate(String name) {
        charInfoLbl.setText(name);
    }
    //endregion
    //region skill button
    public static void setSkills() {
        switch (spieler.getName()) {
            case "Krieger":
                Skill1Aenderung(skillAngriff);
                Skill2Aenderung(skillAnsturm);
                Skill3Aenderung(skillDoppelschlag);
                Skill4Aenderung(skillStampfer);
                Skill5Aenderung(skillSchlaghagel);
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
                SkillLblInfoUpdate(x.getName(), x.getKraft(), x.getGenauigkeit(), x.getMod(),x.getHpKosten(), x.getSpKosten(),x.getAnzahl());
                skillInfoPanel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                skillLblName.setText("");
                skillLblKraft.setText("");
                skillLblGenauigkeit.setText("");
                skillLblKosten.setText("");
                skillInfoPanel.setVisible(false);

            }
        });
        Skill1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kampf(x.getMod(),x.getKraft(),x.getGenauigkeit(),x.getAnzahl());
                spieler.setHp(spieler.getHp() - x.getHpKosten());
                spieler.setSp(spieler.getSp() - x.getSpKosten());
                UpdateSpieler();
            }
        };
        skillBtn1.addActionListener(Skill1);
        skill1 = x;
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
                SkillLblInfoUpdate(x.getName(), x.getKraft(), x.getGenauigkeit(), x.getMod(),x.getHpKosten(), x.getSpKosten(),x.getAnzahl());
                skillInfoPanel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                skillLblName.setText("");
                skillLblKraft.setText("");
                skillLblGenauigkeit.setText("");
                skillLblKosten.setText("");
                skillInfoPanel.setVisible(false);
            }
        });
        Skill2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kampf(x.getMod(),x.getKraft(),x.getGenauigkeit(),x.getAnzahl());
                spieler.setHp(spieler.getHp() - x.getHpKosten());
                spieler.setSp(spieler.getSp() - x.getSpKosten());
                UpdateSpieler();
            }
        };
        skillBtn2.addActionListener(Skill2);
        skill2 = x;
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
                SkillLblInfoUpdate(x.getName(), x.getKraft(), x.getGenauigkeit(), x.getMod(),x.getHpKosten(), x.getSpKosten(),x.getAnzahl());
                skillInfoPanel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                skillLblName.setText("");
                skillLblKraft.setText("");
                skillLblGenauigkeit.setText("");
                skillLblKosten.setText("");
                skillInfoPanel.setVisible(false);
            }
        });
        Skill3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kampf(x.getMod(),x.getKraft(),x.getGenauigkeit(),x.getAnzahl());
                spieler.setHp(spieler.getHp() - x.getHpKosten());
                spieler.setSp(spieler.getSp() - x.getSpKosten());
                UpdateSpieler();
            }
        };
        skillBtn3.addActionListener(Skill3);
        skill3 = x;

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
                SkillLblInfoUpdate(x.getName(), x.getKraft(), x.getGenauigkeit(), x.getMod(),x.getHpKosten(), x.getSpKosten(),x.getAnzahl());
                skillInfoPanel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                skillLblName.setText("");
                skillLblKraft.setText("");
                skillLblGenauigkeit.setText("");
                skillLblKosten.setText("");
                skillInfoPanel.setVisible(false);
            }
        });
        Skill4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kampf(x.getMod(),x.getKraft(),x.getGenauigkeit(),x.getAnzahl());
                spieler.setHp(spieler.getHp() - x.getHpKosten());
                spieler.setSp(spieler.getSp() - x.getSpKosten());
                UpdateSpieler();
            }
        };
        skillBtn4.addActionListener(Skill4);
        skill4 = x;

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
                SkillLblInfoUpdate(x.getName(), x.getKraft(), x.getGenauigkeit(), x.getMod(),x.getHpKosten(), x.getSpKosten(),x.getAnzahl());
                skillInfoPanel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                skillLblName.setText("");
                skillLblKraft.setText("");
                skillLblGenauigkeit.setText("");
                skillLblKosten.setText("");
                skillInfoPanel.setVisible(false);
            }
        });
        Skill5 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kampf(x.getMod(),x.getKraft(),x.getGenauigkeit(),x.getAnzahl());
                spieler.setHp(spieler.getHp() - x.getHpKosten());
                spieler.setSp(spieler.getSp() - x.getSpKosten());
                UpdateSpieler();
            }
        };
        skillBtn5.addActionListener(Skill5);
        skill5 = x;
    }
    public static void SkillLblInfoUpdate(String name, int kraft, int genauigkeit, String mod,
                                          int hpKosten, int spKosten, int anzahl) {
        skillLblName.setText(name);
        skillLblGenauigkeit.setText(genauigkeit + "%");

        if (anzahl == 1) {
            switch (mod) {
                case "str" -> skillLblKraft.setText("<html>Kraft: <font color='#ff0000'>" + kraft);
                case "dex" -> skillLblKraft.setText("<html>Kraft: <font color='#3cb371'>" + kraft);
                case "kno" -> skillLblKraft.setText("<html>Kraft: <font color='#94d0ff'>" + kraft);
                case "wis" -> skillLblKraft.setText("<html>Kraft: <font color='#ffe400'>" + kraft);
            }
        } else if (anzahl == 2) {
            switch (mod) {
                case "str" -> skillLblKraft.setText("<html>Kraft: <font color='#ff0000'>" + kraft + "</font>/<font color='#ff0000'>" + kraft);
                case "dex" -> skillLblKraft.setText("<html>Kraft: <font color='#3cb371'>" + kraft + "</font>/<font color='#3cb371'>" + kraft);
                case "kno" -> skillLblKraft.setText("<html>Kraft: <font color='#94d0ff'>" + kraft + "</font>/<font color='#94d0ff'>" + kraft);
                case "wis" -> skillLblKraft.setText("<html>Kraft: <font color='#ffe400'>" + kraft + "</font>/<font color='#ffe400'>" + kraft);
            }
        }else if (anzahl == 3) {
            switch (mod) {
                case "str" -> skillLblKraft.setText("<html>Kraft: <font color='#ff0000'>" + kraft + "</font>/<font color='#ff0000'>" + kraft + "</font>/<font color='#ff0000'>" + kraft);
                case "dex" -> skillLblKraft.setText("<html>Kraft: <font color='#3cb371'>" + kraft + "</font>/<font color='#3cb371'>" + kraft + "</font>/<font color='#3cb371'>" + kraft);
                case "kno" -> skillLblKraft.setText("<html>Kraft: <font color='#94d0ff'>" + kraft + "</font>/<font color='#94d0ff'>" + kraft + "</font>/<font color='#94d0ff'>" + kraft);
                case "wis" -> skillLblKraft.setText("<html>Kraft: <font color='#ffe400'>" + kraft + "</font>/<font color='#ffe400'>" + kraft + "</font>/<font color='#ffe400'>" + kraft);
            }
        }
        //<html><font color='#C70039'> HP
        //<html><font color='#234ba1'> SP

        if (hpKosten > 0) {
            skillLblKosten.setText("<html><font color='#C70039'>" + hpKosten);
        }
        if (spKosten > 0) {
            skillLblKosten.setText("<html><font color='#234ba1'>" + spKosten);
        }
        if ((spKosten > 0) & (hpKosten > 0)) {
            skillLblKosten.setText("<html><font color='#C70039'>" + hpKosten + "</font>/<font color='#234ba1'>" + spKosten);
        }


        
    }
    //endregion
}
