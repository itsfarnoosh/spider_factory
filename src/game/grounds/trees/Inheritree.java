package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Represents a tree in the game that can transition through different states.
 * Extends the Ground class and manages its state using the TreeState interface.
 */
public class Inheritree extends Ground {
    private TreeState state;

    /**
     * Constructor.
     * Initializes the Inheritree with an initial state.
     *
     * @param initialState the initial state of the Inheritree.
     */
    public Inheritree(TreeState initialState) {
        super(initialState.getDisplayChar());
        this.state = initialState;
    }

    /**
     * Sets the state of the Inheritree.
     *
     * @param state the new state of the Inheritree.
     */
    public void setState(TreeState state) {
        this.state = state;
    }

    /**
     * Handles the ticking behavior of the Inheritree.
     * Delegates the tick handling to the current state.
     *
     * @param location the location of the Inheritree.
     */
    @Override
    public void tick(Location location) {
        state.tick(this, location);
    }

    /**
     * Gets the display character representing the current state of the Inheritree.
     *
     * @return the character representing the current state.
     */
    @Override
    public char getDisplayChar() {
        return state.getDisplayChar();
    }
}
