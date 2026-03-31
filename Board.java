import java.util.HashMap;
import java.util.Map;
class Board {
    int size;
    Map<Integer, Integer> snakes;
    Map<Integer, Integer> ladders;
    public Board(int size) {
        this.size = size;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
    }

    public int getNextPosition(int pos) {
        if (snakes.containsKey(pos)) return snakes.get(pos);
        if (ladders.containsKey(pos)) return ladders.get(pos);
        return pos;
    }

    public int getEnd() {
        return size * size;
    }
}