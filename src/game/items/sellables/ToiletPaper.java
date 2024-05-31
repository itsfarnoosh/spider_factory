package game.items.sellables;

import edu.monash.fit2099.engine.actors.Actor;
import game.items.sellables.SellableScrap;

import java.util.Random;

public class ToiletPaper extends SellableScrap {
    /**
     * Constructor
     *
     */
    public ToiletPaper(){
        super("Toilet Paper", 's', true, 1, 50);
    }
    public ToiletPaper(int price, int chance){
        super("Toilet Paper", 's', true, price, chance);
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
        if (percentage < super.getChance()){
//            System.out.println("The intern is instantly killed by humanoid figure.");
            actor.hurt(Integer.MAX_VALUE);
        } else {
            actor.addBalance(super.getPrice());
            actor.removeItemFromInventory(this);
        }
    }
}
