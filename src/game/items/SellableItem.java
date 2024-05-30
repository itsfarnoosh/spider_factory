package game.items;

import edu.monash.fit2099.engine.actors.Actor;


public interface SellableItem {
    int getPrice();
    void sellItem(Actor actor);

}
