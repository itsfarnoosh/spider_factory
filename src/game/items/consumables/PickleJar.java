package game.items.consumables;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.Random;

public class PickleJar extends Consumable {
    private final int HURT_POINTS = 1;
    private final int HEAL_POINTS = 1;
    private final double expiryChance = 0.5;


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
        return random.nextDouble() < expiryChance;
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
            actor.hurt(HURT_POINTS);
            return actor + " consumes " + this + ", but it's expired and hurts them by 1 point!";
        } else {
            actor.heal(HEAL_POINTS);
            return actor + " consumes " + this + " and is healed by 1 point!";
        }
    }
}
