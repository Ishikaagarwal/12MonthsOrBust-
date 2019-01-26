package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankPanel extends JPanel implements ActionListener {
    private JTextField txtMoney;
    private JButton okButton;
    private boolean isNotEnoughBalance = false;
    private ParentPanel parent;
    private Game game;

    BankPanel(Game myGame, ParentPanel parentPanel) {
        game = myGame;
        parent = parentPanel;
        txtMoney = new JTextField(20);
        txtMoney.addActionListener(this);

        okButton = new JButton("Ok. Submit my amount.");
        okButton.addActionListener(this);

        add(txtMoney);
        add(okButton);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color c = new Color(255, 153, 156);
        setBackground(c);

        g.setFont(new Font("Utopia", Font.BOLD, 25));
        g.setColor(new Color(248, 255, 123));
        g.drawString("Enter the amount of money you want deposit in the ATM into the text field.", 0, 65);
        g.drawString("Please do not enter decimals or dollar signs.", 0, 100);
        g.drawString("Currently you have earned $" + (game.moneyInBank * 2) + " in interest.", 0, 135);
        g.drawString("Your current balance is $" + game.playerBalance, 400, 300);

        if (isNotEnoughBalance) {
            g.setColor(Color.RED);
            Font errorFont = new Font("Utopia", Font.BOLD, 50);
            g.setFont(errorFont);
            g.drawString("Please enter a valid amount", 0, 85);
            g.setColor(Color.BLACK);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (okButton == e.getSource()) {
            String amount = txtMoney.getText();
            int money = Integer.parseInt(amount);

            if (money < game.playerBalance) {
                game.playerBalance -= money;
                game.moneyInBank = money;
                isNotEnoughBalance = false;
                parent.ShowBoardPanel();
            } else {
                isNotEnoughBalance = true;
                repaint();
            }
        }
    }
}
