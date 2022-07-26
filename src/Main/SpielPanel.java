package Main;

import javax.swing.*;
import java.awt.*;

public class SpielPanel extends JPanel {
    Image hintergrundBild;
    JPanel gamePanel, statPanel,btnPanel, textPanel, skillInfoPanel;
    static JButton skillBtn1, skillBtn2, skillBtn3, skillBtn4, skillBtn5;
    static JLabel skillLblName, skillLblKraft, skillLblMod;

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
            setSpielScreen();
            Spiel.Test();
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

        skillLblName = new JLabel("Name");
        skillLblKraft = new JLabel("Kraft");
        skillLblMod = new JLabel("Stärke");

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

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(hintergrundBild,0,0,800,600,null);
    }
}
