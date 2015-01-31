package ch2.trivia;

import ch2.stringLogs.ArrayStringLog;
import ch2.stringLogs.StringLogInterface;

public class TriviaQuestion {
	private String category;  //category of question
	private String question;  //the question
	private StringLogInterface answers;  //acceptable answers
	
	public TriviaQuestion(String category, String question, int maxNumAnswers){
		this.category = category;
		this.question = question;
		answers = new ArrayStringLog("trivia", maxNumAnswers);
	}
	
	public String getCategory(){
		return category;
	}
	
	public String getQuestion(){
		return question;
	}
	
	public boolean tryAnswer(String answer){
		return answers.contains(answer);
	}
	
	public void storeAnswer(String answer){
		answers.insert(answer);
	}

}
