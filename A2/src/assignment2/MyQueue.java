package assignment2;

public class MyQueue<E> {
    private MyDoublyLinkedList<E> myQueue;

    public MyQueue() {
        this.myQueue = new MyDoublyLinkedList<>();
    }

    public boolean enqueue(E e) {
        return this.myQueue.addFirst(e);
    }
    public E dequeue() {
        return this.myQueue.removeLast();
    }
    public boolean isEmpty() {
        return this.myQueue.isEmpty();
    }
    public void clear() {
        this.myQueue.clear();
    }
    public boolean equals(Object object) {
        return ((object instanceof MyQueue<?>) && (this.myQueue.equals(((MyQueue<?>) object).myQueue)));
    }
}
