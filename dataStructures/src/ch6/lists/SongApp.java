package ch6.lists;

import java.text.DecimalFormat;
import java.util.Scanner;

import support.Song;

public class SongApp {
	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);

		String name;
		int minutes;
		int seconds;
		int number;
		int numSongs = 0;
		int totTime = 0;

		DecimalFormat fmt = new DecimalFormat("00");

		ArrayIndexedList songList = new ArrayIndexedList(20);
		Song song;

		String skip;

		System.out.print("Song name(press Enter to end): ");
		name = sin.nextLine();
		while (!name.equals("")) {
			System.out.print("Minutes: ");
			minutes = sin.nextInt();
			skip = sin.nextLine();
			System.out.print("Seconds: ");
			seconds = sin.nextInt();
			skip = sin.nextLine();
			totTime = totTime + (minutes * 60) + seconds;

			song = new Song(name, minutes, seconds);

			System.out.print("Song number between 0 nad " + songList.size()
					+ ": ");
			number = sin.nextInt();
			skip = sin.nextLine();
			songList.add(number, song);
			System.out.println();
			System.out.println(songList);
			System.out.println("Total Time: " + (totTime / 60) + ":"
					+ fmt.format(totTime % 60));
			System.out.println();
			System.out.print("Song name (press Enter to end): ");
			name = sin.nextLine();
		}
		System.out.println();
		System.out.println("The final result is \n");
		System.out.println(songList);
		System.out.println("Total Time: " + (totTime / 60) + ":"
				+ fmt.format(totTime % 60));
		System.out.println();
	}
}
