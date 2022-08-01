package Main;

import javax.swing.*;
import java.awt.*;

import static Charaktere.Spieler.*;
import static Main.Spiel.*;

public class SpielPanel extends JPanel {
    Image hintergrundBild;
    public static JPanel gamePanel,statPanel,btnPanel,textPanel,skillInfoPanel,gegnerPanel,naviPanel,
            naviInfoPanel,lagerPanel, schatzPanel,ladenPanel,characterPanel, charInfoPanel, equipPanel,
            treePanel, buchPanel;
    public static JButton skillBtn1, skillBtn2, skillBtn3, skillBtn4, skillBtn5, strUpBtn, dexUpBtn, knoUpBtn, wisUpBtn,
            navi1Btn,navi2Btn,navi3Btn,navi4Btn,navi5Btn,navi6Btn, schatzAuf, schatzIgno,
            zauberbuchBtn, testBtn2, equipBtn, treeBtn;
    public static JLabel skillLblName, skillLblKraft, skillLblGenauigkeit, spielerNameLbl, spielerHp,skillLblKosten,
            spielerSp, spielerExp, spielerGold, spielerStr, spielerDex, spielerKno, spielerWis, gegnerBildLbl, gegnerNameLbl,
            spielerAtk, spielerDef,statUpLbl,naviTitelLbl,naviEbeneLbl,naviInfoLbl, schatzBildLbl, charInfoLbl;
    private static JLabel vorschauklasseLbl,vorschauhpLbl,vorschauspLbl,vorschaustrLbl,vorschaudexLbl,
            vorschauknoLbl,vorschauwisLbl,vorschauatkLbl,vorschaudefLbl;
    public static JProgressBar spielerHpBar, spielerSpBar, spielerExpBar, gegnerHpBar;
    public static ImageIcon gegnerBild;
    public static JTextArea textLog;

    public SpielPanel() {
        setFocusable(true);
        setTitelScreen();
    }
    public void setTitelScreen() {
        SpringLayout layout = new SpringLayout();
        setLayout(layout);
        setPreferredSize(new Dimension(800,600));
        ImageIcon icon = new ImageIcon("src/res/Hintergrund/Titel.jpg");
        hintergrundBild = icon.getImage();
        JLabel titelLbl = new JLabel("Crawler");
        titelLbl.setFont(new Font("Times New Roman", Font.BOLD, 90));
        titelLbl.setForeground(Color.WHITE);
        add(titelLbl);

        JButton titelStartBtn = new JButton("Start");
        titelStartBtn.setForeground(Color.WHITE);
        titelStartBtn.setBackground(Color.BLACK);
        add(titelStartBtn);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,titelLbl,0,SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,titelStartBtn,0,SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER,titelLbl,100,SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER,titelStartBtn,-80,SpringLayout.SOUTH, this);

