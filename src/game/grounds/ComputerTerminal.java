// File path: game/grounds/ComputerTerminal.java

package game.grounds;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.PurchaseAction;
import game.actions.TravelAction;
import game.items.Printer;
import game.items.TheseusPrinter;

import java.util.ArrayList;
/**
 * A computer terminal that allows the actor to purchase items and travel to different maps.
 */
public class ComputerTerminal extends Ground {
    private ArrayList<Printer> itemPrinters;
    private GameMap factoryMap;
    private GameMap moonMap;
    /**
     * Constructor for the ComputerTerminal.
     *
     * @param itemPrinters A list of item printers available at this terminal.
     * @param factoryMap   The map representing the factory.
     * @param moonMap      The map representing the new moon.
     */
    public ComputerTerminal(ArrayList<Printer> itemPrinters, GameMap factoryMap, GameMap moonMap) {
        super('=');
        this.itemPrinters = itemPrinters;
        this.factoryMap = factoryMap;
        this.moonMap = moonMap;

    }
    /**
     * Returns a list of allowable actions for this ground.
     * In this case, it provides actions to purchase items and travel to different maps.
     *
     * @param actor     The actor performing the actions.
     * @param location  The current location of the ground.
     * @param direction The direction of the ground from the actor.
     * @return A list of actions that can be performed on this ground.
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();

        // Add purchase actions
        for (Printer printer : itemPrinters) {
            actions.add(new PurchaseAction(printer));
        }

        // Add travel actions based on the current map
        if (location.map() == factoryMap) {
            actions.add(new TravelAction(moonMap.at(1, 1), "New Moon"));
        } else if (location.map() == moonMap) {
            actions.add(new TravelAction(factoryMap.at(1, 1), "Factory"));
        }

        return actions;
    }
    /**
     * Determines if the ground blocks thrown objects.
     *
     * @return true, indicating that this ground blocks thrown objects.
     */
    @Override
    public boolean blocksThrownObjects() {
        return true;
    }
}
