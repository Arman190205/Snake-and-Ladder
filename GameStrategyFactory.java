public class GameStrategyFactory {
    static GameStrategy getGameStrategy(String mode) {
        switch (mode.toLowerCase()) {
            case "easy" -> {
                return new EasyMode();
            }
            case "hard" -> {
                return new HardMode();
            }
            default -> throw new IllegalArgumentException("Invalid game mode: " + mode);
        }
    }
    
}
