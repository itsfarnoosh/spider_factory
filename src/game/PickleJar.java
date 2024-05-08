package game;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.Random;

public class PickleJar extends Consumable {
    private final int HURT_POINTS = 1;
    private final int HEAL_POINTS = 1;
    private final double expiryChance = 0.5;

    public PickleJar() {
        super("Jar of Pickles", 'n', true);
    }
    private boolean isExpired() {
        Random random = new Random();
        return random.nextDouble() < expiryChance;
    }
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
