package assignment2;

public class MyStack<E> {
    private MyDoublyLinkedList<E> myStack;

    public MyStack() {
        this.myStack = new MyDoublyLinkedList<>();
    }

    public boolean push(E e) {
        return this.myStack.addFirst(e);
    }
    public E pop() {
        return this.myStack.removeFirst();
    }
    public E peek() {
        return this.myStack.peekFirst();
    }
    public boolean isEmpty() {
        return this.myStack.isEmpty();
    }
    public void clear() {
        this.myStack.clear();
    }
    public int getSize() {
        return this.myStack.getSize();
    }
}
