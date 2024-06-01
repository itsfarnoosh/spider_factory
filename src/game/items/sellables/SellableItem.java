package game.items.sellables;

import edu.monash.fit2099.engine.actors.Actor;


public interface SellableItem {
    int getPrice();
    int getSellingPrice();
    void sellItem(Actor actor);

}
