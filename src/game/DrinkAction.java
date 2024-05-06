package game;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.positions.GameMap;

import static edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes.HEALTH;

public class DrinkAction extends Action {


    public DrinkAction() {
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        actor.modifyAttributeMaximum(HEALTH, ActorAttributeOperations.INCREASE, 1);
        return actor + "'s Max Health has been increased by 1 point!";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " drinks from the Puddle of Water";
    }
}
