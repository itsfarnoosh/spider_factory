package game.items.consumables;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;

public class GoldPot extends Item implements Consumable {
    private final int INCREASE_AMOUNT = 10;

    /**
     * Constructor.
     *
     */
    public GoldPot() {
        super("Pot of Gold", '$', true);
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

}
