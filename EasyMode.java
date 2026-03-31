public class EasyMode implements GameStrategy {
    @Override
    public boolean isMoveAllowed(int roll, int totalRolls) {
        return true;
    }
}
