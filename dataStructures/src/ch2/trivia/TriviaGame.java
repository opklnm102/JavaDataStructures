package ch2.trivia;

public class TriviaGame {
	private String quizName;
	private int maxNumQuestions;
	private int numChances;
	private int remainingChances;
	private int numCorrect = 0;
	private int numIncorrect = 0;
	private TriviaQuestion[] questions;  //the set of questions
	private boolean[] correct;  //true if corresponding
	private int currNumQuestions = 0;  //question answered correctly
	
	public TriviaGame(String quizName, int maxNumQuestions, int numChances){
		this.quizName = quizName;
		this.maxNumQuestions = maxNumQuestions;
		this.numChances = numChances;
		remainingChances = numChances;
		questions = new TriviaQuestion[maxNumQuestions];
		correct = new boolean[maxNumQuestions];		
	}
	
	public String getQuizName(){
		return quizName;
	}
	
	public int getNumChances(){
		return numChances;
	}
	
	public int getRemainingChances(){
		return remainingChances;
	}
	
	public int getNumCorrect(){
		return numCorrect;
	}
	
	public int getNumIncorrect(){
		return numIncorrect;		
	}
	
	public int getCurrNumQuestionsO(){
		return currNumQuestions;
	}
	
	public TriviaQuestion getTriviaQuestion(int questionNumber){
		return questions[questionNumber -1];
	}
	
	public boolean isAnswered(int questionNumber){
		return correct[questionNumber -1];
	}
	
	public boolean isOver(){
		return (numCorrect == currNumQuestions) || (remainingChances <= 0);
	}
	
	public void insertQuestion(TriviaQuestion question){
		questions[currNumQuestions] = question;
		correct[currNumQuestions] = false;
		currNumQuestions = currNumQuestions + 1;
	}
	
	public void correctAnswer(int questionNumber){
		correct[questionNumber -1] = true;
		numCorrect = numCorrect +1;
		remainingChances = remainingChances -1;
	}
	
	public void incorrectAnswer(){
		numIncorrect = numIncorrect+1;
		remainingChances = remainingChances -1;
	}
}
