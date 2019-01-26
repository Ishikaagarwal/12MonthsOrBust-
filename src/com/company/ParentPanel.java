package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ParentPanel extends JPanel implements MouseListener {
    int panelsShown = 1;
    CardLayout layoutMan;
    boolean isTutorialClicked = false;

    ParentPanel(Game myGame) {
        //initialize cardLayout
        layoutMan = new CardLayout();
        addMouseListener(this);
        setLayout(layoutMan);

        TitlePanel title = new TitlePanel();
        TutorialPanel tutorial = new TutorialPanel();
        BankPanel bankPanel = new BankPanel(myGame, this);
        GamePanel gamePanel = new GamePanel(myGame, this);
        GameOverPanel gameOverPanel = new GameOverPanel(myGame);
        YouWinPanel youwinPanel = new YouWinPanel(myGame);

        //add panels to the cardLayout
        add(title, "title panel");
        add(tutorial, "tutorial panel");
        add(bankPanel, "bank");
        add(gamePanel, "board and status panels");
        add(gameOverPanel, "game over panel");
        add(youwinPanel, "you win panel");
    }

    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }

    public void mouseClicked(MouseEvent e) {
        if (panelsShown <= 2) {
            layoutMan.next(this);
            panelsShown++;
        }
        if(isTutorialClicked){
            ShowBoardPanel();
        }
    }

    public void ShowBankPanel() {
        layoutMan.show(this, "bank");
    }

    public void ShowBoardPanel() {
        layoutMan.show(this, "board and status panels");
    }

    public void ShowGameOverPanel() {
        layoutMan.show(this, "game over panel");
    }

    public void ShowYouWinPanel() {
        layoutMan.show(this, "you win panel");
    }

    public void ShowTutorialPanel(){
        layoutMan.show(this, "tutorial panel");
        isTutorialClicked = true;
    }
}

