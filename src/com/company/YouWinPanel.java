
package com.company;

import javax.swing.*;
import java.awt.*;

class YouWinPanel extends JPanel {
    Game game;
    public YouWinPanel(Game myGame){
        game = myGame;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color back =  new Color(229, 248, 255);
        setBackground(back);

        //display youwin.jpg to the panel
        //make sure its square because the pic is square
        Image titleImage = Toolkit.getDefaultToolkit().getImage("youwin.jpg");
        g.drawImage(titleImage, 0, 0, 1100, 1100, 0, 0, 400, 400, this);

        //make pretty font and color for the panel
        Font winFont = new Font("Utopia", Font.ITALIC, 50);
        g.setFont(winFont);

        Color winColor = new Color(145, 0, 193);
        g.setColor(winColor);

        //print out all the information that the user needs to know
        //such as the month that they finished, and their final balance
        //make sure to display it as wrapped text so it wont go off the panel
        g.drawString("Current Month: ", 1100, 50);
        g.drawString(game.months[game.currentLevel - 1], 1200, 100);

        g.drawString("Your final balance", 1100, 200);
        g.drawString("was $" + game.playerBalance, 1200, 250);

        g.drawString("You are now ready ", 1100, 350);
        g.drawString("for the real world!!!", 1200, 400);
    }
}

