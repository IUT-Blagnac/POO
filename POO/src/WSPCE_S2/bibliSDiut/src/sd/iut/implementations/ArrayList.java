

package sd.iut.implementations;

import java.util.Iterator;
import java.util.ListIterator;


/**
 * Resizable-array implementation of the data structures.  Implements
 * list operations, and permits all elements, including
 * <tt>null</tt>.  In addition, this class provides methods 
 * to manipulate the size of the array that is
 * used internally to store the list.
 * 
 * The <tt>size</tt>, <tt>isEmpty</tt>, <tt>get</tt>, <tt>set</tt>,
 * <tt>iterator</tt>, and <tt>listIterator</tt> operations run in constant
 * time.  The <tt>add</tt> operation runs in <i>amortized constant time</i>,
 * that is, adding n elements requires O(n) time.  All of the other operations
 * run in linear time (roughly speaking).
 *
 * Each <tt>ArrayList</tt> instance has a <i>capacity</i>.  The capacity is
 * the size of the array used to store the elements in the list.  It is always
 * at least as large as the list size.  As elements are added to an ArrayList,
 * its capacity grows automatically.  The details of the growth policy are not
 * specified beyond the fact that adding an element has constant amortized
 * time cost.<p>
 *
 * An application can increase the capacity of an <tt>ArrayList</tt> instance
 * before adding a large number of elements using the <tt>ensureCapacity</tt>
 * operation.  This may reduce the amount of incremental reallocation.
 *
 * <p><strong>Note that this implementation is not synchronized.</strong>
 * If multiple threads access an <tt>ArrayList</tt> instance concurrently,
 * and at least one of the threads modifies the list structurally, it
 * <i>must</i> be synchronized externally.  (A structural modification is
 * any operation that adds or deletes one or more elements, or explicitly
 * resizes the backing array; merely setting the value of an element is not
 * a structural modification.)  This is typically accomplished by
 * synchronizing on some object that naturally encapsulates the list.
 *
 * If no such object exists, the list should be "wrapped" using the
 * {@link Collections#synchronizedList Collections.synchronizedList}
 * method.  This is best done at creation time, to prevent accidental
 * unsynchronized access to the list:<pre>
 *   List list = Collections.synchronizedList(new ArrayList(...));</pre>
 *
 * <p>The iterators returned by this class's <tt>iterator</tt> and
 * <tt>listIterator</tt> methods are <i>fail-fast</i>: if the list is
 * structurally modified at any time after the iterator is created, in any way
 * except through the iterator's own <tt>remove</tt> or <tt>add</tt> methods,
 * the iterator will throw a {@link ConcurrentModificationException}.  Thus, in
 * the face of concurrent modification, the iterator fails quickly and cleanly,
 * rather than risking arbitrary, non-deterministic behavior at an undetermined
 * time in the future.<p>
 *
 * Note that the fail-fast behavior of an iterator cannot be guaranteed
 * as it is, generally speaking, impossible to make any hard guarantees in the
 * presence of unsynchronized concurrent modification.  Fail-fast iterators
 * throw <tt>ConcurrentModificationException</tt> on a best-effort basis.
 * Therefore, it would be wrong to write a program that depended on this
 * exception for its correctness: <i>the fail-fast behavior of iterators
 * should be used only to detect bugs.</i><p>
 *
 * This class is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @author  IUT Blagnac
 * @version 1.0
 */

public class ArrayList<E>   
{
    private java.util.ArrayList<E> theRealArrayList;

    /**
     * Constructs an empty list with an initial capacity of <tt>initialCapacity</tt>.
     * 
     * @param	initialCapacity	Initial capacity of the list.
     */
    public ArrayList(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);

