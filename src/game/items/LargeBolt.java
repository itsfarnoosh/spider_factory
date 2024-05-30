package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.enums.Sellable;

import java.util.Random;

/**
 * A class representing a Large Bolt item in the game.
 */
public class LargeBolt extends Item implements SellableItem{

    private int price;
    /***
     * Constructor.
     */
    public LargeBolt() {
        super("Large Bolt", '+', true);
        this.price = 25;
        this.addCapability(Sellable.SELLABLE);
    }
    public LargeBolt(int price) {
        super("Large Bolt", '+', true);
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