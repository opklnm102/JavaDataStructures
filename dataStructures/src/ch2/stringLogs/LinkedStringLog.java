package ch2.stringLogs;

public class LinkedStringLog implements StringLogInterface {
	protected LLStringNode log; // reference to first node of linked
								// list that holds the StringLog strings
	protected String name; // name of this StringLog

	public LinkedStringLog(String name) {
		log = null;
		this.name = name;
	}

	@Override
	public void insert(String element) {
		LLStringNode newNode = new LLStringNode(element);
		newNode.setLink(log);
		log = newNode;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public int size() {
		int count = 0;
		LLStringNode node;
		node = log;

		while (node != null) {
			count++;
			node = node.getLink();
		}
		return count;
	}

	@Override
	public boolean contains(String element) {
		LLStringNode node;
		node = log;
		boolean found = false;
		boolean moreToSearch;
		moreToSearch = (node != null);

		while (moreToSearch && !found) {
			if (element.equalsIgnoreCase(node.getInfo())) {
				found = true;
			}
			else{
				node = node.getLink();
				moreToSearch = (node != null);
			}			
		}		
		return found;
	}

	@Override
	public void clear() {
		log = null;

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		String logString = "Log: " + name + "\n\n";
		LLStringNode node;
		node = log;
		int count = 0;
		
		while(node != null){
			count++;
			logString = logString + count + ". " + node.getInfo() + "\n";
			node = node.getLink();
		}
		return logString;
	}
}
