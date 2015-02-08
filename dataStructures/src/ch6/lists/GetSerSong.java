package ch6.lists;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GetSerSong {
	public static void main(String[] args) throws IOException {
		SerSong song;
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("song.dat"));
		
		try{
			song = (SerSong)in.readObject();
			System.out.println("The name of the song is " + song.getName());
			System.out.println("The duration of the song is " + song.getDuration());
		}
		catch(Exception e){
			System.out.println("Error in readObject: " + e);
			System.exit(1);
		}
	}
}