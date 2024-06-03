package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.TeleportAction;

/**
 * A special item called THESEUS that allows an Actor to teleport within the same map.
 */
public class Theseus extends Item {

    /**
     * Constructor for the Theseus item.
     */
    public Theseus() {
        super("Theseus", '^', true);
    }

    /**
     * Returns a list of allowable actions for this item.
     * In this case, it provides a DropAction to the actor who owns it.
     *
     * @param owner The actor who owns this item.
     * @return A list of actions that can be performed with this item.
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new DropAction(this));
        return actions;
    }
    /**
     * Returns a list of allowable actions for this item.
     * In this case, it provides a TeleportAction to the actor who is standing on it/at the same location.
     *
     * @param location the location of the ground on which the item lies
     * @return A list of actions that can be performed with this item.
     */
    @Override
    public ActionList allowableActions(Location location) {
        ActionList actions = new ActionList();
        actions.add(new TeleportAction(this, location));
        return actions;
    }
}
