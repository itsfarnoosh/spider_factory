package game.items.consumables;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import game.actions.ConsumeAction;
import game.items.sellables.SellableScrap;

import java.util.Random;

public class GoldPot extends SellableScrap implements Consumable {
    private final int INCREASE_AMOUNT = 10;

    /**
     * Constructor.
     *
     */
    public GoldPot() {
        super("Pot of Gold", '$', true, 500, 25);
    }
    public GoldPot(int price, int chance) {
        super("Pot of Gold", '$', true, price, chance);
    }

    /**
     * Add the amount of gold to the actor's balance / wallet
     *
     * @param actor the Actor.
     */
    @Override
    public String consume(Actor actor) {
        actor.removeItemFromInventory(this);
        actor.addBalance(INCREASE_AMOUNT);
        return "Wallet amount is increased by " + INCREASE_AMOUNT + " points!";
    }
    /**
     * Retrieves the list of allowable actions for the owner of the fruit.
     *
     * @param owner the Actor that owns the fruit
     * @return a list of allowable actions for the owner of the fruit
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        return new ActionList(new ConsumeAction(this));
    }

    @Override
    public int getPrice() {
        int percentage = new Random().nextInt(100);

        if (percentage < super.getChance()){
            super.setPrice(0);
        }

        return super.getPrice();
    }
}
