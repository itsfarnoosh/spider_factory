package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.enums.Sellable;

import java.util.Random;

public class ToiletPaper extends Item implements SellableItem{

    private int price;

    private int chance;

    /**
     * Constructor
     *
     */
    public ToiletPaper(){
        super("Toilet Paper", 's', true);
        this.price = 1;
        this.chance = 50;
        this.addCapability(Sellable.SELLABLE);
    }
    public ToiletPaper(int price, int chance){
        super("Toilet Paper", 's', true);
        this.price = price;
        this.chance = chance;
        this.addCapability(Sellable.SELLABLE);
    }

    /**
     * Provide the price of this item
     *
     * @return price of this object in int
     */
    @Override
    public int getPrice() {
        return this.price;
    }

    /**
     * sell the item to the seller/provided actor.
     * if the chance of this item is met, the seller will be punished/instantly killed
     *
     * @return price of this object in int
     */
    @Override
    public void sellItem(Actor actor) {
        int percentage = new Random().nextInt(100);
        if (percentage < this.chance){
//            System.out.println("The intern is instantly killed by humanoid figure.");
            actor.hurt(Integer.MAX_VALUE);
        } else {
            actor.addBalance(this.price);
            actor.removeItemFromInventory(this);
        }
    }
}
