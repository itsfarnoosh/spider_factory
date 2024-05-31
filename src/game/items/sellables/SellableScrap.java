package game.items.sellables;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SellingAction;
import game.enums.Status;


public class SellableScrap extends Item implements SellableItem {

    private int price;
    private int chance;

    public SellableScrap(String name, char displayChar, boolean portable){
        super(name, displayChar, portable);
    }

    public SellableScrap(String name, char displayChar, boolean portable, int price){
        super(name, displayChar, portable);
        this.setPrice(price);
    }

    public SellableScrap(String name, char displayChar, boolean portable, int price, int chance){
        super(name, displayChar, portable);
        this.setPrice(price);
        this.setChance(chance);
    }

    protected void setPrice(int price){
        this.price = price;
    }

    protected void setChance(int chance){
        this.chance = chance;
    }

    protected int getChance(){
        return this.chance;
    }

    /**
     * Provide the price of this item
     *
     * @return price of this object in int
     */
    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public void sellItem(Actor actor) {
        actor.addBalance(this.getPrice());
        actor.removeItemFromInventory(this);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = super.allowableActions(location);
        if (otherActor.hasCapability(Status.TRADER))
            actions.add(new SellingAction(otherActor, this));
        return actions;
    }
}