        titelStartBtn.addActionListener(e -> {
            setAuswahlScreen();
        });
    }
    public void setSpielScreen() {
        //region init
        ImageIcon icon = new ImageIcon("src/res/Hintergrund/SpielGUI.png");
        ImageIcon statUpBild = new ImageIcon("src/res/Icons/Plus.png");
        strUpBtn = new JButton(statUpBild);
        dexUpBtn = new JButton(statUpBild);
        knoUpBtn = new JButton(statUpBild);
        wisUpBtn = new JButton(statUpBild);
        hintergrundBild = icon.getImage();
        removeAll();
        repaint();
        Font statFont = new Font("Segoe UI", Font.BOLD, 15);
        Font textFont = new Font("Segoe UI", Font.BOLD, 12);

        SpringLayout layout = new SpringLayout();
        setLayout(layout);
        //endregion
        //region gamepanel
        //region init
        gamePanel = new JPanel();
        add(gamePanel);
        gamePanel.setPreferredSize(new Dimension(500,300));
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        gamePanel.setBackground(Color.BLACK);

        layout.putConstraint(SpringLayout.WEST,gamePanel,15, SpringLayout.WEST,this);
        layout.putConstraint(SpringLayout.NORTH,gamePanel,20, SpringLayout.NORTH,this);
        //endregion
        //region ausrüstung
        equipPanel = new JPanel();
        equipPanel.setPreferredSize(new Dimension(490,290));
        equipPanel.setBackground(Color.YELLOW);

        equipPanel.setVisible(false);
        gamePanel.add(equipPanel);
        //endregion
        //region skillung
        treePanel = new JPanel();
        treePanel.setPreferredSize(new Dimension(490,290));
        treePanel.setBackground(Color.BLUE);

        treePanel.setVisible(false);
        gamePanel.add(treePanel);
        //endregion
        //region fähigkeiten
        buchPanel = new JPanel();
        buchPanel.setPreferredSize(new Dimension(490,290));
        buchPanel.setBackground(Color.GREEN);

        buchPanel.setVisible(false);
        gamePanel.add(buchPanel);
        //endregion
        //region gegner
        gegnerPanel = new JPanel();
        SpringLayout layoutGegner = new SpringLayout();
        gegnerPanel.setLayout(layoutGegner);
        gegnerPanel.setPreferredSize(new Dimension(490,285));
        gegnerPanel.setBackground(Color.BLACK);
        gegnerBildLbl = new JLabel();
        gegnerNameLbl = new JLabel();
        gegnerHpBar = new JProgressBar();
        gegnerHpBar.setStringPainted(true);
        gegnerHpBar.setForeground(Color.decode("#C70039"));
        gegnerHpBar.setMaximum(50);

        layoutGegner.putConstraint(SpringLayout.HORIZONTAL_CENTER,gegnerBildLbl,0,SpringLayout.HORIZONTAL_CENTER,gegnerPanel);
        layoutGegner.putConstraint(SpringLayout.HORIZONTAL_CENTER,gegnerNameLbl,0,SpringLayout.HORIZONTAL_CENTER,gegnerHpBar);
        layoutGegner.putConstraint(SpringLayout.NORTH, gegnerNameLbl, 5, SpringLayout.SOUTH, gegnerHpBar);

        gegnerNameLbl.setFont(statFont);
        gegnerNameLbl.setForeground(Color.WHITE);
        gegnerBildLbl.setIcon(gegnerBild);

        gegnerPanel.add(gegnerBildLbl);
        gegnerPanel.add(gegnerNameLbl);
        gegnerPanel.add(gegnerHpBar);
        gegnerPanel.setVisible(false);
        gamePanel.add(gegnerPanel);
        //endregion
        //region navigation
        naviPanel = new JPanel();
        SpringLayout layoutNavi = new SpringLayout();
        naviPanel.setLayout(layoutNavi);
        naviPanel.setPreferredSize(new Dimension(490,285));
        naviPanel.setBackground(Color.BLACK);

        navi1Btn = new JButton();
        navi2Btn = new JButton();
        navi3Btn = new JButton();
        navi4Btn = new JButton();
        navi5Btn = new JButton();
        navi6Btn = new JButton();
        naviTitelLbl = new JLabel("Labyrinth");
        naviEbeneLbl = new JLabel("Ebene " + ebeneCounter);

        navi1Btn.setPreferredSize(new Dimension(24,24));
        navi2Btn.setPreferredSize(new Dimension(24,24));
        navi3Btn.setPreferredSize(new Dimension(24,24));
        navi4Btn.setPreferredSize(new Dimension(24,24));
        navi5Btn.setPreferredSize(new Dimension(24,24));
        navi6Btn.setPreferredSize(new Dimension(24,24));

        naviTitelLbl.setFont(new Font("Segoe UI", Font.BOLD, 32));
        naviTitelLbl.setForeground(Color.WHITE);
        naviEbeneLbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        naviEbeneLbl.setForeground(Color.WHITE);

        layoutNavi.putConstraint(SpringLayout.HORIZONTAL_CENTER,naviTitelLbl,0,SpringLayout.HORIZONTAL_CENTER,naviPanel);
        layoutNavi.putConstraint(SpringLayout.HORIZONTAL_CENTER,naviEbeneLbl,0,SpringLayout.HORIZONTAL_CENTER,naviPanel);

        layoutNavi.putConstraint(SpringLayout.EAST,navi1Btn,-50,SpringLayout.HORIZONTAL_CENTER,naviPanel);
        layoutNavi.putConstraint(SpringLayout.WEST,navi2Btn,50,SpringLayout.HORIZONTAL_CENTER,naviPanel);
        layoutNavi.putConstraint(SpringLayout.EAST,navi3Btn,-30,SpringLayout.HORIZONTAL_CENTER,navi1Btn);
        layoutNavi.putConstraint(SpringLayout.WEST,navi4Btn,30,SpringLayout.HORIZONTAL_CENTER,navi1Btn);
        layoutNavi.putConstraint(SpringLayout.EAST,navi5Btn,-30,SpringLayout.HORIZONTAL_CENTER,navi2Btn);
        layoutNavi.putConstraint(SpringLayout.WEST,navi6Btn,30,SpringLayout.HORIZONTAL_CENTER,navi2Btn);

        layoutNavi.putConstraint(SpringLayout.NORTH,naviEbeneLbl,10,SpringLayout.SOUTH,naviTitelLbl);

        layoutNavi.putConstraint(SpringLayout.SOUTH,navi1Btn,-30,SpringLayout.SOUTH,naviPanel);
        layoutNavi.putConstraint(SpringLayout.SOUTH,navi2Btn,-30,SpringLayout.SOUTH,naviPanel);
        layoutNavi.putConstraint(SpringLayout.SOUTH,navi3Btn,-20,SpringLayout.NORTH,navi1Btn);
        layoutNavi.putConstraint(SpringLayout.SOUTH,navi4Btn,-20,SpringLayout.NORTH,navi1Btn);
        layoutNavi.putConstraint(SpringLayout.SOUTH,navi5Btn,-20,SpringLayout.NORTH,navi2Btn);
        layoutNavi.putConstraint(SpringLayout.SOUTH,navi6Btn,-20,SpringLayout.NORTH,navi2Btn);

        naviPanel.add(naviTitelLbl);
        naviPanel.add(naviEbeneLbl);
        naviPanel.add(navi1Btn);
        naviPanel.add(navi2Btn);
        naviPanel.add(navi3Btn);
        naviPanel.add(navi4Btn);
        naviPanel.add(navi5Btn);
        naviPanel.add(navi6Btn);
        gamePanel.add(naviPanel);
        //endregion
        //region lager
        lagerPanel = new JPanel();
        lagerPanel.setPreferredSize(new Dimension(490,285));
        lagerPanel.setBackground(Color.BLACK);

        JLabel lagerBildLbl = new JLabel(new ImageIcon("src/res/NaviBilder/Lager.png"));
        lagerPanel.setVisible(false);
        lagerPanel.add(lagerBildLbl);
        gamePanel.add(lagerPanel);
        //endregion
        //region schatz
        schatzPanel = new JPanel();
        schatzPanel.setPreferredSize(new Dimension(490,285));
        schatzPanel.setBackground(Color.BLACK);

        SpringLayout schatzLayout = new SpringLayout();
        schatzPanel.setLayout(schatzLayout);

        schatzBildLbl = new JLabel(new ImageIcon("src/res/NaviBilder/Schatz.png"));
        schatzAuf = new JButton("Öffnen");
        schatzIgno = new JButton("Ignorieren");

        schatzAuf.setBackground(Color.BLACK);
        schatzIgno.setBackground(Color.BLACK);
        schatzAuf.setForeground(Color.WHITE);
        schatzIgno.setForeground(Color.WHITE);

        schatzLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, schatzBildLbl,0,SpringLayout.HORIZONTAL_CENTER,schatzPanel);
        schatzLayout.putConstraint(SpringLayout.WEST, schatzAuf,10,SpringLayout.WEST,schatzPanel);
        schatzLayout.putConstraint(SpringLayout.EAST, schatzIgno,-10,SpringLayout.EAST,schatzPanel);

        schatzLayout.putConstraint(SpringLayout.SOUTH, schatzAuf,-10,SpringLayout.SOUTH,schatzPanel);
        schatzLayout.putConstraint(SpringLayout.SOUTH, schatzIgno,-10,SpringLayout.SOUTH,schatzPanel);

        schatzIgno.addActionListener(e -> {
            schatzPanel.setVisible(false);
            naviPanel.setVisible(true);
        });
        schatzAuf.addActionListener(e -> {
            SchatzEncounter();
        });

        schatzPanel.add(schatzAuf);
        schatzPanel.add(schatzIgno);
        schatzPanel.setVisible(false);
        schatzPanel.add(schatzBildLbl);
        gamePanel.add(schatzPanel);
        //endregion
        //region laden
        ladenPanel = new JPanel();
        ladenPanel.setPreferredSize(new Dimension(490,285));
        ladenPanel.setBackground(Color.BLACK);

        JLabel ladenBildLbl = new JLabel(new ImageIcon("src/res/NaviBilder/Laden.png"));
        ladenPanel.setVisible(false);
        ladenPanel.add(ladenBildLbl);
        gamePanel.add(ladenPanel);
        //endregion
        //endregion
        //region statpanel
        statPanel = new JPanel();
        add(statPanel);
        statPanel.setPreferredSize(new Dimension(250,455));
        statPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        statPanel.setBackground(Color.BLACK);
        SpringLayout layoutStat = new SpringLayout();
        statPanel.setLayout(layoutStat);

        layout.putConstraint(SpringLayout.EAST, statPanel, -15, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH, statPanel, 20, SpringLayout.NORTH, this);

        //region topside
        spielerHpBar = new JProgressBar(0, spieler.getMaxHp());
        spielerSpBar = new JProgressBar(0, spieler.getMaxSp());
        spielerExpBar = new JProgressBar();

        spielerNameLbl = new JLabel(spieler.getName());
        JLabel spielerHpLbl = new JLabel("HP");
        spielerHp = new JLabel( spieler.getHp() + "/" + spieler.getMaxHp());
        JLabel spielerSpLbl = new JLabel("SP");
        spielerSp = new JLabel( spieler.getSp() + "/" + spieler.getMaxSp());
        JLabel spielerExpLbl = new JLabel("EP");
        spielerExp = new JLabel("" + spieler.getExp());
        JLabel spielerGoldLbl = new JLabel("Gold");
        spielerGold = new JLabel("" + spieler.getGold());


        spielerNameLbl.setFont(statFont);
        spielerNameLbl.setForeground(Color.WHITE);
        spielerHpLbl.setFont(statFont);
        spielerHpLbl.setForeground(Color.WHITE);
        spielerHp.setFont(statFont);
        spielerHp.setForeground(Color.WHITE);
        spielerSpLbl.setFont(statFont);
        spielerSpLbl.setForeground(Color.WHITE);
        spielerSp.setFont(statFont);
        spielerSp.setForeground(Color.WHITE);
        spielerExpLbl.setFont(statFont);
        spielerExpLbl.setForeground(Color.WHITE);
        spielerExp.setFont(statFont);
        spielerExp.setForeground(Color.WHITE);
        spielerGoldLbl.setFont(statFont);
        spielerGoldLbl.setForeground(Color.WHITE);
        spielerGold.setFont(statFont);
        spielerGold.setForeground(Color.WHITE);

        spielerHpBar.setStringPainted(true);
        spielerHpBar.setForeground(Color.decode("#C70039"));
        spielerSpBar.setStringPainted(true);
        spielerSpBar.setForeground(Color.decode("#234ba1"));
        spielerExpBar.setStringPainted(true);
        spielerExpBar.setForeground(new Color(192,129,0));

        layoutStat.putConstraint(SpringLayout.HORIZONTAL_CENTER,spielerNameLbl,0,SpringLayout.HORIZONTAL_CENTER,statPanel);
        layoutStat.putConstraint(SpringLayout.HORIZONTAL_CENTER,spielerHpBar,0,SpringLayout.HORIZONTAL_CENTER,statPanel);
        layoutStat.putConstraint(SpringLayout.HORIZONTAL_CENTER,spielerSpBar,0,SpringLayout.HORIZONTAL_CENTER,statPanel);
        layoutStat.putConstraint(SpringLayout.HORIZONTAL_CENTER,spielerExpBar,0,SpringLayout.HORIZONTAL_CENTER,statPanel);

        layoutStat.putConstraint(SpringLayout.WEST, spielerHpLbl,30,SpringLayout.WEST,statPanel);
        layoutStat.putConstraint(SpringLayout.WEST, spielerSpLbl,30,SpringLayout.WEST,statPanel);
        layoutStat.putConstraint(SpringLayout.WEST, spielerExpLbl,30,SpringLayout.WEST,statPanel);
        layoutStat.putConstraint(SpringLayout.WEST, spielerGoldLbl,30,SpringLayout.WEST,statPanel);
        layoutStat.putConstraint(SpringLayout.EAST,spielerHp,-30,SpringLayout.EAST,statPanel);
        layoutStat.putConstraint(SpringLayout.EAST,spielerSp,-30,SpringLayout.EAST,statPanel);
        layoutStat.putConstraint(SpringLayout.EAST,spielerExp,-30,SpringLayout.EAST,statPanel);
        layoutStat.putConstraint(SpringLayout.EAST,spielerGold,-30,SpringLayout.EAST,statPanel);

        layoutStat.putConstraint(SpringLayout.NORTH, spielerHpLbl,10,SpringLayout.SOUTH,spielerNameLbl);
        layoutStat.putConstraint(SpringLayout.NORTH,spielerHp,10,SpringLayout.SOUTH,spielerNameLbl);
        layoutStat.putConstraint(SpringLayout.NORTH,spielerHpBar,10,SpringLayout.SOUTH, spielerHpLbl);
        layoutStat.putConstraint(SpringLayout.NORTH, spielerSpLbl,10,SpringLayout.SOUTH,spielerHpBar);
        layoutStat.putConstraint(SpringLayout.NORTH,spielerSp,10,SpringLayout.SOUTH,spielerHpBar);
        layoutStat.putConstraint(SpringLayout.NORTH,spielerSpBar,10,SpringLayout.SOUTH, spielerSpLbl);
        layoutStat.putConstraint(SpringLayout.NORTH, spielerExpLbl,10,SpringLayout.SOUTH,spielerSpBar);
        layoutStat.putConstraint(SpringLayout.NORTH,spielerExp,10,SpringLayout.SOUTH,spielerSpBar);
        layoutStat.putConstraint(SpringLayout.NORTH,spielerExpBar,10,SpringLayout.SOUTH, spielerExpLbl);
        layoutStat.putConstraint(SpringLayout.NORTH, spielerGoldLbl, 10, SpringLayout.SOUTH, spielerExpBar);
        layoutStat.putConstraint(SpringLayout.NORTH, spielerGold, 10, SpringLayout.SOUTH, spielerExpBar);


        statPanel.add(spielerNameLbl);
        statPanel.add(spielerHpLbl);
        statPanel.add(spielerHp);
        statPanel.add(spielerHpBar);
        statPanel.add(spielerSpLbl);
        statPanel.add(spielerSp);
        statPanel.add(spielerSpBar);
        statPanel.add(spielerExpLbl);
        statPanel.add(spielerExp);
        statPanel.add(spielerExpBar);
        statPanel.add(spielerGoldLbl);
        statPanel.add(spielerGold);
        //endregion
        //region botside
        JLabel spielerAtkLbl = new JLabel("Angriff");
        spielerAtk = new JLabel("" + spieler.getAtk());
        JLabel spielerDefLbl = new JLabel("Verteidigung");
        spielerDef = new JLabel("" + spieler.getDef());
        JLabel spielerStrLbl = new JLabel("<html><font color='#ff0000'>Stärke");
        spielerStr = new JLabel("" + spieler.getStr());
        JLabel spielerDexLbl = new JLabel("<html><font color='#3cb371'>Geschick");
        spielerDex = new JLabel("" + spieler.getDex());
        JLabel spielerKnoLbl = new JLabel("<html><font color='#94d0ff'>Intelligenz");
        spielerKno = new JLabel("" + spieler.getKno());
        JLabel spielerWisLbl = new JLabel("<html><font color='#ffe400'>Weisheit");
        spielerWis = new JLabel("" + spieler.getWis());
        statUpLbl = new JLabel("");


        spielerAtkLbl.setFont(statFont);
        spielerAtkLbl.setForeground(Color.WHITE);
        spielerAtk.setFont(statFont);
        spielerAtk.setForeground(Color.WHITE);
        spielerDefLbl.setFont(statFont);
        spielerDefLbl.setForeground(Color.WHITE);
        spielerDef.setFont(statFont);
        spielerDef.setForeground(Color.WHITE);
        spielerStrLbl.setFont(statFont);
        spielerStrLbl.setForeground(Color.WHITE);
        spielerStr.setFont(statFont);
        spielerStr.setForeground(Color.WHITE);
        spielerDexLbl.setFont(statFont);
        spielerDexLbl.setForeground(Color.WHITE);
        spielerDex.setFont(statFont);
        spielerDex.setForeground(Color.WHITE);
        spielerKnoLbl.setFont(statFont);
        spielerKnoLbl.setForeground(Color.WHITE);
        spielerKno.setFont(statFont);
        spielerKno.setForeground(Color.WHITE);
        spielerWisLbl.setFont(statFont);
        spielerWisLbl.setForeground(Color.WHITE);
        spielerWis.setFont(statFont);
        spielerWis.setForeground(Color.WHITE);
        statUpLbl.setFont(new Font("Segoe UI", Font.BOLD, 11));
        statUpLbl.setForeground(Color.WHITE);

        layoutStat.putConstraint(SpringLayout.WEST, spielerAtkLbl,30,SpringLayout.WEST,statPanel);
        layoutStat.putConstraint(SpringLayout.WEST, spielerDefLbl,30,SpringLayout.WEST,statPanel);
        layoutStat.putConstraint(SpringLayout.WEST, spielerStrLbl,30,SpringLayout.WEST,statPanel);
        layoutStat.putConstraint(SpringLayout.WEST, spielerDexLbl,30,SpringLayout.WEST,statPanel);
        layoutStat.putConstraint(SpringLayout.WEST, spielerKnoLbl,30,SpringLayout.WEST,statPanel);
        layoutStat.putConstraint(SpringLayout.WEST, spielerWisLbl,30,SpringLayout.WEST,statPanel);

        layoutStat.putConstraint(SpringLayout.EAST,spielerAtk,-30,SpringLayout.EAST,statPanel);
        layoutStat.putConstraint(SpringLayout.EAST,spielerDef,-30,SpringLayout.EAST,statPanel);
        layoutStat.putConstraint(SpringLayout.EAST,spielerStr,-30,SpringLayout.EAST,statPanel);
        layoutStat.putConstraint(SpringLayout.EAST,spielerDex,-30,SpringLayout.EAST,statPanel);
        layoutStat.putConstraint(SpringLayout.EAST,spielerKno,-30,SpringLayout.EAST,statPanel);
        layoutStat.putConstraint(SpringLayout.EAST,spielerWis,-30,SpringLayout.EAST,statPanel);
        layoutStat.putConstraint(SpringLayout.EAST,strUpBtn,-70,SpringLayout.EAST,statPanel);
        layoutStat.putConstraint(SpringLayout.EAST,dexUpBtn,-70,SpringLayout.EAST,statPanel);
        layoutStat.putConstraint(SpringLayout.EAST,knoUpBtn,-70,SpringLayout.EAST,statPanel);
        layoutStat.putConstraint(SpringLayout.EAST,wisUpBtn,-70,SpringLayout.EAST,statPanel);
        layoutStat.putConstraint(SpringLayout.HORIZONTAL_CENTER,statUpLbl,0,SpringLayout.HORIZONTAL_CENTER,statPanel);

        layoutStat.putConstraint(SpringLayout.NORTH, spielerAtkLbl,15,SpringLayout.SOUTH, spielerGoldLbl);
        layoutStat.putConstraint(SpringLayout.NORTH, spielerDefLbl,10,SpringLayout.SOUTH, spielerAtkLbl);
        layoutStat.putConstraint(SpringLayout.NORTH, spielerStrLbl,10,SpringLayout.SOUTH, spielerDefLbl);
        layoutStat.putConstraint(SpringLayout.NORTH, spielerDexLbl,10,SpringLayout.SOUTH, spielerStrLbl);
        layoutStat.putConstraint(SpringLayout.NORTH, spielerKnoLbl,10,SpringLayout.SOUTH, spielerDexLbl);
        layoutStat.putConstraint(SpringLayout.NORTH, spielerWisLbl,10,SpringLayout.SOUTH, spielerKnoLbl);

        layoutStat.putConstraint(SpringLayout.NORTH,spielerAtk,15,SpringLayout.SOUTH,spielerGoldLbl);
        layoutStat.putConstraint(SpringLayout.NORTH,spielerDef,10,SpringLayout.SOUTH,spielerAtk);
        layoutStat.putConstraint(SpringLayout.NORTH,strUpBtn,13,SpringLayout.SOUTH,spielerDef);
        layoutStat.putConstraint(SpringLayout.NORTH,dexUpBtn,13,SpringLayout.SOUTH,spielerStr);
        layoutStat.putConstraint(SpringLayout.NORTH,knoUpBtn,13,SpringLayout.SOUTH,spielerDex);
        layoutStat.putConstraint(SpringLayout.NORTH,wisUpBtn,13,SpringLayout.SOUTH,spielerKno);
        layoutStat.putConstraint(SpringLayout.NORTH,spielerStr,10,SpringLayout.SOUTH,spielerDef);
        layoutStat.putConstraint(SpringLayout.NORTH,spielerDex,10,SpringLayout.SOUTH,spielerStr);
        layoutStat.putConstraint(SpringLayout.NORTH,spielerKno,10,SpringLayout.SOUTH,spielerDex);
        layoutStat.putConstraint(SpringLayout.NORTH,spielerWis,10,SpringLayout.SOUTH,spielerKno);
        layoutStat.putConstraint(SpringLayout.NORTH,statUpLbl,5,SpringLayout.SOUTH,spielerWis);

        strUpBtn.setVisible(false);
        dexUpBtn.setVisible(false);
        knoUpBtn.setVisible(false);
        wisUpBtn.setVisible(false);
        statUpLbl.setVisible(false);
        setStatUpBtn();

