package ch2.trivia;

import java.io.IOException;
import java.util.Scanner;

public class TriviaConsole {
	public static void main(String[] args) throws IOException {
		Scanner conIn = new Scanner(System.in);

		TriviaGame game;

		int questionNum;
		TriviaQuestion tq;
		String answer;

		game = GetTriviaGame.useTextFile("game.txt");

		System.out.println("Welcome to the" + game.getQuizName()
				+ "trivia quiz.");
		System.out
				.println("You will have " + game.getNumChances() + " chances");
		System.out.println("to answer " + game.getCurrNumQuestionsO()
				+ "question.\n");

		questionNum = 0;

		while (!game.isOver()) {
			do {
				if (questionNum == game.getCurrNumQuestionsO())
					questionNum = 1;
				else
					questionNum = questionNum + 1;
			} while (game.isAnswered(questionNum));

			tq = game.getTriviaQuestion(questionNum);
			System.out.println(tq.getCategory() + " : " + tq.getQuestion());
			answer = conIn.nextLine();

			if (tq.tryAnswer(answer)) {
				System.out.println("Correct!\n");
				game.correctAnswer(questionNum);
			} else {
				System.out.println("Incorrect\n");
				game.incorrectAnswer();
			}
		}
		System.out.println("\n Game Over");
		System.out.println("\n Results");
		System.out.println("Chances used: "
				+ (game.getNumChances() - game.getRemainingChances()));
		System.out.println("Number Correct: " + game.getNumCorrect());
		System.out.println("\n Thank you.\n");
	}
}
