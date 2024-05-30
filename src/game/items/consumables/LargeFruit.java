package game.items.consumables;

import edu.monash.fit2099.engine.actors.Actor;
import game.enums.Sellable;
import game.items.SellableItem;


/**
 * A class representing a Large Fruit item in the game.
 */
public class LargeFruit extends Fruit implements SellableItem {

    private int price;

    /**
     * Constructor.
     */
    public LargeFruit() {
        super("Large Fruit", 'O', true, 2);
        this.price = 30;
        this.addCapability(Sellable.SELLABLE);
    }
    public LargeFruit(int price) {
        super("Large Fruit", 'O', true, 2);
        this.price = price;
        this.addCapability(Sellable.SELLABLE);
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public void sellItem(Actor actor) {
        actor.addBalance(this.price);
        actor.removeItemFromInventory(this);
    }
}
