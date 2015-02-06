package ch5.queues;

import support.LLObjectNode;

public class LinkedUnbndQueue implements UnboundedQueueInterface {

	protected LLObjectNode front; // 큐의 앞 지시자에 대한 참조
	protected LLObjectNode rear; // 큐의 뒤 지시자에 대한 참조

	public LinkedUnbndQueue() {
		front = null;
		rear = null;
	}

	@Override
	public Object dequeue() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException(
					"Dequeue attempted on empty queue.");
		else {
			Object element;
			element = front.getInfo();
			front = front.getLink();
			if (front == null)
				rear = null;
			return element;
		}
	}

	@Override
	public boolean isEmpty() {
		if(front == null)
			return true;
		else
			return false;
	}

	@Override
	public void enqueue(Object element) {
		LLObjectNode newNode = new LLObjectNode(element);
		if (rear == null)
			front = newNode;
		else
			rear.setLink(newNode);
		rear = newNode;
	}

}
