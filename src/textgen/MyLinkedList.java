package textgen;

import java.util.AbstractList;
import java.util.Objects;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E> (null);
		tail = new LLNode<E> (null);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		Objects.requireNonNull(element, "Empty Element Input!");
		LLNode<E> newNode = new LLNode<E>(element, tail.prev, tail);
		newNode.prev.next = newNode;
		newNode.next.prev = newNode;
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		return getNode(index).data;
	}
	
	private LLNode<E> getNode(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid Index Input!");
		}
		LLNode<E> node = head;
		while (index-- >= 0) {
			node = node.next;
		}
		return node;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		Objects.requireNonNull(element, "Empty Element Input!");
		if (index == size) {
			this.add(element);
			return;
		}
		else if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Invalid Index Input!");
		}
		LLNode<E> indNode = getNode(index);
		LLNode<E> addNode = new LLNode<E>(element, indNode.prev, indNode);
		addNode.prev.next = addNode;
		addNode.next.prev = addNode;
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid Index Input!");
		}
		LLNode<E> removeNode = getNode(index);
		removeNode.prev.next = removeNode.next;
		removeNode.next.prev = removeNode.prev;
		removeNode.prev = null; // not necessary
		removeNode.next = null;
		size--;
		return removeNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		Objects.requireNonNull(element, "Empty Element Input!");
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid Index Input!");
		}
		LLNode<E> setNode = getNode(index);
		E value = setNode.data;
		setNode.data = element;
		return value;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	// added new constructor to facilitate implementation
	public LLNode(E e, LLNode<E> prev, LLNode<E> next) {
		this.data = e;
		this.prev = prev;
		this.next = next;
	}

}
