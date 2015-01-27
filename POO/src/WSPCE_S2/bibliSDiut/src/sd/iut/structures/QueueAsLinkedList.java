package sd.iut.structures;

import java.util.NoSuchElementException;

public class QueueAsLinkedList<E> extends Queue<E> {

	private sd.iut.implementations.LinkedList<E> theRealStack;

	/**
	 * A faire
	 * @param maxSize
	 */
	public QueueAsLinkedList (int maxSize) {
		super (maxSize);
		this.maximumSize = maxSize;
		this.actualSize = 0;
		this.theRealStack = new sd.iut.implementations.LinkedList<E> ();
	}
	
	@Override
	public void add(E e)  {
		if (this.isFull()) {
			throw new IllegalStateException("The Queue " + this +" is full when adding " + e);
		}
		if (e==null) {
			throw new NullPointerException("null encountred when adding in the Queue " + this);
		}
		this.theRealStack.addFirst(e);
		this.actualSize++;
	}

	@Override
	public boolean offer(E e) {
		boolean result;
		result = false;
		try {
			this.add(e);
			result = true;
		}
		catch(IllegalStateException ise) {
			result = false;
		}
		return result;
	}

	@Override
	public E remove() {
		E element;
		if (this.isEmpty()) {
			throw new NoSuchElementException("The Queue " + this +" is empty when attempting to remove.");
		}
		element = this.theRealStack.removeLast();
		this.actualSize--;
		return element;
	}

	@Override
	public E poll() {
		E element;
		element = null;
		try {
			element = this.remove();
		}
		catch (NoSuchElementException npe) {
			element = null;
		}
		return element;
	}

	@Override
	public E element() {
		E element;
		if (this.isEmpty()) {
			throw new NoSuchElementException("The Queue " + this +" is empty when attempting to get.");
		}
		element = this.theRealStack.getLast();
		return element;
	}

	@Override
	public E peek(){
		E element;
		element = null;
		try {
			element = this.element();
		}
		catch (NoSuchElementException npe) {
			element = null;
		}
		return element;
	}
}
