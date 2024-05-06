package game;

import edu.monash.fit2099.engine.actors.Actor;

public abstract class Fruit extends Consumable {
    private final int healingPoints;

    public Fruit(String name, char displayChar, boolean portable, int healingPoints) {
        super(name, displayChar, portable);
        this.healingPoints = healingPoints;
    }

    public int getHealingPoints() {
        return healingPoints;
    }

    @Override
    public String consume(Actor actor) {
        actor.heal(healingPoints);
        return actor + " is healed by " + this.getHealingPoints() + " points! ";
    }
}
