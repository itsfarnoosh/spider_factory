

package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class TravelAction extends Action {
    private String destination;

    public TravelAction(String destination) {
        this.destination = destination;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        // Implement the logic to move the actor to the desired map
        // Placeholder logic for example:
        return actor + " travels to " + destination;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Travel to " + destination;
    }
}
