import java.util.*;
class Game {
    Board board;
    Dice dice;
    GameStrategy strategy;
    Queue<Player> turnQueue;
    private final List<Player> winners;

    public Game(int size, List<Player> players, String strategy) {
        this.board = BoardFactory.createBoard(size);
        this.strategy = GameStrategyFactory.getGameStrategy(strategy);
        this.dice = new Dice();
        this.turnQueue = new LinkedList<>(players);
        this.winners = new ArrayList<>();
    }

    public void start() {
        while (true) {
            Player player = turnQueue.poll();
            playTurn(player);
            if(hasWon(player)){
                winners.add(player);
                System.out.println(player.name + " has won!");
            }
            else {
                turnQueue.offer(player);
            }
        }
    }

    private void playTurn(Player player) {
        int rolls = 0;

        while (true) {
            int roll = dice.roll();
            rolls++;

            System.out.println(player.name + " rolled " + roll);

            if (!strategy.isMoveAllowed(roll,rolls)) {
                System.out.println("Move cancelled due to rules");
                return;
            }

            movePlayer(player, roll);

            if (roll != 6) break;
        }
    }

    private void movePlayer(Player player, int roll) {
        int newPos = player.position + roll;

        if (newPos > board.size * board.size){
            return;
        }

        newPos = board.getNextPosition(newPos);
        player.position = newPos;

        System.out.println(player.name + " moved to " + newPos);
    }

    private boolean hasWon(Player player) {
        return player.position == board.getEnd();
    }
}