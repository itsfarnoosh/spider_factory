package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.enums.Sellable;

import java.util.Random;

/**
 * A class representing a Metal Sheet item in the game.
 */
public class MetalSheet extends Item implements SellableItem{
    private int price;
    private int chance;

    /***
     * Constructor.
     */
    public MetalSheet() {
        super("Metal Sheet", '%', true);
        this.price = 20;
        this.chance = 60;
        this.addCapability(Sellable.SELLABLE);
    }

    public MetalSheet(int price, int chance) {
        super("Metal Sheet", '%', true);
        this.price = price;
        this.chance = chance;
        this.addCapability(Sellable.SELLABLE);
    }

    @Override
    public int getPrice() {
        int percentage = new Random().nextInt(100);

        if (percentage < this.chance){
            this.price = 10;
        }

        return this.price;
    }

    @Override
    public void sellItem(Actor actor) {
        actor.addBalance(this.price);
        actor.removeItemFromInventory(this);
    }
}

