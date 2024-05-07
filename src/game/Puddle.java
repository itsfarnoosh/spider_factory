package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class Puddle extends Ground {

    /**
     * Constructor.
     * Initializes puddle of water.
     *
     */
    public Puddle() {
        super('~');
    }

    /**
     * Retrieves the list of allowable actions for the actor to drink the puddle.
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the puddle from the Actor
     * @return drinkAction choice for the actor to drink the water from the puddle
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        if (location.containsAnActor() && (location.getActor()).equals(actor)) {
            return new ActionList(new DrinkAction());
        }
        return new ActionList();
    }
}
