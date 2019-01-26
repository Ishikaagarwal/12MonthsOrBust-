package com.company;

public class Game{
 //define global variables such as balance of player, and money in the bank
    int playerBalance, moneyInBank;
    int currentPosition;
    int currentLevel;

    //write all the prompts
    String[] prompts = {"Pay day",
            "Buy gas",
            "Get a haircut",
            "Find money on the sidewalk",
            "Buy present for sister",
            "Invest in stock market",
            "Sell Girl Scout cookies",
            "Buy a new electronic device",
            "Buy groceries",
            "Win a school competition",
            "Donate money to charity",
            "Buy clothes",
            "Get paid for babysitting",
            "Sell your old chair",
            "Get money from Grandma",
            "Sell lemonade",
            "Visit doctor",
            "Pay medical insurance",
            "Receive birthday money",
            "Go to the movies",
            "Pay car insurance",
            "Win the lottery",
            "Dine Out",
            "Pay electricity bill",
            "Get money from tooth fairy",
            "Pay cell phone bill",
            "Buy dog food",
            "Wash cars to earn money",
            "Pay credit card bill",
            "Go to the school play",
            "Drive an Uber for a day"
    };

    //initialize all the money charges that we are going to charge user
    double [] charges = {0, -30, -10, 20, -15, 100, 70, -35, -25, 100, -100, -20, 70, 25, 50, 75, -40, -250, 90,
            -10, -150, 200, -30, -60, 20, -100, -20, 70, -150, -10, 50};

    String[] months = {"January" , "February" , "March" , "April", "May",
            "June", "July", "August", "September", "October",
            "November", "December"};
    //main method
    //only going to call constructor and the draw board method
    public static void main (String[] args) {
        Game myGame = new Game();
        myGame.DrawBoard(myGame);
    }

    //constructor:
    //will make assign the prompts
    //will also initialize all the global variables
    private Game(){
        playerBalance = 1200;
        moneyInBank = 0;
        currentPosition = 1;
        currentLevel = 0;
    }

    private void DrawBoard(Game myGame){
        new GameFrame(myGame);
    }
}
