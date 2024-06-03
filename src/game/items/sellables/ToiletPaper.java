package game.items.sellables;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.Random;

public class ToiletPaper extends SellableScrap {
    /**
     * Constructor
     *
     */
    public ToiletPaper(){
        super("Toilet Paper", 's', true, 1, 50);
    }

    /***
     * Non-default Constructor.
     *
     * @param price price of the item
     * @param chance chance for the item to trigger its special affects
     */
    public ToiletPaper(int price, int chance){
        super("Toilet Paper", 's', true, price, chance);
    }

    /**
     * sell the item to the seller/provided actor.
     * if the chance of this item is met, the seller will be punished/instantly killed
     *
     * @param actor the seller of the item.
     * @return price of this object in int
     */
    @Override
    public void sellItem(Actor actor) {
        int percentage = new Random().nextInt(100);
        if (percentage < super.getChance()){
            // deal max damage to intern
            actor.hurt(Integer.MAX_VALUE);
        } else {
            actor.addBalance(super.getPrice());
            actor.removeItemFromInventory(this);
        }
    }
}
