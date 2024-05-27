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

public class ComputerTerminal extends Ground {
    private ArrayList<Printer> itemPrinters;
    private GameMap factoryMap;
    private GameMap moonMap;

    public ComputerTerminal(ArrayList<Printer> itemPrinters, GameMap factoryMap, GameMap moonMap) {
        super('=');
        this.itemPrinters = itemPrinters;
        this.factoryMap = factoryMap;
        this.moonMap = moonMap;
        this.itemPrinters.add(new TheseusPrinter()); // Add THESEUS to the list of printers
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();

        // Add purchase actions
        for (Printer printer : itemPrinters) {
            actions.add(new PurchaseAction(printer));
        }

        // Add travel actions
        if (location.map() != factoryMap) {
            actions.add(new TravelAction(factoryMap.at(1, 1), "Factory"));
        }
        if (location.map() != moonMap) {
            actions.add(new TravelAction(moonMap.at(1, 1), "New Moon"));
        }

        return actions;
    }

    @Override
    public boolean blocksThrownObjects() {
        return true;
    }
}
