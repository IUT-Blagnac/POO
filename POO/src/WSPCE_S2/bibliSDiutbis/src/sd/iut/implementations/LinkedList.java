
package sd.iut.implementations;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * Linked list implementation of the <tt>List</tt> interface.  Implements all
 * optional list operations, and permits all elements (including
 * <tt>null</tt>).  In addition to implementing the <tt>List</tt> interface,
 * the <tt>LinkedList</tt> class provides uniformly named methods to
 * <tt>get</tt>, <tt>remove</tt> and <tt>insert</tt> an element at the
 * beginning and end of the list.  These operations allow linked lists to be
 * used as a stack, {@linkplain Queue queue}, or {@linkplain Deque
 * double-ended queue}. <p>
 *
 * The class implements the <tt>Deque</tt> interface, providing
 * first-in-first-out queue operations for <tt>add</tt>,
 * <tt>poll</tt>, along with other stack and deque operations.<p>
 *
 * All of the operations perform as could be expected for a doubly-linked
 * list.  Operations that index into the list will traverse the list from
 * the beginning or the end, whichever is closer to the specified index.<p>
 *
 * <p><strong>Note that this implementation is not synchronized.</strong>
 * If multiple threads access a linked list concurrently, and at least
 * one of the threads modifies the list structurally, it <i>must</i> be
 * synchronized externally.  (A structural modification is any operation
 * that adds or deletes one or more elements; merely setting the value of
 * an element is not a structural modification.)  This is typically
 * accomplished by synchronizing on some object that naturally
 * encapsulates the list.
 *
 * If no such object exists, the list should be "wrapped" using the
 * {@link Collections#synchronizedList Collections.synchronizedList}
 * method.  This is best done at creation time, to prevent accidental
 * unsynchronized access to the list:<pre>
 *   List list = Collections.synchronizedList(new LinkedList(...));</pre>
 *
 * <p>The iterators returned by this class's <tt>iterator</tt> and
 * <tt>listIterator</tt> methods are <i>fail-fast</i>: if the list is
 * structurally modified at any time after the iterator is created, in
 * any way except through the Iterator's own <tt>remove</tt> or
 * <tt>add</tt> methods, the iterator will throw a {@link
 * ConcurrentModificationException}.  Thus, in the face of concurrent
 * modification, the iterator fails quickly and cleanly, rather than
 * risking arbitrary, non-deterministic behavior at an undetermined
 * time in the future.
 *
 * <p>Note that the fail-fast behavior of an iterator cannot be guaranteed
 * as it is, generally speaking, impossible to make any hard guarantees in the
 * presence of unsynchronized concurrent modification.  Fail-fast iterators
 * throw <tt>ConcurrentModificationException</tt> on a best-effort basis.
 * Therefore, it would be wrong to write a program that depended on this
 * exception for its correctness:   <i>the fail-fast behavior of iterators
 * should be used only to detect bugs.</i>
 *
 * <p>This class is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @author  Josh Bloch
 * @version %I%, %G%
 * @see	    List
 * @see	    ArrayList
 * @see	    Vector
 * @since 1.2
 * @param <E> the type of elements held in this collection
 */

public class LinkedList<E> {
    
    private java.util.LinkedList<E> theRealLinkedList;

    /**
     * Constructs an empty list.
     */
    public LinkedList() {
        this.theRealLinkedList = new java.util.LinkedList<E> ();
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param  c the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public LinkedList(LinkedList<E> lle) {
    	this();
    	this.addEndAll(lle);
    }

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     * @throws NoSuchElementException if this list is empty
     */
    public E getFirst() {
    	return this.theRealLinkedList.getFirst();
    }

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     * @throws NoSuchElementException if this list is empty
     */
    public E getLast()  {
    	return this.theRealLinkedList.getLast();
    }

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     * @throws NoSuchElementException if this list is empty
     */
    public E removeFirst() {
    	return this.theRealLinkedList.removeFirst();
    }

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     * @throws NoSuchElementException if this list is empty
     */
    public E removeLast() {
    	return this.theRealLinkedList.removeLast();
    }

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param e the element to add
     */
    public void addFirst(E e) {
    	this.theRealLinkedList.addFirst(e);
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * <p>This method is equivalent to {@link #add}.
     *
     * @param e the element to add
     */
    public void addLast(E e) {
    	this.theRealLinkedList.addLast(e);
    }

     /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
    	return this.theRealLinkedList.size();
    }


    /**
     * Appends all of the elements in the specified list to the end of
     * this list, in the order that they are in the specified
     * list. The behavior of this operation is undefined if
     * the specified list is modified while the operation is in
     * progress.  (Note that this will occur if the specified list is
     * this list, and it's nonempty.)
     *
     * @param lle list containing elements to be added to this list
     * @throws NullPointerException if the specified list is null
     */
    public void addEndAll(LinkedList<E> lle) {
    	Iterator<E> lite;
    	lite = lle.iterator();
    	while (lite.hasNext()) {
    		this.theRealLinkedList.addLast(lite.next());
    	}
    }

    /**
     * TODO
     */
    public void addBeginAll(LinkedList<E> lle) {
    	Iterator<E> lite;
    	lite = lle.descendingIterator();
    	while (lite.hasNext()) {
    		this.theRealLinkedList.addFirst(lite.next());
    	} 
    }

    /**
     * Removes all of the elements from this list.
     */
    public void clear() {
        this.theRealLinkedList.clear();
    }


    /** 
     * A faire ?
     * 
     */
    public ListIterator<E> listIterator() {
        return this.theRealLinkedList.listIterator();
    }
    
    /**
     * A faire ?
     * 
     * 
     */
    public Iterator<E> descendingIterator() {
        return this.theRealLinkedList.descendingIterator();
    }

    /**
     * A faire ?
     * 
     * 
     */
    public Iterator<E> iterator() {
        return this.theRealLinkedList.iterator();
    }

    
    /**
     * Returns an array containing all of the elements in this list in
     * proper sequence (from first to last element); the runtime type of
     * the returned array is that of the specified array.  If the list fits
     * in the specified array, it is returned therein.  Otherwise, a new
     * array is allocated with the runtime type of the specified array and
     * the size of this list.
     *
     * <p>If the list fits in the specified array with room to spare (i.e.,
     * the array has more elements than the list), the element in the array
     * immediately following the end of the list is set to <tt>null</tt>.
     * (This is useful in determining the length of the list <i>only</i> if
     * the caller knows that the list does not contain any null elements.)
     *
     * <p>Like the {@link #toArray()} method, this method acts as bridge between
     * array-based and collection-based APIs.  Further, this method allows
     * precise control over the runtime type of the output array, and may,
     * under certain circumstances, be used to save allocation costs.
     *
     * <p>Suppose <tt>x</tt> is a list known to contain only strings.
     * The following code can be used to dump the list into a newly
     * allocated array of <tt>String</tt>:
     *
     * <pre>
     *     String[] y = x.toArray(new String[0]);</pre>
     *
     * Note that <tt>toArray(new Object[0])</tt> is identical in function to
     * <tt>toArray()</tt>.
     *
     * @param a the array into which the elements of the list are to
     *          be stored, if it is big enough; otherwise, a new array of the
     *          same runtime type is allocated for this purpose.
     * @return an array containing the elements of the list
     * @throws ArrayStoreException if the runtime type of the specified array
     *         is not a supertype of the runtime type of every element in
     *         this list
     * @throws NullPointerException if the specified array is null
     */
    public E[] toArray(E[] a) {
    	return this.theRealLinkedList.toArray(a);
    }
}
