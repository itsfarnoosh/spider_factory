package game.items.consumables;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;
import game.enums.Sellable;
import game.items.SellableItem;

import java.util.Random;

public class GoldPot extends Item implements Consumable, SellableItem {
    private final int INCREASE_AMOUNT = 10;

    private int price;
    private int chance;

    /**
     * Constructor.
     *
     */
    public GoldPot() {
        super("Pot of Gold", '$', true);
        this.price = 500;
        this.chance = 25;
        this.addCapability(Sellable.SELLABLE);
    }
    public GoldPot(int price, int chance) {
        super("Pot of Gold", '$', true);
        this.price = price;
        this.chance = chance;
        this.addCapability(Sellable.SELLABLE);
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

        if (percentage < this.chance){
            this.price = 0;
        }

        return this.price;
    }

    @Override
    public void sellItem(Actor actor) {
        actor.addBalance(this.price);
        actor.removeItemFromInventory(this);
    }
}
