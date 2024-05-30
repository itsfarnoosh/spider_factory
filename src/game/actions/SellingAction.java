package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.SellableItem;

import static edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes.HEALTH;

public class SellingAction extends Action {
    private Actor buyer;
    private Actor seller;
    private SellableItem item;
    private int cost;

    public SellingAction(Actor buyer, Actor seller, SellableItem item){
        this.buyer = buyer;
        this.seller = seller;
        this.item = item;
        this.cost = item.getPrice();
    }

    public String execute(Actor actor, GameMap map){
        String result = "The intern sold the " + this.item + " for $" + this.cost + ".";
        item.sellItem(this.seller);
        if (this.seller.getAttribute(HEALTH) == 0){
            result = "The " + this.seller + " is instantly killed by " + this.buyer + ".";
            this.seller.unconscious(actor, map);
        }
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Sell " + this.item + ".";
    }
}
