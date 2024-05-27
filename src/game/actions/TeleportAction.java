// File path: game/actions/TeleportAction.java

package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

public class TeleportAction extends Action {
    private Item teleporter;

    public TeleportAction(Item teleporter) {
        this.teleporter = teleporter;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Random rand = new Random();
        int x, y;
        Location newLocation;

        // Ensure the teleportation happens within the same map
        do {
            x = rand.nextInt(map.getXRange().max() - map.getXRange().min() + 1) + map.getXRange().min();
            y = rand.nextInt(map.getYRange().max() - map.getYRange().min() + 1) + map.getYRange().min();
            newLocation = map.at(x, y);
        } while (!newLocation.canActorEnter(actor));

        map.moveActor(actor, newLocation);
        return actor + " uses " + teleporter + " to teleport to (" + x + ", " + y + ").";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Teleport with THESEUS";
    }
}
