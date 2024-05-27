package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class TravelAction extends Action {
    private Location destination;
    private String destinationName;

    public TravelAction(Location destination, String destinationName) {
        this.destination = destination;
        this.destinationName = destinationName;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.moveActor(actor, destination);
        return actor + " travels to " + destinationName;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Travel to " + destinationName;
    }
}