        this.theRealArrayList = new java.util.ArrayList<E> (initialCapacity);
    }

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public ArrayList() {
    	this(5);
    }

    /**
     * Constructs a list containing the elements of the specified
     * <tt>ArrayList</tt>.
     *
     * @param ale the list whose elements are to be placed into this list
     * @throws NullPointerException if the specified list is null
     */
    public ArrayList(ArrayList<E> ale) {
    	this();
    	this.addAll(ale);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
    	return this.theRealArrayList.size();
    }

    /**
     * Returns <tt>true</tt> if this list contains no elements.
     *
     * @return <tt>true</tt> if this list contains no elements
     */
    public boolean isEmpty() {
    	return this.theRealArrayList.isEmpty();
    }

    /**
     * Returns <tt>true</tt> if this list contains the specified element.
     * More formally, returns <tt>true</tt> if and only if this list contains
     * at least one element <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     *
     * @param o element whose presence in this list is to be tested
     * @return <tt>true</tt> if this list contains the specified element
     */
    public boolean contains(Object o) {
    	return this.theRealArrayList.contains(o);
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the lowest index <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
     * or -1 if there is no such index.
     */
    public int indexOf(Object o) {
    	return this.theRealArrayList.indexOf(o);
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the highest index <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
     * or -1 if there is no such index.
     */
    public int lastIndexOf(Object o) {
    	return this.theRealArrayList.lastIndexOf(o);
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element); the runtime type of the returned
     * array is that of the specified array.  If the list fits in the
     * specified array, it is returned therein.  Otherwise, a new array is
     * allocated with the runtime type of the specified array and the size of
     * this list.
     *
     * <p>If the list fits in the specified array with room to spare
     * (i.e., the array has more elements than the list), the element in
     * the array immediately following the end of the collection is set to
     * <tt>null</tt>.  (This is useful in determining the length of the
     * list <i>only</i> if the caller knows that the list does not contain
     * any null elements.)
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
        return this.theRealArrayList.toArray(a);
    }

    // Positional Access Operations

    /**
     * Returns the element at the specified position in this list.
     *
     * @param  index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if index is not valid : ! (0<=index<size())
     */
    public E elementAt(int index) {
		return this.theRealArrayList.get(index);
    }

    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if index is not valid : ! (0<=index<size())
     */
    public E setElementAt(int index, E element) {
    	return this.theRealArrayList.set(index, element);
    }

    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if index is not valid : ! (0<=index<=size())
     */
    public void inserElementAt(int index, E element) {
    	this.theRealArrayList.add(index, element);
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param e element to be appended to this list
     */
    public void add(E e) {
		this.theRealArrayList.add(e);
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if index is not valid : ! (0<=index<size())
     */
    public E removeElementAt(int index) {
		return this.theRealArrayList.remove(index);
    }

    /**
     * Removes the firt occurrence of <tt>element</tt> in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param element the element to be removed
     * @return true if <tt>element</tt> is found, false otherwise 
     * @throws IndexOutOfBoundsException if index is not valid : ! (0<=index<size())
     */
    public boolean remove(E element) {
    	boolean found; 
    	int index = this.indexOf(element);
    	found = false;
    	if (index != -1) {
    		this.removeElementAt(index);
    		found = true;
    	}
		return found;
    }

    /**
     * Empty this list of all is elements.
     * Next to clear(), size() will always return 0.
     */
    public void clear() {
    	this.theRealArrayList.clear();
    }

    /**
     * Appends all of the elements in the specified list to the end of
     * this list, in the order that they are in the specified list.
     * The behavior of this operation is
     * undefined if the specified list is modified while the operation
     * is in progress.  (This implies that the behavior of this call is
     * undefined if the specified list is this list, and this
     * list is nonempty.)
     *
     * @param ale <tt>ArrayList</tt> containing elements to be added to this list
     * @return <tt>true</tt> if this list changed as a result of the call
     * @throws NullPointerException if the specified list is null
     */
    public void addAll(ArrayList<E> ale) {
    	this.addAll(0, ale);
    }

    /**
     * Inserts all of the elements in the specified list into this
     * list, starting at the specified position.  Shifts the element
     * currently at that position (if any) and any subsequent elements to
     * the right (increases their indices).  The new elements will appear
     * in the list in the order that in the specified list.
     * The behavior of this operation is
     * undefined if the specified list is modified while the operation
     * is in progress.  (This implies that the behavior of this call is
     * undefined if the specified list is this list, and this
     * list is nonempty.)
     * 
     * @param index index at which to insert the first element from the
     *              specified list
     * @param ale list containing elements to be added to this list
     * @return <tt>true</tt> if this list changed as a result of the call
     * @throws IndexOutOfBoundsException if index is not valid : ! (0<=index<=size())
     * @throws NullPointerException if the specified list is null
     */
    public void addAll(int index, ArrayList<E> ale) {
    	for (int i=0; i<ale.size(); i++)
    		this.theRealArrayList.add(index+i, ale.elementAt(i));
    	
    }

    /** 
     * A faire ?
     * @return
     */
	public Iterator<E> iterator() {
		return this.theRealArrayList.iterator();
	}

	/**
	 * A faire ?
	 * @return
	 */
	public ListIterator<E> listIterator() {
		return this.theRealArrayList.listIterator();
	}

    /**
     * Removes from this list all the elements of the specified list.
     * Shifts any subsequent elements to the left.
     * Is equivalent to a remove(element) for all the elements
     * of the specified list. 
     *
     * @param ale	the list of the elements to remove
     * @return true if this list is modified as a result of the operation 
     */
	public boolean removeAll(ArrayList<E> ale) {
		boolean found;
		found = false;
		for (int i=0; i<ale.size(); i++)
			found = (this.remove(ale.elementAt(i)) ? true : false);
		return found;
	}

	/**
	 * Constructs a sublist of this list.
	 * The new list contains all elements of this list
	 * whose indexes are between <tt>fromIndex</tt> to <tt>toIndex</tt>
	 * @param fromIndex	index of the first element of the required sublist
	 * @param toIndex	index of the last element of the required sublist
	 * @return	a new <tt>ArrayList</tt> containing the elements.
	 * @throws IndexOutOfBoundsException if fromIndex is not valid : ! (0<=fromIndex<size())
	 * @throws IndexOutOfBoundsException if toIndex is not valid : ! (0<=toIndex<size())
	 * @throws IllegalArgumentException	if the endpoint indices are out of order (fromIndex > toIndex)
	 */
	public ArrayList<E> subList(int fromIndex, int toIndex) {
		ArrayList<E> result;
		result = new ArrayList<E>();
		for (int i=fromIndex; i<=toIndex; i++)
			result.add(this.elementAt(i));
		return result;
	}

    /**
     * Trims the capacity of this <tt>ArrayList</tt> instance to be the
     * list's current size.  An application can use this operation to minimize
     * the storage of an <tt>ArrayList</tt> instance.
     */
    public void trimToSize() {
		this.theRealArrayList.trimToSize();
    }
}


//
///**
//* Returns a shallow copy of this <tt>ArrayList</tt> instance.  (The
//* elements themselves are not copied.)
//*
//* @return a clone of this <tt>ArrayList</tt> instance
//*/
//public Object clone() {
//try {
//  ArrayList<E> v = (ArrayList<E>) super.clone();
//  v.elementData = Arrays.copyOf(elementData, size);
//  v.modCount = 0;
//  return v;
//} catch (CloneNotSupportedException e) {
//  // this shouldn't happen, since we are Cloneable
//  throw new InternalError();
//}
//}