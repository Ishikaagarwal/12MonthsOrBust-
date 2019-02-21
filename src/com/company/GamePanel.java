package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {
    private ParentPanel parent;
    private Game game;
    private JButton dice, tutorialButton;
    private JButton boostMeButton;
    private boolean isRolling = false;
    private int numberRolled;

    GamePanel(Game myGame, ParentPanel parentPanel) {
        game = myGame;
        parent = parentPanel;

        setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));

        dice = new JButton("Roll the Dice");
        dice.addActionListener(this);
        add(dice, BorderLayout.NORTH);

        tutorialButton = new JButton("Back to tutorial");
        add(tutorialButton);
        tutorialButton.addActionListener(this);

        boostMeButton = new JButton("EMERGENCY $100 BOOST");
        add(boostMeButton);
        boostMeButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(dice == e.getSource()){
            isRolling = true;
            numberRolled = (int)(Math.random()* 5 + 1);
            game.currentPosition += numberRolled;

            if(game.currentPosition > 30){
                game.currentPosition = game.currentPosition % 30;
                game.playerBalance += game.moneyInBank * 2;
                game.currentLevel++;
                if (game.currentLevel > 11){
                    parent.ShowYouWinPanel();
                }
                else {
                    parent.ShowBankPanel();
                }
            }

            double charge = game.charges[game.currentPosition - 1] * (1 +game.currentLevel/2.5);
            game.playerBalance += charge;

            if(game.playerBalance < 0){
                parent.ShowGameOverPanel();
            }
            repaint();
        }

        if(tutorialButton == e.getSource()){
            parent.ShowTutorialPanel();
        }

        if(boostMeButton == e.getSource()){
            game.playerBalance += 100;
            boostMeButton.setVisible(false);
            repaint();
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //change the backgrounds according to the months
        if (game.currentLevel == 0 || game.currentLevel == 5 || game.currentLevel == 7 || game.currentLevel == 11) {
            Color color = new Color(163, 188, 255);
            setBackground(color);
        } else if (game.currentLevel == 9 || game.currentLevel == 10) {
            Color color = new Color(235, 171, 100);
            setBackground(color);
        } else if (game.currentLevel == 2 || game.currentLevel == 8) {
            Color color = new Color(253, 255, 122);
            setBackground(color);
        } else if (game.currentLevel == 3 || game.currentLevel == 6) {
            Color color = new Color(169, 255, 152);
            setBackground(color);
        } else {
            Color color = new Color(255, 147, 248);
            setBackground(color);
        }

        g.setFont(new Font("Utopia", Font.BOLD, 24));
        g.setColor(Color.BLUE);
        g.drawString("Current Balance: "+ game.playerBalance, 300, 100);

        g.drawString("Money in Savings Account: " + game.moneyInBank, 600, 100);
        g.drawString(game.months[game.currentLevel], 1100, 100);

        Image boardImage = Toolkit.getDefaultToolkit().getImage("calendar.jpg");
        g.drawImage(boardImage, 0, 110,1600, 1100, this);

        //where the pawn/test starts from
        int startX = 20;
        int startY = 250;

        Font chargeFont = new Font("Utopia", Font.BOLD, 12);
        g.setFont(chargeFont);

        for(int i = 0; i < 31; i++){
            //the top x,y where the text starts
            int topX = startX + 235 * ((i % 7));
            int topY =  startY + 155 * (i / 7);
            g.setColor(Color.BLACK);
            g.drawString(game.prompts[i], topX, topY);

            //increases the charges each month
            double charge = (int)Math.abs(game.charges[i] * (1 + game.currentLevel/0.7));
            if(game.charges[i] < 0){
                g.setColor(Color.RED);
                g.drawString("Pay $" + charge, topX, topY + 15);
            }
            else{
                Color myGreen = new Color(0, 112, 0);
                g.setColor(myGreen);
                g.drawString("Get $" + charge, topX, topY + 15);
            }
        }

        //dimensions of the pawn
        int squareWidth = 50;
        int squareHeight = 50;

        //controls the x,y of the pawn when it moves
        int topX = 75 + ((game.currentPosition - 1) % 7) * 235;
        int topY =  300 + ((game.currentPosition - 1) / 7) * 155;
        int bottomX = topX + squareWidth;
        int bottomY = topY + squareHeight;
        System.out.println(bottomX + " " + bottomY);

        Image pawn = Toolkit.getDefaultToolkit().getImage("Pawn.png");
        g.drawImage(pawn, topX, topY, bottomX,  bottomY, 15, 10, 240, 240, this);

        if(isRolling){
            g.setFont(new Font("Utopia",Font.BOLD, 20));
            g.setColor(Color.RED);
            g.drawString("You rolled " + numberRolled, 200, 40);
        }
    }
}