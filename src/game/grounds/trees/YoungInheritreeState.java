package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Location;

public class YoungInheritreeState implements TreeState {
    private static final int GROWTH_PERIOD = 5;
    private int tickCount = 0;

    @Override
    public void tick(Inheritree context, Location location) {
        tickCount++;
        if (tickCount >= GROWTH_PERIOD) {
            context.setState(new MatureInheritreeState());
        }
    }

    @Override
    public char getDisplayChar() {
        return 'y';
    }
}