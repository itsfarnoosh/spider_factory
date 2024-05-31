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

    public SellingAction(Actor buyer, Actor seller, SellableItem item){
        this.buyer = buyer;
        this.seller = seller;
        this.item = item;
        this.cost = item.getPrice();
    }

    public SellingAction(Actor buyer, SellableItem item){
        this.buyer = buyer;
        this.item = item;
        this.cost = item.getPrice();
    }

    public String execute(Actor actor, GameMap map){
        String result = actor + " sold the " + this.item + " for $" + this.cost + ".";
        item.sellItem(actor);
        if (actor.getAttribute(HEALTH) == 0){
            result = "The " + actor + " is instantly killed by " + this.buyer + ".";
            actor.unconscious(actor, map);
        }
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Sell " + this.item + ".";
    }
}
