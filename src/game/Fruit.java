package game;

import edu.monash.fit2099.engine.actors.Actor;

public abstract class Fruit extends Consumable {

    public Fruit(String name, char displayChar, boolean portable, int points) {
        super(name, displayChar, portable, points);
    }

    @Override
    public String consume(Actor actor) {
        actor.heal(points);
        return actor + " is healed by " + this.getPoints() + " points! ";
    }
}
