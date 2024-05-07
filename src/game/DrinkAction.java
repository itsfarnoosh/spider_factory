package game;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.positions.GameMap;

import static edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes.HEALTH;

public class DrinkAction extends Action {


    public DrinkAction() {
    }

    /**
     * Increase the value of the actor by 1.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return description of the result of the choice
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.modifyAttributeMaximum(HEALTH, ActorAttributeOperations.INCREASE, 1);
        return actor + "'s Max Health has been increased by 1 point!";
    }

    /**
     * Display the description of the choice when it is executable.
     *
     * @param actor The actor performing the action.
     * @return description of the choice.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " drinks from the Puddle of Water";
    }
}
