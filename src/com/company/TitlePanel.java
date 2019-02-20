package com.company;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Utopia", Font.BOLD, 100));
        g.setColor(Color.BLUE);
        g.drawString("12 Months or Bust!", 350, 500);   //title of game
        g.setFont(new Font("Utopia", Font.BOLD, 35));
        g.drawString("Click through to continue.",300, 600);      //the prompt
    }
}
