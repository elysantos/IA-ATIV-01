package estruturas;

import java.util.Collection;
import java.util.Comparator;
import java.util.Queue;
import java.util.SortedSet;

/**
 * Artificial Intelligence A Modern Approach (3rd Edition): pg 80.<br>
 * <br>
 * The priority queue, which pops the element of the queue with the highest
 * priority according to some ordering function.
 * 
 * @author Ciaran O'Reilly
 * @param <E>
 */
public class AIMAPriorityQueue<E> extends java.util.PriorityQueue<E> implements
		Queue<E> {
	private static final long serialVersionUID = 1;

	public AIMAPriorityQueue() {
		super();
	}

	public AIMAPriorityQueue(Collection<? extends E> c) {
		super(c);
	}

	public AIMAPriorityQueue(int initialCapacity) {
		super(initialCapacity);
	}

	public AIMAPriorityQueue(int initialCapacity, Comparator<? super E> comparator) {
		super(initialCapacity, comparator);
	}

	public AIMAPriorityQueue(AIMAPriorityQueue<? extends E> c) {
		super(c);
	}

	public AIMAPriorityQueue(SortedSet<? extends E> c) {
		super(c);
	}

	//
	// START-Queue
        @Override
	public boolean isEmpty() {
		return 0 == size();
	}

	public E pop() {
		return poll();
	}

	public Queue<E> insert(E element) {
		if (offer(element)) {
			return this;
		}
		return null;
	}
	// END-Queue
	//
}