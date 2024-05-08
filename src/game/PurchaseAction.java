package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

public class PurchaseAction extends Action {
    private Printer printer;

    /**
     * Constructor
     *
     * @param printer the Printer that actor purchase from
     */
    public PurchaseAction(Printer printer){
        this.printer = printer;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String ret = "";
        int credit = printer.creditPayable();
        Item item = printer.getItem();

        if (actor.getBalance() >= credit) {
            actor.deductBalance(credit);
            ret += credit + " credit is deducted from " + actor + "'s balance\n";
            if (printer.printsItem()) {
                actor.addItemToInventory(item);
                ret += actor + " gets " + item;
            }else {
                ret += actor + "did not get " + item;
            }
        }else {
            ret += "Insufficient balance";
        }

        return ret;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " wants to get " + printer;
    }
}