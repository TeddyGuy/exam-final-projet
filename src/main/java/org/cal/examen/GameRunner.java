package org.cal.examen;

import java.util.Random;

public class GameRunner {

    private static boolean notAWinner;
    private static int MAX_ROLL_VALUE = 6;
    private static int MIN_ROLL_VALUE = 1;



    public static void main(String[] args) {
        Game aGame = new Game();

        aGame.add("Mathieu");
        aGame.add("Samir");
        aGame.add("Manolo");

        Random rand = new Random();

        do {

            aGame.roll(rand.nextInt(MIN_ROLL_VALUE, MAX_ROLL_VALUE)); //Magic Number

            if (rand.nextBoolean()) {
                notAWinner = aGame.wrongAnswer();
                continue;
            }

            notAWinner = aGame.wasCorrectlyAnswered();

        } while (notAWinner);

    }
}
