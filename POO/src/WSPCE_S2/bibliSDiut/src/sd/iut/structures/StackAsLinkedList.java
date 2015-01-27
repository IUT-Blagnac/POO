package sd.iut.structures;

public class StackAsLinkedList<E> extends Stack<E> {

	private sd.iut.implementations.LinkedList<E> theRealStack;
	
	/**
	 * A faire
	 */
	public StackAsLinkedList () {
		this.theRealStack = new sd.iut.implementations.LinkedList<E>();
	}
	
	@Override
	public E peek() {
		return theRealStack.getLast();
	}

	@Override
	public void push(E e) {
		this.theRealStack.addLast(e);
		
	}

	@Override
	public E pop() {
		return this.theRealStack.removeLast();
	}

	@Override
	public int size() {
		return this.theRealStack.size();
	} 

}
