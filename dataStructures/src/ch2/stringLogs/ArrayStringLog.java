package ch2.stringLogs;

public class ArrayStringLog implements StringLogInterface{
	protected String name;  
	protected String[] log;
	protected int lastIndex = -1;
	
	public ArrayStringLog(String name, int maxSize) {	
		log = new String[maxSize];
		this.name = name;
	}
	
	public ArrayStringLog(String name) {		
		log = new String[100];
		this.name = name;
	}
		
	@Override
	public void insert(String element) {
		lastIndex++;
		log[lastIndex] = element;
		
	}

	@Override
	public boolean isFull() {
		if(lastIndex == (log.length-1))
			return true;
		else
			return false;
	}

	@Override
	public int size() {
		return (lastIndex+1);
	}

	@Override
	public boolean contains(String element) {
		boolean moreToSearch;
		int location=0;
		boolean found=false;
		moreToSearch=(location<=lastIndex);
		
		while(moreToSearch && !found){
			if(element.equalsIgnoreCase(log[location]))  //대소문자 관계없는 equals
				found = true;
			else{
				location++;
				moreToSearch = (location <= lastIndex);
				}
			}		
		return found;
	}

	@Override
	public void clear() {
		for(int i =0; i<=lastIndex; i++)
			log[i]=null;
		lastIndex = -1;		
	}

	@Override
	public String getName() {
		return name;
		
	}
	
	@Override
	public String toString(){
		String logString = "Log: " + name + "\n\n";
		
		for(int i=0; i<=lastIndex; i++)
			logString = logString +(i+1) + ". " + log[i] + "\n";
		
		return logString;
	}
	
	
	
	

}
