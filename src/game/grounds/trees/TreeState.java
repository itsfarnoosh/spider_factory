package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Location;


public interface TreeState {
    void tick( Inheritree context, Location location);
    char getDisplayChar();
}
