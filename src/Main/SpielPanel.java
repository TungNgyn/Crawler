package Main;

import Charaktere.Spieler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import static Main.Spiel.spieler;

public class SpielPanel extends JPanel {
    Image hintergrundBild;
    JPanel gamePanel, statPanel,btnPanel, textPanel, skillInfoPanel;
    static JButton skillBtn1, skillBtn2, skillBtn3, skillBtn4, skillBtn5;
    static JLabel skillLblName, skillLblKraft, skillLblMod, klasseLbl, hpLbl,
    spLbl,strLbl,dexLbl,knoLbl,wisLbl;

    public SpielPanel() {
        setTitelScreen();
    }

    public void setTitelScreen() {
        SpringLayout layout = new SpringLayout();
        setLayout(layout);
        setPreferredSize(new Dimension(800,600));
        ImageIcon icon = new ImageIcon("res/Hintergrund/Titel.jpg");
        hintergrundBild = icon.getImage();
        JLabel titelLbl = new JLabel("Grinder");
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
        ImageIcon icon = new ImageIcon("res/Hintergrund/SpielGUI.png");
        hintergrundBild = icon.getImage();
        removeAll();
        repaint();

        SpringLayout layout = new SpringLayout();
        setLayout(layout);
        //endregion
        //region gamepanel
        gamePanel = new JPanel();
        add(gamePanel);
        gamePanel.setPreferredSize(new Dimension(500,300));
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        gamePanel.setBackground(Color.BLACK);

        layout.putConstraint(SpringLayout.WEST,gamePanel,15, SpringLayout.WEST,this);
        layout.putConstraint(SpringLayout.NORTH,gamePanel,20, SpringLayout.NORTH,this);
        //endregion
        //region statpanel
        statPanel = new JPanel();
        add(statPanel);
        statPanel.setPreferredSize(new Dimension(250,500));
        statPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        statPanel.setBackground(Color.BLACK);

        layout.putConstraint(SpringLayout.EAST, statPanel, -15, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.SOUTH, statPanel, -20, SpringLayout.SOUTH, this);
        //endregion
        //region textpanel
        textPanel = new JPanel();
        textPanel.setPreferredSize(new Dimension(500,180));
        textPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        textPanel.setBackground(Color.BLACK);

        layout.putConstraint(SpringLayout.WEST, textPanel, 15,SpringLayout.WEST,this);
        layout.putConstraint(SpringLayout.NORTH, textPanel, 10, SpringLayout.SOUTH, gamePanel);

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

        skillBtn1 = new JButton(new ImageIcon("res/Skills/Ritter/active15.png"));
        skillBtn2 = new JButton(new ImageIcon("res/Skills/Ritter/active15.png"));
        skillBtn3 = new JButton(new ImageIcon("res/Skills/Ritter/active15.png"));
        skillBtn4 = new JButton(new ImageIcon("res/Skills/Ritter/active15.png"));
        skillBtn5 = new JButton(new ImageIcon("res/Skills/Ritter/active15.png"));

        skillBtn1.setBackground(Color.BLACK);
        skillBtn2.setBackground(Color.BLACK);
        skillBtn3.setBackground(Color.BLACK);
        skillBtn4.setBackground(Color.BLACK);
        skillBtn5.setBackground(Color.BLACK);

        btnPanel.add(skillBtn1);
        btnPanel.add(skillBtn2);
        btnPanel.add(skillBtn3);
        btnPanel.add(skillBtn4);
        btnPanel.add(skillBtn5);
        //endregion
        //region buttoninfo
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
        skillLblMod = new JLabel("");

        layout2.putConstraint(SpringLayout.NORTH, skillLblName,5,SpringLayout.NORTH, skillInfoPanel);
        layout2.putConstraint(SpringLayout.NORTH, skillLblMod,5,SpringLayout.NORTH, skillInfoPanel);
        layout2.putConstraint(SpringLayout.SOUTH, skillLblKraft,-5,SpringLayout.SOUTH, skillInfoPanel);
        layout2.putConstraint(SpringLayout.EAST, skillLblMod, -5, SpringLayout.EAST, skillInfoPanel);
        layout2.putConstraint(SpringLayout.WEST, skillLblName, 5, SpringLayout.WEST, skillInfoPanel);
        layout2.putConstraint(SpringLayout.WEST, skillLblKraft, 5, SpringLayout.WEST, skillInfoPanel);

        skillLblName.setForeground(Color.WHITE);
        skillLblKraft.setForeground(Color.WHITE);
        skillLblMod.setForeground(Color.WHITE);
        skillLblName.setFont(skillLblFont);
        skillLblKraft.setFont(skillLblFont);
        skillLblMod.setFont(skillLblFont);
        skillInfoPanel.add(skillLblName);
        skillInfoPanel.add(skillLblKraft);
        skillInfoPanel.add(skillLblMod);

        add(skillInfoPanel);
        //endregion

    }
    public void setAuswahlScreen() {
        //region init
        ImageIcon icon = new ImageIcon("res/Hintergrund/SpielGUI.png");
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
        klasseLbl = new JLabel("Klasse");
        hpLbl = new JLabel("HP: ");
        spLbl = new JLabel("SP: ");
        strLbl = new JLabel("Stärke: ");
        dexLbl = new JLabel("Geschick: ");
        knoLbl = new JLabel("Intelligenz: ");
        wisLbl = new JLabel("Weisheit: ");


        Font statFont = new Font("Segoe UI", Font.BOLD, 14);
        klasseLbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
        hpLbl.setFont(statFont);
        spLbl.setFont(statFont);
        strLbl.setFont(statFont);
        dexLbl.setFont(statFont);
        knoLbl.setFont(statFont);
        wisLbl.setFont(statFont);

        klasseLbl.setForeground(Color.WHITE);
        hpLbl.setForeground(Color.WHITE);
        spLbl.setForeground(Color.WHITE);
        strLbl.setForeground(Color.WHITE);
        dexLbl.setForeground(Color.WHITE);
        knoLbl.setForeground(Color.WHITE);
        wisLbl.setForeground(Color.WHITE);

        layoutStats.putConstraint(SpringLayout.HORIZONTAL_CENTER, klasseLbl, 0, SpringLayout.HORIZONTAL_CENTER,statsPanel);
        layoutStats.putConstraint(SpringLayout.VERTICAL_CENTER, hpLbl, 30, SpringLayout.VERTICAL_CENTER,klasseLbl);
        layoutStats.putConstraint(SpringLayout.VERTICAL_CENTER, spLbl, 30, SpringLayout.VERTICAL_CENTER,klasseLbl);
        layoutStats.putConstraint(SpringLayout.VERTICAL_CENTER, strLbl, 20, SpringLayout.VERTICAL_CENTER,hpLbl);
        layoutStats.putConstraint(SpringLayout.VERTICAL_CENTER, dexLbl, 20, SpringLayout.VERTICAL_CENTER,strLbl);
        layoutStats.putConstraint(SpringLayout.VERTICAL_CENTER, knoLbl, 20, SpringLayout.VERTICAL_CENTER,spLbl);
        layoutStats.putConstraint(SpringLayout.VERTICAL_CENTER, wisLbl, 20, SpringLayout.VERTICAL_CENTER,knoLbl);

        layoutStats.putConstraint(SpringLayout.WEST, hpLbl, 50, SpringLayout.WEST,statsPanel);
        layoutStats.putConstraint(SpringLayout.WEST, strLbl, 50, SpringLayout.WEST,statsPanel);
        layoutStats.putConstraint(SpringLayout.WEST, dexLbl, 50, SpringLayout.WEST,statsPanel);
        layoutStats.putConstraint(SpringLayout.WEST, spLbl, 250, SpringLayout.WEST,statsPanel);
        layoutStats.putConstraint(SpringLayout.WEST, knoLbl, 250, SpringLayout.WEST,statsPanel);
        layoutStats.putConstraint(SpringLayout.WEST, wisLbl, 250, SpringLayout.WEST,statsPanel);


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
            spieler.setName("Krieger");
            spieler.setHp(30);
            spieler.setSp(15);
            spieler.setStr(10);
            spieler.setDex(8);
            spieler.setKno(2);
            spieler.setWis(3);
            vorschauLbl.setIcon(new ImageIcon("res/Klassen/Krieger.png"));
            updateStatsLbl();
        });
        jaegerBtn.addActionListener(e -> {
            spieler.setName("Jäger");
            spieler.setHp(15);
            spieler.setSp(20);
            spieler.setStr(3);
            spieler.setDex(12);
            spieler.setKno(4);
            spieler.setWis(6);vorschauLbl.setIcon(new ImageIcon("res/Klassen/Jaeger.png"));
            updateStatsLbl();
        });
        magierBtn.addActionListener(e -> {
            spieler.setName("Magier");
            spieler.setHp(15);
            spieler.setSp(30);
            spieler.setStr(1);
            spieler.setDex(3);
            spieler.setKno(15);
            spieler.setWis(3);
            vorschauLbl.setIcon(new ImageIcon("res/Klassen/Magier.png"));
            updateStatsLbl();
        });
        klerikerBtn.addActionListener(e -> {
            spieler.setName("Kleriker");
            spieler.setHp(20);
            spieler.setSp(20);
            spieler.setStr(3);
            spieler.setDex(4);
            spieler.setKno(3);
            spieler.setWis(10);
            vorschauLbl.setIcon(new ImageIcon("res/Klassen/Kleriker.png"));
            updateStatsLbl();
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

        statsPanel.add(klasseLbl);
        statsPanel.add(hpLbl);
        statsPanel.add(spLbl);
        statsPanel.add(strLbl);
        statsPanel.add(dexLbl);
        statsPanel.add(knoLbl);
        statsPanel.add(wisLbl);
        statsPanel.add(startBtn);
        startBtn.addActionListener(e -> {
            if (!spieler.getName().equals(null)) {
                setSpielScreen();
                Spiel.Test();
            }
        });
    }
    public void updateStatsLbl() {
        klasseLbl.setText(spieler.getName());
        hpLbl.setText("HP: " + spieler.getHp());
        spLbl.setText("SP: " + spieler.getSp());
        strLbl.setText("<html><font color='#ff0000'>Stärke: " + spieler.getStr());
        dexLbl.setText("<html><font color='#3cb371'>Geschick: " + spieler.getDex());
        knoLbl.setText("<html><font color='#94d0ff'>Intelligenz: " + spieler.getKno());
        wisLbl.setText("<html><font color='#ffe400'>Weisheit: " + spieler.getWis());
    }
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(hintergrundBild,0,0,800,600,null);
    }
}
