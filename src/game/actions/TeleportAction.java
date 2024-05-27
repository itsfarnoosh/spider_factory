
package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

public class TeleportAction extends Action {
    private Item teleporter;

    public TeleportAction(Item teleporter) {
        this.teleporter = teleporter;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        // Implement the random teleport logic within the same map
        return actor + " uses " + teleporter + " to teleport.";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Teleport with THESEUS";
    }
}
