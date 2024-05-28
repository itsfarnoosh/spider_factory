package game.grounds.trees;


import edu.monash.fit2099.engine.positions.Location;



public class SproutState implements TreeState {
    private static final int GROWTH_PERIOD = 3;
    private int tickCount = 0;

    @Override
    public void tick(Inheritree context, Location location) {
        tickCount++;
        if (tickCount >= GROWTH_PERIOD) {
            context.setState(new SaplingState());
        }
    }

    @Override
    public char getDisplayChar() {
        return ',';
    }
}
