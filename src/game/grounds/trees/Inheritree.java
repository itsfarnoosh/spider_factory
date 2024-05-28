package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;


public class Inheritree extends Ground {
    private TreeState state;

    public Inheritree(TreeState initialState) {
        super(initialState.getDisplayChar());
        this.state = initialState;
    }

    public void setState(TreeState state) {
        this.state = state;
    }

    @Override
    public void tick(Location location) {
        state.tick(this, location);
    }

    @Override
    public char getDisplayChar() {
        return state.getDisplayChar();
    }
}
