package support;

public class Golfer implements Comparable {
	protected String name;
	protected int score;
	
	public Golfer(String name, int score) {
		this.name = name;
		this.score = score;		
	}
	
	public String getName(){
		return name;
	}
	
	public int getScore(){
		return score;
	}
	
	public int compareTo(Object other){
		if(this.score < ((Golfer)other).score)
			return -1;
		else
			if(this.score == ((Golfer)other).score)
				return 0;
			else
				return +1;
	}
	
	public String toString(){
		return (score + ": " + name);
	}
}
