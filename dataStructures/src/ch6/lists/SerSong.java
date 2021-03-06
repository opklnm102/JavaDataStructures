package ch6.lists;

import java.io.Serializable;
import java.text.DecimalFormat;
//음반 클래스의 직렬화 가능한 버전
public class SerSong implements Serializable{
	protected String name;
	protected int duration;
	DecimalFormat fmt = new DecimalFormat("00");
	
	public SerSong(String name, int seconds) {
		this.name =name;
		this.duration = seconds;
	}
	
	public SerSong(String name, int minutes, int seconds){
		this.name = name;
		duration = (60 * minutes) + seconds;
	}
	
	public String getName(){
		return name;
	}
	
	public int getDuration(){
		return duration;
	}
	
	public String toString(){
		return (name + " " + (duration /60) + ":" + fmt.format(duration%60));
	}
}
