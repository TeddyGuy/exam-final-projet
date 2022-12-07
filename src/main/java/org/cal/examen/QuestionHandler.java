package org.cal.examen;

import java.util.Deque;
import java.util.LinkedList;

public class QuestionHandler {

    final int MAX_NUMBER_OF_QUESTIONS = 50;

    Deque<String> popQuestions = new LinkedList<>();
    Deque<String> scienceQuestions = new LinkedList<>();
    Deque<String> sportsQuestions = new LinkedList<>();
    Deque<String> rockQuestions = new LinkedList<>();

    public QuestionHandler () {
        initQuestions();
    }

    private void initQuestions() {
        for (int i = 0; i < MAX_NUMBER_OF_QUESTIONS; i++) { // Magic Number
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast("Rock Question " + i);
        }
    }

    protected void askQuestion(String category) {
        switch (category) {
            case "Pop" -> System.out.println(popQuestions.removeFirst());
            case "Science" -> System.out.println(scienceQuestions.removeFirst());
            case "Sports" -> System.out.println(sportsQuestions.removeFirst());
            case "Rock" -> System.out.println(rockQuestions.removeFirst());
        }
    }
}
