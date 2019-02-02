package com.company;

import javax.swing.*;
import java.awt.*;

public class TutorialPanel extends JPanel {
    protected void paintComponent(Graphics g) {
        Color textOne = new Color(255, 198, 111);
        Color textTwo = new Color(193, 255, 195);
        Color blue = new Color(101, 113, 255);

        g.setColor(blue);
        g.fillRect(0, 0, 1600, 1100);

        Font tutorialFont = new Font("Utopia", Font.BOLD, 45);
        g.setFont(tutorialFont);
        g.setColor(textOne);

        String[] instructions = {"What is budgeting?", "Budgeting is saving money while spending on necessities like food,",
                "rent, water, electricity and Internet. Budgeting helps us save up", "for things like new bikes, smart phones and more even though we",
                "are still spending money. The trick is to save a little bit each", "day so that we have a lot of money at the end of the month! That's",
                "where banks can come in handy. You can put your savings into a", "bank account, and you can even earn some money! At the end of the",
                "month, there might be a little more than what you put in before!", "", "How do you play the game?",
                "Initially, you have $1200. At the beginning of each month,", "you can put money in your savings account. At the end of the month,",
                "you will get twice the initial amount as a salary.", "Each day, you roll the dice and you either pay for something, or",
                "you earn money. Budget wisely since prices increase.", "If you reach the end of December, you win! Good luck!"};

        int lh = 52;
        int start = 70;
        int startPos = 30;

        for(int i = 0; i < instructions.length; i++) {
            if(i == 9){ g.setColor(textTwo); }
            g.drawString(instructions[i], startPos, start + i * lh);
        }

    }
}