package ch6.lists;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import support.Song;

public class SaveSong {
	private static PrintWriter outFile;
	public static void main(String[] args) throws IOException {
		Song song = new Song("Penny Lane",2,57);
		
		outFile = new PrintWriter(new FileWriter("song.txt"));
		outFile.println(song.getName());
		outFile.println(song.getDuration());
		outFile.close();
	}	
}
