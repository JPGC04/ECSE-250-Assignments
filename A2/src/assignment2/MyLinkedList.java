package assignment2;

public abstract class MyLinkedList<E> implements MyList<E> {
    protected int size;

    public MyLinkedList() {
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
    public int getSize() {
        return this.size;
    }
}
