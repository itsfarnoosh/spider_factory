package game.items.consumables;

import edu.monash.fit2099.engine.actors.Actor;
import game.items.consumables.Consumable;

public class EnergyDrink extends Consumable {
    private final int healingPoints;

    /**
     * Constructor.
     *
     * @param healingPoints the amount of healpoint the consumable can restore when consume.
     */
    public EnergyDrink(int healingPoints){
        super("Energy Drink", '*', true);
        this.healingPoints = healingPoints;
    }

    /**
     * Heals the holder of the drink (by consuming).
     *
     * @param actor the holder of the drink.
     * @return description of who consume the drink as well as how much hitpoint is restored.
     */
    @Override
    public String consume(Actor actor) {
        actor.heal(healingPoints);
        return actor + " is healed by " + healingPoints + " points! ";
    }
}
