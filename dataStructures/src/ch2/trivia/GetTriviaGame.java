package ch2.trivia;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GetTriviaGame {
	public static TriviaGame useTextFile(String textfile) throws IOException{
		TriviaGame game;
		String quizNum;
		int numQuestions;
		int numChances;
		
		TriviaQuestion tq;
		String category;
		String question;
		String answer;
		int numAnswers;
		
		FileReader fin = new FileReader(textfile);
		Scanner triviaIn = new Scanner(fin);
		String skip;  //skip end of line after reading integer
		
		quizNum = triviaIn.nextLine();
		numQuestions = triviaIn.nextInt();
		numChances = triviaIn.nextInt();
		skip = triviaIn.nextLine();
		
		game = new TriviaGame(quizNum, numQuestions, numChances);
		
		for(int i=1; i<=numQuestions; i++){
			category = triviaIn.nextLine();
			question = triviaIn.nextLine();
			numAnswers = triviaIn.nextInt();
			skip = triviaIn.nextLine();
			tq = new TriviaQuestion(category, question, numAnswers);
			for(int j=1; j<=numAnswers; j++){
				answer = triviaIn.nextLine();
				tq.storeAnswer(answer);
			}
			game.insertQuestion(tq);			
		}
		return game;
	}
}
