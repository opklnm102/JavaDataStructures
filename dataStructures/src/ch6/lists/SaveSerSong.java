package ch6.lists;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class SaveSerSong {
	private static PrintWriter outFile;
	public static void main(String[] args) throws IOException {
		SerSong song =new SerSong("Penny Lane",2,57);
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("song.txt"));
		
		out.writeObject(song);
		out.close();	
	}
}
