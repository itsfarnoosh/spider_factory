package game.items.consumables;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;

import java.util.Random;

public class PickleJar extends Item implements Consumable {
    private final int HURT_POINTS = 1;
    private final int HEAL_POINTS = 1;
    private final double EXPIRY_CHANCE = 0.5;


    /**
     * Constructor
     *
     */
    public PickleJar() {
        super("Jar of Pickles", 'n', true);
    }

    /**
     * Responsible for deciding whether the pickles are expired.
     *
     * @return boolean of whether it is or not
     */
    private boolean isExpired() {
        Random random = new Random();
        return random.nextDouble() < EXPIRY_CHANCE;
    }

    /**
     * Responsible for deciding whether the player will gain or loss health from consuming this.
     * if expired, consumer loss a hit-point
     * else, consumer gain a hit-point
     *
     * @param actor the consumer
     */
    @Override
    public String consume(Actor actor){
        if (isExpired()) {
            actor.removeItemFromInventory(this);
            actor.hurt(HURT_POINTS);
            return actor + " consumes " + this + ", but it's expired and hurts them by 1 point!";
        } else {
            actor.removeItemFromInventory(this);
            actor.heal(HEAL_POINTS);
            return actor + " consumes " + this + " and is healed by 1 point!";
        }
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
