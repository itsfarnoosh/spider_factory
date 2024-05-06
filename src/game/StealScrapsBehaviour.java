package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.items.PickUpAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StealScrapsBehaviour implements Behaviour {

    private Random random = new Random();

    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location currentLocation = map.locationOf(actor);
        List<Item> potentialItems = new ArrayList<>();

        // Collect all portable scrap items at the current location
        for (Item item : currentLocation.getItems()) {
                potentialItems.add(item);
                actor.addItemToInventory(item);
            }

        for(Item item: potentialItems){
            currentLocation.removeItem(item);

        }


        // Randomly select one item to pick up if any are available
        if (!potentialItems.isEmpty()) {
            Item toPickUp = potentialItems.get(random.nextInt(potentialItems.size()));
            return new PickUpAction(toPickUp);
        }

        return null;  // No actionable item found
    }
}
