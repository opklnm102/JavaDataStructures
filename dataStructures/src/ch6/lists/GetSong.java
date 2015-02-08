package ch6.lists;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import support.Song;

public class GetSong {
	public static void main(String[] args) throws IOException {
		String name;
		int duration;
		FileReader fin = new FileReader("song.txt");
		Scanner songIn = new Scanner(fin);
		name = songIn.nextLine();
		duration = songIn.nextInt();
		Song song = new Song(name, duration);
		System.out.println("The name of the song is " + song.getName());
		System.out.println("The duration of the song is " + song.getDuration());
	}
}
