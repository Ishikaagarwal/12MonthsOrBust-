package com.company;

import javax.swing.*;
import java.awt.*;

class GameOverPanel extends JPanel {
    Game game;
    GameOverPanel(Game myGame){
        game = myGame;
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(new Color(0xFFFFFF));
        Image titleImage = Toolkit.getDefaultToolkit().getImage("gameOver.jpg");
        g.drawImage(titleImage, 0, 0, 1000, 700, 0, 0, 670, 675, this);

        Font infoFont = new Font("Utopia", Font.ROMAN_BASELINE, 50);
        setFont(infoFont);

        Color overColor = new Color(75, 0, 200);
        g.setColor(overColor);
        g.drawString("Current Month: " + game.months[game.currentLevel], 0, 400);
        g.drawString("Your final balance was $" + game.playerBalance, 0, 460);
    }
}