public class HardMode implements GameStrategy {
    @Override
    public boolean isMoveAllowed(int roll, int totalRolls) {
        return roll != 6 || totalRolls < 3;
    }
    
}
