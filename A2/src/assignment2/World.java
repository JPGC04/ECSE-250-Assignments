package assignment2;

public class World {
    private Caterpillar caterpillar;
    private Position position;
    private Region region;
    private ActionQueue actionQueue;
    private TargetQueue targetQueue;
    private GameState gameState;

    public World(TargetQueue inputTargetQueue, ActionQueue inputActionQueue) {
        this.targetQueue = inputTargetQueue;
        this.actionQueue = inputActionQueue;
        this.region = new Region(0, 0, 15, 15);
        this.position = this.targetQueue.dequeue();
        this.caterpillar = new Caterpillar();
        this.gameState = GameState.MOVE;
    }

    public void step() {
        if (this.actionQueue.isEmpty()) {
            this.gameState = GameState.NO_MORE_ACTION;
            return;
        }
        if (!(this.gameState.equals(GameState.MOVE) || this.gameState.equals(GameState.EAT))) {
            return;
        }
        Direction nextDir = this.actionQueue.dequeue();
        Position headPos = new Position(this.caterpillar.getHead());
        if (nextDir == Direction.EAST) {
            headPos.moveEast();
        } else if (nextDir == Direction.WEST) {
            headPos.moveWest();
        } else if (nextDir == Direction.NORTH) {
            headPos.moveNorth();
        } else if (nextDir == Direction.SOUTH) {
            headPos.moveSouth();
        }
        if (!(this.region.contains(headPos))) {
            if (nextDir == Direction.EAST) {
                headPos.moveWest();
            } else if (nextDir == Direction.WEST) {
                headPos.moveEast();
            } else if (nextDir == Direction.NORTH) {
                headPos.moveSouth();
            } else if (nextDir == Direction.SOUTH) {
                headPos.moveNorth();
            }
            this.gameState = GameState.WALL_COLLISION;
        } else if ((this.caterpillar.selfCollision(headPos))) {
            this.gameState = GameState.SELF_COLLISION;
        } else if (headPos.equals(this.position)) {
            this.caterpillar.eat(headPos);
            this.gameState = GameState.EAT;
            if (this.targetQueue.isEmpty()) {
                this.gameState = GameState.DONE;
            } else {
                this.position = this.targetQueue.dequeue();

            }
        } else {
            this.caterpillar.move(headPos);
            this.gameState = GameState.MOVE;
        }
    }

    public GameState getState() {
        return this.gameState;
    }

    public Caterpillar getCaterpillar() {
        return this.caterpillar;
    }

    public Position getFood() {
        return this.position;
    }

    public boolean isRunning() {
        return ((this.gameState == GameState.MOVE) || (this.gameState == GameState.EAT));
    }
}
