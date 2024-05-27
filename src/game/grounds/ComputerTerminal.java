package game.grounds;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.TravelAction;
import game.items.AstleyPrinter;
import game.items.DragonSlayerPrinter;
import game.items.Printer;
import game.items.consumables.EnergyDrinkPrinter;
import game.actions.PurchaseAction;
import game.items.ToiletPaperPrinter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ComputerTerminal extends Ground {
    private ArrayList<Printer> itemPrinters;

    /**
     * Constructor
     *
     */
    public ComputerTerminal(ArrayList<Printer> itemPrinters){
        super('=');
        this.itemPrinters = itemPrinters;
    }
    
    /**
     * Create purchase actions for each item
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return The purchaseAction for each item
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        for(Printer printer: itemPrinters){
            actions.add(new PurchaseAction(printer));
        }
        // Add travel actions based on the current location
        if (location.getGround().getDisplayChar() == '=') { // Assuming '=' is the terminal
            actions.add(new TravelAction("Factory"));
            actions.add(new TravelAction("New Moon"));
        }

        return actions;
    }


    /**
     * provide the ability for the thrown object to be blockable by the terminal.
     *
     * @return Blockable from thrown object
     */
    @Override
    public boolean blocksThrownObjects() {
        return true;
    }
}
