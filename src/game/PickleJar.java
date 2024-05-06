package game;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.Random;

public class PickleJar extends Consumable {

    public PickleJar() {
        super("Jar of Pickles", 'n', true, 1);
    }
    private boolean isExpired() {
        Random random = new Random();
        double expiryChance = 0.5;
        return random.nextDouble() < expiryChance;
    }
    @Override
    public String consume(Actor actor){
        if (isExpired()) {
            actor.hurt(points);
            return actor + " consumes " + this + ", but it's expired and hurts them by 1 point!";
        } else {
            actor.heal(points);
            return actor + " consumes " + this + " and is healed by 1 point!";
        }
    }
}