//        strUpBtn.setBackground(Color.BLACK);
//        dexUpBtn.setBackground(Color.BLACK);
//        knoUpBtn.setBackground(Color.BLACK);
//        wisUpBtn.setBackground(Color.BLACK);

        strUpBtn.setPreferredSize(new Dimension(16,16));
        dexUpBtn.setPreferredSize(new Dimension(16,16));
        knoUpBtn.setPreferredSize(new Dimension(16,16));
        wisUpBtn.setPreferredSize(new Dimension(16,16));

        statPanel.add(strUpBtn);
        statPanel.add(dexUpBtn);
        statPanel.add(knoUpBtn);
        statPanel.add(wisUpBtn);
        statPanel.add(statUpLbl);
        statPanel.add(spielerAtkLbl);
        statPanel.add(spielerAtk);
        statPanel.add(spielerDefLbl);
        statPanel.add(spielerDef);
        statPanel.add(spielerStrLbl);
        statPanel.add(spielerStr);
        statPanel.add(spielerDexLbl);
        statPanel.add(spielerDex);
        statPanel.add(spielerKnoLbl);
        statPanel.add(spielerKno);
        statPanel.add(spielerWisLbl);
        statPanel.add(spielerWis);
        //endregion
        //endregion
        //region textpanel
        textPanel = new JPanel();
        textPanel.setPreferredSize(new Dimension(500,180));
        textPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        textPanel.setBackground(Color.BLACK);

        layout.putConstraint(SpringLayout.WEST, textPanel, 15,SpringLayout.WEST,this);
        layout.putConstraint(SpringLayout.NORTH, textPanel, 10, SpringLayout.SOUTH, gamePanel);

        textLog = new JTextArea();
        textLog.setLineWrap(true);
        textLog.setEditable(false);
        textLog.setBackground(Color.BLACK);
        textLog.setFont(textFont);
        textLog.setForeground(Color.WHITE);

        JScrollPane textLogScroll = new JScrollPane(textLog);
        textLogScroll.setPreferredSize(new Dimension(490, 170));
        textLogScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
