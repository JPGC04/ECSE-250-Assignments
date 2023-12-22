package assignment2;

import java.util.Iterator;

public class Caterpillar extends MyDoublyLinkedList<Position> {
    public Caterpillar() {
        super();
        this.add(new Position(7, 7));
        this.size = 1;
    }

    public Position getHead() {
        return this.peekFirst();
    }
    public void eat(Position inputPosition) {
        if (this.selfCollision(inputPosition)) {
            throw new IllegalArgumentException();
        }
        if (this.getHead().getDistance(inputPosition) != 1) {
            throw new IllegalArgumentException();
        }
        this.addFirst(inputPosition);
    }
    public void move(Position inputPosition) {
        if (this.selfCollision(inputPosition)) {
            throw new IllegalArgumentException();
        }
        if (this.getHead().getDistance(inputPosition) != 1) {
            throw new IllegalArgumentException();
        }
        if (this.addFirst(inputPosition)) {
            this.removeLast();
        }
    }
    public boolean selfCollision(Position inputPosition) {
        Iterator<Position> thisIterator = this.iterator();
        while (thisIterator.hasNext()) {
            Position nextPosition = thisIterator.next();
            if (nextPosition.equals(inputPosition)) {
                return true;
            }
        }
        return false;
    }
}
