package Main;

import javax.swing.*;

public class SpielFrame extends JFrame {

    public SpielFrame(SpielPanel spielPanel) {
        add(spielPanel);
        pack();
        setTitle("Crawler");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
