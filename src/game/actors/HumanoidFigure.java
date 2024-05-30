package game.actors;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.SellingAction;
import game.enums.Sellable;
import game.items.SellableItem;

import java.util.List;

public class HumanoidFigure extends NeutralActor {
    // make hitpoint = 1 as the humanoid cannot be attack by other living things.
    // This is due to the fact that this actor doesn't have any capability/status.
    public HumanoidFigure(){
        super("Humanoid figure", 'H', 1);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map){
        ActionList actions = new ActionList();
        // get all the player's item within their inventory.
        List<Item> items = otherActor.getItemInventory();
        // loop for each item
        for (Item item: items) {
            // if the Item is sellable.
            // prevent occurrence of errors if the item doesn't implement SellableItem interface/isn't sellable.
            if (item.hasCapability(Sellable.SELLABLE)){
                // Change item's declaration to SellableItem through the use of interface cast.
                // Technically not downcasting... right?
                SellableItem sellableScrap = (SellableItem) item;
                // create a choice for the player to be able to sell each item if it is sellable.
                actions.add(new SellingAction(this, otherActor, sellableScrap));
            }
        }

        return actions;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
