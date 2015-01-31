package ch2.stringLogs;

import java.util.Scanner;

public class ITDArrayStringLog {
	public static void main(String[] args) {
		ArrayStringLog log = new ArrayStringLog("Testing");
		Scanner conIn = new Scanner(System.in);
		String skip;
		boolean keepGoing;
		int constructor;
		int operation;
		
		System.out.println("What is the name of this test?");
		String testName = conIn.nextLine();
		System.out.println("\nThis is test "+testName+"\n");
		
		System.out.println("Choose a constructor:");
		System.out.println("1: ArrayStringLog(String name)");
		System.out.println("2: ArrayStringLog(String name, int maxSize)");
		if(conIn.hasNextInt())  //스트림의 값이 정수인지 판별
			constructor = conIn.nextInt();
		else{
			System.out.println("Error: you must enter an integer.");
			System.out.println("Terminating test.");
			return;
		}
			skip = conIn.nextLine();  //줄바꿈 때문에 한건가? 공백이 입력된다.
			switch(constructor){
			case 1:
				log = new ArrayStringLog(testName);
				break;
			case 2:
				System.out.println("Enter a maximum size:");
				int maxSize;
				if(conIn.hasNextInt())
					maxSize=conIn.nextInt();
				else{
					System.out.println("Error: you must enter an integer.");
					System.out.println("Terminating test.");
					return;
				}
				skip = conIn.nextLine();
				log = new ArrayStringLog(testName,maxSize);
				break;
				
				default:
					System.out.println("Error in constructor choice. Terminating test.");
					return;
			}
			
			keepGoing = true;
			while(keepGoing){
				System.out.println("\nChoose an operation");
				System.out.println("1: insert(String element)");
				System.out.println("2: clear()");
				System.out.println("3: contains(String element)");
				System.out.println("4: isFull()");
				System.out.println("5: size()");
				System.out.println("6: getName()");
				System.out.println("7: show contents");
				System.out.println("8: stop testing");
				if(conIn.hasNextInt())
					operation = conIn.nextInt();
				else{
					System.out.println("Error: you must enter an integer.");
					System.out.println("Terminating test.");
					return;
				}
				skip = conIn.nextLine();
				switch(operation){
				case 1:  //insert
					System.out.println("Enter string to insert:");
					String insertString = conIn.nextLine();
					log.insert(insertString);
					break;
				case 2:  //clear
					log.clear();
					break;
				case 3:  //contains
					System.out.println("Enter string to search for:");
					String searchString = conIn.nextLine();
					System.out.println("Result: "+log.contains(searchString));
					break;
				case 4:  //isFull
					System.out.println("Result: "+log.isFull());
					break;
				case 5:  //size
					System.out.println("Result: "+log.size());
					break;
				case 6:  //getName
					System.out.println("Result: "+log.getName());
					break;
				case 7:  //show contents
					System.out.println(log.toString());
					break;
				case 8:  //stop testing
					keepGoing = false;
					break;
					default:
						System.out.println("Error in operation choice. Terminating test.");
						return;			
				}				
			}
			System.out.println("End of Interactive Test Driver");		
	}
}