//        textLogScroll.setBorder(BorderFactory.createEmptyBorder());
//        textLogScroll.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));

        textPanel.add(textLogScroll);
        add(textPanel);
        //endregion
        //region buttonpanel
        btnPanel = new JPanel();
        btnPanel.setPreferredSize(new Dimension(300,50));
        btnPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        btnPanel.setBackground(Color.BLACK);

        layout.putConstraint(SpringLayout.WEST,btnPanel,15, SpringLayout.WEST,this);
        layout.putConstraint(SpringLayout.NORTH,btnPanel,10, SpringLayout.SOUTH,textPanel);

        btnPanel.setLayout(new GridLayout());
        add(btnPanel);

        skillBtn1 = new JButton(new ImageIcon("src/res/Skills/Ritter/active15.png"));
        skillBtn2 = new JButton(new ImageIcon("src/res/Skills/Ritter/active15.png"));
        skillBtn3 = new JButton(new ImageIcon("src/res/Skills/Ritter/active15.png"));
        skillBtn4 = new JButton(new ImageIcon("src/res/Skills/Ritter/active15.png"));
        skillBtn5 = new JButton(new ImageIcon("src/res/Skills/Ritter/active15.png"));

        skillBtn1.setBackground(Color.BLACK);
        skillBtn2.setBackground(Color.BLACK);
        skillBtn3.setBackground(Color.BLACK);
        skillBtn4.setBackground(Color.BLACK);
        skillBtn5.setBackground(Color.BLACK);

        skillBtn1.setEnabled(false);
        skillBtn2.setEnabled(false);
        skillBtn3.setEnabled(false);
        skillBtn4.setEnabled(false);
        skillBtn5.setEnabled(false);

        btnPanel.add(skillBtn1);
        btnPanel.add(skillBtn2);
        btnPanel.add(skillBtn3);
        btnPanel.add(skillBtn4);
        btnPanel.add(skillBtn5);
        //endregion
        //region characterpanel
        //region init
        characterPanel = new JPanel();
        characterPanel.setPreferredSize(new Dimension(250,64));
        characterPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        characterPanel.setBackground(Color.BLACK);
        characterPanel.setLayout(new GridLayout(1,4));

        layout.putConstraint(SpringLayout.SOUTH,characterPanel,-30, SpringLayout.SOUTH,this);
        layout.putConstraint(SpringLayout.WEST,characterPanel,20, SpringLayout.EAST,textPanel);

        equipBtn = new JButton(new ImageIcon("src/res/Icons/Helm.png"));
        treeBtn = new JButton(new ImageIcon("src/res/Icons/tree.png"));
        zauberbuchBtn = new JButton(new ImageIcon("src/res/Icons/Zauberbuch.png"));
        testBtn2 = new JButton();

        equipBtn.setBackground(Color.BLACK);
        treeBtn.setBackground(Color.BLACK);
        zauberbuchBtn.setBackground(Color.BLACK);
        testBtn2.setBackground(Color.BLACK);

        characterPanel.add(equipBtn);
        characterPanel.add(treeBtn);
        characterPanel.add(zauberbuchBtn);
        characterPanel.add(testBtn2);

        add(characterPanel);
        //endregion
        //endregion
        //region buttoninfo
        //region skillinfo panel
        skillInfoPanel = new JPanel();
        skillInfoPanel.setPreferredSize(new Dimension(185,50));
        skillInfoPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        skillInfoPanel.setBackground(Color.BLACK);
        Font skillLblFont = new Font("Segoe UI", Font.BOLD, 13);

        layout.putConstraint(SpringLayout.WEST,skillInfoPanel,15, SpringLayout.EAST,btnPanel);
        layout.putConstraint(SpringLayout.NORTH,skillInfoPanel,10, SpringLayout.SOUTH,textPanel);

        SpringLayout layout2 = new SpringLayout();
        skillInfoPanel.setLayout(layout2);

        skillLblName = new JLabel("");
        skillLblKraft = new JLabel("");
        skillLblGenauigkeit = new JLabel("");
        skillLblKosten = new JLabel("");

        layout2.putConstraint(SpringLayout.NORTH, skillLblName,5,SpringLayout.NORTH, skillInfoPanel);
        layout2.putConstraint(SpringLayout.NORTH, skillLblKosten,5,SpringLayout.NORTH, skillInfoPanel);
        layout2.putConstraint(SpringLayout.SOUTH, skillLblKraft,-5,SpringLayout.SOUTH, skillInfoPanel);
        layout2.putConstraint(SpringLayout.SOUTH, skillLblGenauigkeit, -5, SpringLayout.SOUTH,skillInfoPanel);

        layout2.putConstraint(SpringLayout.EAST, skillLblKosten, -5, SpringLayout.EAST, skillInfoPanel);
        layout2.putConstraint(SpringLayout.EAST, skillLblGenauigkeit, -5, SpringLayout.EAST, skillInfoPanel);
        layout2.putConstraint(SpringLayout.WEST, skillLblName, 5, SpringLayout.WEST, skillInfoPanel);
        layout2.putConstraint(SpringLayout.WEST, skillLblKraft, 5, SpringLayout.WEST, skillInfoPanel);

        skillLblName.setForeground(Color.WHITE);
        skillLblKraft.setForeground(Color.WHITE);
        skillLblGenauigkeit.setForeground(Color.WHITE);
        skillLblKosten.setForeground(Color.WHITE);
        skillLblKosten.setFont(skillLblFont);
        skillLblName.setFont(skillLblFont);
        skillLblKraft.setFont(skillLblFont);
        skillLblGenauigkeit.setFont(skillLblFont);
        skillInfoPanel.add(skillLblName);
        skillInfoPanel.add(skillLblKraft);
        skillInfoPanel.add(skillLblGenauigkeit);
        skillInfoPanel.add(skillLblKosten);

        skillInfoPanel.setVisible(false);
        add(skillInfoPanel);
        //endregion
        //region naviinfo panel
        naviInfoPanel = new JPanel();
        naviInfoPanel.setPreferredSize(new Dimension(185,50));
        naviInfoPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        naviInfoPanel.setBackground(Color.BLACK);
        SpringLayout layoutNaviInfo = new SpringLayout();
        naviInfoPanel.setLayout(layoutNaviInfo);

        layout.putConstraint(SpringLayout.WEST,naviInfoPanel,15, SpringLayout.EAST,btnPanel);
        layout.putConstraint(SpringLayout.NORTH,naviInfoPanel,10, SpringLayout.SOUTH,textPanel);

        naviInfoLbl = new JLabel();
        naviInfoLbl.setForeground(Color.WHITE);
        naviInfoLbl.setFont(skillLblFont);

        layoutNaviInfo.putConstraint(SpringLayout.HORIZONTAL_CENTER,naviInfoLbl,0,SpringLayout.HORIZONTAL_CENTER,naviInfoPanel);
        layoutNaviInfo.putConstraint(SpringLayout.VERTICAL_CENTER,naviInfoLbl,0,SpringLayout.VERTICAL_CENTER,naviInfoPanel);

        naviInfoPanel.add(naviInfoLbl);
        naviInfoPanel.setVisible(false);
        add(naviInfoPanel);
        //endregion
        //region charinfo panel
        charInfoPanel = new JPanel();
        charInfoPanel.setPreferredSize(new Dimension(185,50));
        charInfoPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        charInfoPanel.setBackground(Color.BLACK);
        SpringLayout layoutCharInfo = new SpringLayout();
        charInfoPanel.setLayout(layoutCharInfo);

        layout.putConstraint(SpringLayout.WEST,charInfoPanel,15, SpringLayout.EAST,btnPanel);
        layout.putConstraint(SpringLayout.NORTH,charInfoPanel,10, SpringLayout.SOUTH,textPanel);

        charInfoLbl = new JLabel();
        charInfoLbl.setForeground(Color.WHITE);
        charInfoLbl.setFont(skillLblFont);

        layoutCharInfo.putConstraint(SpringLayout.HORIZONTAL_CENTER,charInfoLbl,0,SpringLayout.HORIZONTAL_CENTER,charInfoPanel);
        layoutCharInfo.putConstraint(SpringLayout.VERTICAL_CENTER,charInfoLbl,0,SpringLayout.VERTICAL_CENTER,charInfoPanel);

        charInfoPanel.add(charInfoLbl);
        charInfoPanel.setVisible(false);
        add(charInfoPanel);
        setCharBtn();
        //endregion
        //endregion
    }
    public void setAuswahlScreen() {
        //region init
        ImageIcon icon = new ImageIcon("src/res/Hintergrund/SpielGUI.png");
        hintergrundBild = icon.getImage();
        removeAll();
        repaint();

        SpringLayout layout = new SpringLayout();
        setLayout(layout);
        //endregion
        //region statsPanel
        JPanel statsPanel = new JPanel();
        statsPanel.setPreferredSize(new Dimension(400,150));
        statsPanel.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.WHITE));
        statsPanel.setBackground(Color.BLACK);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, statsPanel, 0, SpringLayout.HORIZONTAL_CENTER,this);
        layout.putConstraint(SpringLayout.SOUTH, statsPanel, 0, SpringLayout.SOUTH,this);

        SpringLayout layoutStats = new SpringLayout();
        statsPanel.setLayout(layoutStats);
        JButton startBtn = new JButton("Start");
        vorschauklasseLbl = new JLabel("");
        vorschauhpLbl = new JLabel(" ");
        vorschauspLbl = new JLabel(" ");
        vorschaustrLbl = new JLabel(" ");
        vorschaudexLbl = new JLabel(" ");
        vorschauknoLbl = new JLabel(" ");
        vorschauwisLbl = new JLabel(" ");
        vorschauatkLbl = new JLabel(" ");
        vorschaudefLbl = new JLabel(" ");


        Font statFont = new Font("Segoe UI", Font.BOLD, 14);
        vorschauklasseLbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
        vorschauhpLbl.setFont(statFont);
        vorschauspLbl.setFont(statFont);
        vorschaustrLbl.setFont(statFont);
        vorschaudexLbl.setFont(statFont);
        vorschauknoLbl.setFont(statFont);
        vorschauwisLbl.setFont(statFont);
        vorschauatkLbl.setFont(statFont);
        vorschaudefLbl.setFont(statFont);

        vorschauklasseLbl.setForeground(Color.WHITE);
        vorschauhpLbl.setForeground(Color.WHITE);
        vorschauspLbl.setForeground(Color.WHITE);
        vorschaustrLbl.setForeground(Color.WHITE);
        vorschaudexLbl.setForeground(Color.WHITE);
        vorschauknoLbl.setForeground(Color.WHITE);
        vorschauwisLbl.setForeground(Color.WHITE);
        vorschauatkLbl.setForeground(Color.WHITE);
        vorschaudefLbl.setForeground(Color.WHITE);

        layoutStats.putConstraint(SpringLayout.HORIZONTAL_CENTER, vorschauklasseLbl, 0, SpringLayout.HORIZONTAL_CENTER,statsPanel);
        layoutStats.putConstraint(SpringLayout.VERTICAL_CENTER, vorschauhpLbl, 30, SpringLayout.VERTICAL_CENTER,vorschauklasseLbl);
        layoutStats.putConstraint(SpringLayout.VERTICAL_CENTER, vorschauatkLbl, 20, SpringLayout.VERTICAL_CENTER,vorschauhpLbl);
        layoutStats.putConstraint(SpringLayout.VERTICAL_CENTER, vorschaustrLbl, 20, SpringLayout.VERTICAL_CENTER,vorschauatkLbl);
        layoutStats.putConstraint(SpringLayout.VERTICAL_CENTER, vorschaudexLbl, 20, SpringLayout.VERTICAL_CENTER,vorschaustrLbl);

        layoutStats.putConstraint(SpringLayout.VERTICAL_CENTER, vorschauspLbl, 30, SpringLayout.VERTICAL_CENTER,vorschauklasseLbl);
        layoutStats.putConstraint(SpringLayout.VERTICAL_CENTER, vorschaudefLbl, 20, SpringLayout.VERTICAL_CENTER,vorschauspLbl);
        layoutStats.putConstraint(SpringLayout.VERTICAL_CENTER, vorschauknoLbl, 20, SpringLayout.VERTICAL_CENTER,vorschaudefLbl);
        layoutStats.putConstraint(SpringLayout.VERTICAL_CENTER, vorschauwisLbl, 20, SpringLayout.VERTICAL_CENTER,vorschauknoLbl);

        layoutStats.putConstraint(SpringLayout.WEST, vorschauhpLbl, 50, SpringLayout.WEST,statsPanel);
        layoutStats.putConstraint(SpringLayout.WEST, vorschauatkLbl, 50, SpringLayout.WEST,statsPanel);
        layoutStats.putConstraint(SpringLayout.WEST, vorschaustrLbl, 50, SpringLayout.WEST,statsPanel);
        layoutStats.putConstraint(SpringLayout.WEST, vorschaudexLbl, 50, SpringLayout.WEST,statsPanel);
        layoutStats.putConstraint(SpringLayout.WEST, vorschauspLbl, 250, SpringLayout.WEST,statsPanel);
        layoutStats.putConstraint(SpringLayout.WEST, vorschaudefLbl, 250, SpringLayout.WEST,statsPanel);
        layoutStats.putConstraint(SpringLayout.WEST, vorschauknoLbl, 250, SpringLayout.WEST,statsPanel);
        layoutStats.putConstraint(SpringLayout.WEST, vorschauwisLbl, 250, SpringLayout.WEST,statsPanel);


        layoutStats.putConstraint(SpringLayout.HORIZONTAL_CENTER, startBtn, 0, SpringLayout.HORIZONTAL_CENTER,statsPanel);
        layoutStats.putConstraint(SpringLayout.SOUTH, startBtn, -10, SpringLayout.SOUTH,statsPanel);

        add(statsPanel);
        //endregion
        //region auswahlVorschauPanel 250 250 100 1030
        JPanel auswahlVorschauPanel = new JPanel();
        add(auswahlVorschauPanel);
        auswahlVorschauPanel.setPreferredSize(new Dimension(400,450));
        auswahlVorschauPanel.setBorder(BorderFactory.createMatteBorder(2,0,2,0,Color.WHITE));
        auswahlVorschauPanel.setBackground(Color.BLACK);

        JLabel vorschauLbl = new JLabel();

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, auswahlVorschauPanel, 0, SpringLayout.HORIZONTAL_CENTER,this);
        auswahlVorschauPanel.add(vorschauLbl);
        //endregion
        //region auswahlPanelLinks
        JPanel auswahlPanelLinks = new JPanel();
        add(auswahlPanelLinks);
        auswahlPanelLinks.setPreferredSize(new Dimension(200,600));
        auswahlPanelLinks.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        auswahlPanelLinks.setBackground(Color.BLACK);
        auswahlPanelLinks.setLayout(new GridLayout(10,0));

        JButton kriegerBtn = new JButton("Krieger");
        JButton jaegerBtn = new JButton("Jäger");
        JButton magierBtn = new JButton("Magier");
        JButton klerikerBtn = new JButton("Kleriker");

        auswahlPanelLinks.add(kriegerBtn);
        auswahlPanelLinks.add(jaegerBtn);
        auswahlPanelLinks.add(magierBtn);
        auswahlPanelLinks.add(klerikerBtn);

        kriegerBtn.setBackground(Color.BLACK);
        kriegerBtn.setForeground(Color.WHITE);
        jaegerBtn.setBackground(Color.BLACK);
        jaegerBtn.setForeground(Color.WHITE);
        magierBtn.setBackground(Color.BLACK);
        magierBtn.setForeground(Color.WHITE);
        klerikerBtn.setBackground(Color.BLACK);
        klerikerBtn.setForeground(Color.WHITE);

        kriegerBtn.addActionListener(e -> {
            krieger.setLvl(1);
            krieger.setHp(30);
            krieger.setSp(15);
            krieger.setMaxHp(30);
            krieger.setMaxSp(15);
            krieger.setAtk(15);
            krieger.setDef(15);
            krieger.setStr(10);
            krieger.setDex(8);
            krieger.setKno(2);
            krieger.setWis(3);
            krieger.setExp(0);
            krieger.setGold(0);
            spieler = krieger;
            vorschauLbl.setIcon(spieler.getBild());
            updateStatsVorschauLbl();
        });
        jaegerBtn.addActionListener(e -> {
            jaeger.setLvl(1);
            jaeger.setHp(15);
            jaeger.setSp(20);
            jaeger.setMaxHp(15);
            jaeger.setMaxSp(20);
            jaeger.setAtk(15);
            jaeger.setDef(10);
            jaeger.setStr(3);
            jaeger.setDex(12);
            jaeger.setKno(4);
            jaeger.setExp(0);
            jaeger.setGold(0);
            spieler = jaeger;
            vorschauLbl.setIcon(spieler.getBild());
            updateStatsVorschauLbl();
        });
        magierBtn.addActionListener(e -> {
            magier.setLvl(1);
            magier.setHp(15);
            magier.setSp(30);
            magier.setMaxHp(15);
            magier.setMaxSp(30);
            magier.setAtk(20);
            magier.setDef(10);
            magier.setStr(1);
            magier.setDex(3);
            magier.setKno(15);
            magier.setWis(3);
            magier.setExp(0);
            magier.setGold(0);
            spieler = magier;
            vorschauLbl.setIcon(spieler.getBild());
            updateStatsVorschauLbl();
        });
        klerikerBtn.addActionListener(e -> {
            kleriker.setLvl(1);
            kleriker.setHp(20);
            kleriker.setSp(20);
            kleriker.setMaxHp(20);
            kleriker.setMaxSp(20);
            kleriker.setAtk(15);
            kleriker.setDef(15);
            kleriker.setStr(3);
            kleriker.setDex(4);
            kleriker.setKno(3);
            kleriker.setWis(10);
            kleriker.setExp(0);
            kleriker.setGold(0);
            spieler = kleriker;
            vorschauLbl.setIcon(spieler.getBild());
            updateStatsVorschauLbl();
        });
        //endregion
        //region auswahlPanelRechts
        JPanel auswahlPanelRechts = new JPanel();
        add(auswahlPanelRechts);
        auswahlPanelRechts.setPreferredSize(new Dimension(200,600));
        auswahlPanelRechts.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        auswahlPanelRechts.setBackground(Color.BLACK);

        layout.putConstraint(SpringLayout.EAST, auswahlPanelRechts, 0, SpringLayout.EAST, this);
        //endregion

        statsPanel.add(vorschauklasseLbl);
        statsPanel.add(vorschauhpLbl);
        statsPanel.add(vorschauspLbl);
        statsPanel.add(vorschauatkLbl);
        statsPanel.add(vorschaudefLbl);
        statsPanel.add(vorschaustrLbl);
        statsPanel.add(vorschaudexLbl);
        statsPanel.add(vorschauknoLbl);
        statsPanel.add(vorschauwisLbl);
        statsPanel.add(startBtn);
        startBtn.addActionListener(e -> {
            if (!spieler.getName().equals(null)) {
                gameStart();
            }
        });
    }
    public void updateStatsVorschauLbl() {
        vorschauklasseLbl.setText(spieler.getName());
        vorschauhpLbl.setText("<html><font color='#C70039'>HP: " + spieler.getHp());
        vorschauspLbl.setText("<html><font color='#234ba1'>SP: " + spieler.getSp());
        vorschauatkLbl.setText("Angriff: " + spieler.getAtk());
        vorschaudefLbl.setText("Verteidigung: " + spieler.getDef());
        vorschaustrLbl.setText("<html><font color='#ff0000'>Stärke: " + spieler.getStr());
        vorschaudexLbl.setText("<html><font color='#3cb371'>Geschick: " + spieler.getDex());
        vorschauknoLbl.setText("<html><font color='#94d0ff'>Intelligenz: " + spieler.getKno());
        vorschauwisLbl.setText("<html><font color='#ffe400'>Weisheit: " + spieler.getWis());
    }
    public void setGameOverScreen() {
        removeAll();
        ImageIcon icon = new ImageIcon("src/res/Hintergrund/GameOver.jpg");
        hintergrundBild = icon.getImage();
        repaint();
        revalidate();
        JPanel gameOverPanel = new JPanel();
        gameOverPanel.setPreferredSize(new Dimension(150,100));
        JLabel gameOverName = new JLabel(spieler.getName());
        JLabel gameOverLevel = new JLabel("Level " + spieler.getLvl());
        JLabel gameOverEbene = new JLabel("Ebene " + ebeneCounter);


        gameOverName.setFont(new Font("Segoe UI", Font.BOLD,14));
        gameOverName.setForeground(Color.WHITE);
        gameOverLevel.setFont(new Font("Segoe UI", Font.BOLD,14));
        gameOverLevel.setForeground(Color.WHITE);
        gameOverEbene.setFont(new Font("Segoe UI", Font.BOLD,14));
        gameOverEbene.setForeground(Color.WHITE);

        gameOverPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        gameOverPanel.setBackground(Color.BLACK);

        SpringLayout layoutPanel = new SpringLayout();
        gameOverPanel.setLayout(layoutPanel);

        layoutPanel.putConstraint(SpringLayout.HORIZONTAL_CENTER,gameOverName,0,SpringLayout.HORIZONTAL_CENTER,gameOverPanel);
        layoutPanel.putConstraint(SpringLayout.HORIZONTAL_CENTER,gameOverLevel,0,SpringLayout.HORIZONTAL_CENTER,gameOverPanel);
        layoutPanel.putConstraint(SpringLayout.HORIZONTAL_CENTER,gameOverEbene,0,SpringLayout.HORIZONTAL_CENTER,gameOverPanel);

        layoutPanel.putConstraint(SpringLayout.NORTH,gameOverName,10,SpringLayout.NORTH,gameOverPanel);
        layoutPanel.putConstraint(SpringLayout.NORTH,gameOverLevel,10,SpringLayout.SOUTH,gameOverName);
        layoutPanel.putConstraint(SpringLayout.NORTH,gameOverEbene,10,SpringLayout.SOUTH,gameOverLevel);

        gameOverPanel.add(gameOverName);
        gameOverPanel.add(gameOverLevel);
        gameOverPanel.add(gameOverEbene);

        SpringLayout layout = new SpringLayout();
        setLayout(layout);

        JLabel gameOverLbl = new JLabel("Game Over");
        gameOverLbl.setFont(new Font("Times New Roman", Font.BOLD, 90));
        gameOverLbl.setForeground(Color.WHITE);
        add(gameOverLbl);

        JButton gameOverBtn = new JButton("Neustart");
        gameOverBtn.setForeground(Color.WHITE);
        gameOverBtn.setBackground(Color.BLACK);
        add(gameOverBtn);
        add(gameOverPanel);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,gameOverLbl,0,SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,gameOverBtn,0,SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER,gameOverLbl,100,SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER,gameOverBtn,-80,SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,gameOverPanel,0,SpringLayout.HORIZONTAL_CENTER,this);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER,gameOverPanel,0,SpringLayout.VERTICAL_CENTER,this);

        gameOverBtn.addActionListener(e -> {
            spielFrame.dispose();
            ebeneCounter = 1;
            new Spiel();
            revalidate();
        });
    }
    public void gameStart() {
        setSpielScreen();
        Spiel.Test();
        setSkills();
        setNavi();
    }
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(hintergrundBild,0,0,800,600,null);
    }
}
