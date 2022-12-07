package org.cal.examen;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Game {
    QuestionHandler questionHandler;


    List<String> players = new ArrayList<>();
    int[] places = new int[6];
    int[] purses  = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public  Game(){
        questionHandler = new QuestionHandler();
    }


    public boolean wasCorrectlyAnswered() {
        if (!inPenaltyBox[currentPlayer]){
            System.out.println("Answer was corrent!!!!");
            purses[currentPlayer]++;
            System.out.println(players.get(currentPlayer)
                    + " now has "
                    + purses[currentPlayer]
                    + " Gold Coins.");

            boolean winner = didPlayerWin();
            adjustCurrentPlayer();
            return winner;
        }

        if (isGettingOutOfPenaltyBox) {
            System.out.println("Answer was correct!!!!");
            purses[currentPlayer]++;
            System.out.println(players.get(currentPlayer)
                    + " now has "
                    + purses[currentPlayer]
                    + " Gold Coins.");
            boolean winner = didPlayerWin();
            adjustCurrentPlayer();
            return winner;
        }

        adjustCurrentPlayer();
        return true;

    }

    public boolean wrongAnswer(){
        System.out.println("Question was incorrectly answered");
        System.out.println(players.get(currentPlayer)+ " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        adjustCurrentPlayer();
        return true;
    }


    public void add(String playerName) {

        players.add(playerName);
        places[howManyPlayers()] = 0;
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());

    }

    public int howManyPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        System.out.println(players.get(currentPlayer) + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (!inPenaltyBox[currentPlayer]) {
            changeLocationAndCategory(roll);
            return;
        }

        isGettingOutOfPenaltyBox = roll % 2 != 0;
        if (!isGettingOutOfPenaltyBox) {
            System.out.println(players.get(currentPlayer) + " is not getting out of the penalty box");
            return;
        }

        System.out.println(players.get(currentPlayer) + " is getting out of the penalty box");
        changeLocationAndCategory(roll);

    }

    private void changeLocationAndCategory(int roll) {
        places[currentPlayer] = places[currentPlayer] + roll;
        if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

        System.out.println(players.get(currentPlayer)
                + "'s new location is "
                + places[currentPlayer]);
        System.out.println("The category is " + currentCategory());
        questionHandler.askQuestion(currentCategory());
    }


    private String currentCategory() {
        return switch (places[currentPlayer]) {
            case 0, 4, 8 -> "Pop";
            case 1, 5, 9 -> "Science";
            case 2, 6, 10 -> "Sports";
            default -> "Rock";
        };
    }

    private void adjustCurrentPlayer() {
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
    }


    private boolean didPlayerWin() {
        return !(purses[currentPlayer] == 6);
    }
}
