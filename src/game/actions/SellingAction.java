package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.sellables.SellableItem;

import static edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes.HEALTH;

public class SellingAction extends Action {
    private Actor buyer;
    private Actor seller;
    private SellableItem item;
    private int cost;

    /**
     * Constructor
     *
     * @param buyer the actor who is buying the item/triggers the SellAction.
     * @param item  the sellable item.
     */
    public SellingAction(Actor buyer, SellableItem item){
        this.buyer = buyer;
        this.item = item;
        // change from getPrice()
        // calculate the appropriate price base on item's chance (if they have one)
        this.cost = item.getSellingPrice();
    }

    /**
     * Activates item's sellItem() method and return the result of the method.
     *
     * @param actor the intern
     * @param map the map the intern is in.
     * @return String that shows the result of SellingAction
     */
    public String execute(Actor actor, GameMap map){
        String result = actor + " sold the " + this.item + " for $" + this.cost + ".";
        // initiate the selling process through item's sellItem action.
        item.sellItem(actor);
        // if the intern's health is 0 / dead.
        if (actor.getAttribute(HEALTH) == 0){
            result = "The " + actor + " is instantly killed by " + this.buyer + ".";
            // remove intern from the map and terminate the game.
            actor.unconscious(actor, map);
        }
        return result;
    }

    /**
     * Description of the SellingAction.
     * Changes depending on what is sellable.
     *
     * @param actor the intern
     * @return Choice description in String.
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Sell " + this.item + ".";
    }
}
