import java.util.Random;   
class BoardFactory {

    public static Board createBoard(int size) {
        Board board = new Board(size);

        Random rand = new Random();

        // generate snakes
        for (int i = 0; i < size; i++) {
            int head = rand.nextInt(size * size - 1) + 2;
            int tail = rand.nextInt(head - 1) + 1;
            board.snakes.put(head, tail);
        }

        // generate ladders
        for (int i = 0; i < size; i++) {
            int start = rand.nextInt(size * size - 1) + 1;
            int end = rand.nextInt(size * size - start) + start + 1;
            board.ladders.put(start, end);
        }

        return board;
    }
}