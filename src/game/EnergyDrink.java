package game;

import edu.monash.fit2099.engine.actors.Actor;

public class EnergyDrink extends Consumable{
    private final int healingPoints;
    public EnergyDrink(int healingPoints){
        super("Energy Drink", '*', true);
        this.healingPoints = healingPoints;
    }

    @Override
    public String consume(Actor actor) {
        actor.heal(healingPoints);
        return actor + " is healed by " + healingPoints + " points! ";
    }
}
