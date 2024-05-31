package game.items.consumables;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SellingAction;
import game.enums.Status;
import game.items.sellables.SellableItem;


/**
 * A class representing a Large Fruit item in the game.
 */
public class LargeFruit extends Fruit implements SellableItem{

    private int price;

    /**
     * Constructor.
     */
    public LargeFruit() {
        super("Large Fruit", 'O', true, 2);
        this.price = 30;
    }
    public LargeFruit(int price) {
        super("Large Fruit", 'O', true, 2);
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public void sellItem(Actor actor) {
        actor.addBalance(this.getPrice());
        actor.removeItemFromInventory(this);
    }

    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = super.allowableActions(location);
        if (otherActor.hasCapability(Status.TRADER))
            actions.add(new SellingAction(otherActor, this));
        return actions;
    }
}
