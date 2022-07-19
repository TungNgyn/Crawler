package Main;

import javax.swing.*;
import java.awt.*;

public class SpielPanel extends JPanel {
    Image hintergrundBild;
    JPanel gegnerPanel, statPanel,btnPanel, textPanel;

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
        //region gegnerpanel
        gegnerPanel = new JPanel();
        add(gegnerPanel);
        gegnerPanel.setPreferredSize(new Dimension(500,300));
        gegnerPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        gegnerPanel.setBackground(Color.BLACK);

        layout.putConstraint(SpringLayout.WEST,gegnerPanel,15, SpringLayout.WEST,this);
        layout.putConstraint(SpringLayout.NORTH,gegnerPanel,20, SpringLayout.NORTH,this);
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
        layout.putConstraint(SpringLayout.NORTH, textPanel, 10, SpringLayout.SOUTH, gegnerPanel);

        add(textPanel);
        //endregion
        //region buttonpanel
        btnPanel = new JPanel();
        btnPanel.setPreferredSize(new Dimension(300,50));
        btnPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        btnPanel.setBackground(Color.BLACK);

        layout.putConstraint(SpringLayout.WEST,btnPanel,15, SpringLayout.WEST,this);
        layout.putConstraint(SpringLayout.NORTH,btnPanel,10, SpringLayout.SOUTH,textPanel);

        add(btnPanel);
        //endregion

    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(hintergrundBild,0,0,800,600,null);
    }
}
