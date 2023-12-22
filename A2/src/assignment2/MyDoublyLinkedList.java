package assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> extends MyLinkedList<E> {

	private DNode head;
	private DNode tail;

	public boolean add(E e) {
		if (e == null) {
			return false;
		}
		if (this.isEmpty()) {
			DNode newDNode = new DNode();
			newDNode.element = e;
			newDNode.prev = null;
			this.head = newDNode;
			this.tail = newDNode;
		}
		if (this.getSize() == 1) {
			DNode newDNode = new DNode();
			newDNode.element = e;
			newDNode.next = null;
			newDNode.prev = this.head;
			this.tail = newDNode;
			this.head.next = this.tail;
		} else {
			DNode newDNode = new DNode();
			newDNode.element = e;
			newDNode.prev = this.tail;
			newDNode.next = null;
			this.tail.next = newDNode;
			this.tail = newDNode;
		}
		this.size++;
		return true;
	}

	public E remove() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		E tailElement = this.tail.element;
		if (this.getSize() == 1) {
			this.head = null;
			this.tail.element = null;
			this.tail = null;
		} else {
			this.tail = this.tail.prev;
			this.tail.next.element = null;
			this.tail.next.prev = null;
			this.tail.next = null;
		}
		this.size--;
		return tailElement;
	}

	public boolean addFirst(E e) {
		if (e == null) {
			return false;
		}
		if (this.isEmpty()) {
			DNode newDNode = new DNode();
			newDNode.element = e;
			newDNode.prev = null;
			this.head = newDNode;
			this.tail = newDNode;
		}
		if (this.getSize() == 1) {
			DNode newDNode = new DNode();
			newDNode.element = e;
			this.tail = this.head;
			this.head = newDNode;
			this.tail.next = null;
			this.tail.prev = this.head;
			this.head.prev = null;
			this.head.next = this.tail;
		} else {
			DNode newDNode = new DNode();
			newDNode.element = e;
			newDNode.next = this.head;
			newDNode.prev = null;
			this.head.prev = newDNode;
			this.head = newDNode;
		}
		this.size++;
		return true;
	}

	public boolean addLast(E e) {
		return this.add(e);
	}

	public E removeFirst() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		E headElement = this.head.element;
		if (this.getSize() == 1) {
			this.head.element = null;
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
			this.head.prev.element = null;
			this.head.prev.next = null;
			this.head.prev = null;
		}
		this.size--;
		return headElement;
	}

	public E removeLast() {
		return remove();
	}

	public E peekFirst() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		return this.head.element;
	}

	public E peekLast() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		return this.tail.element;
	}

	public void clear() {
		while (this.getSize() > 0) {
			this.remove();
		}
		this.size = 0;
	}

	public boolean equals(Object object) {
		if ((!(object instanceof MyDoublyLinkedList))
				|| (((MyDoublyLinkedList<?>) object).getSize() != this.getSize())) {
			return false;
		}
		Iterator<?> objectIterator = ((MyDoublyLinkedList<?>) object).iterator();
		Iterator<E> thisIterator = this.iterator();
		while (thisIterator.hasNext()) {
			Object nextObject = objectIterator.next();
			E nextThis = thisIterator.next();
			if ((nextThis == null && nextObject != null) || (nextThis != null && nextObject == null)
					|| (!(nextObject.equals(nextThis)))) {
				return false;
			}
		}
		return true;
	}

	private class DNode {
		private E element;
		private DNode next;
		private DNode prev;
	}

	public Iterator<E> iterator() {
		return new DLLIterator();
	}

	private class DLLIterator implements Iterator<E> {
		DNode curr;

		public DLLIterator() {
			this.curr = head;
		}

		public boolean hasNext() {
			return this.curr != null;
		}

		public E next() {
			if (!this.hasNext())
				throw new NoSuchElementException();

			E element = this.curr.element;
			this.curr = this.curr.next;
			return element;
		}
	}
}
