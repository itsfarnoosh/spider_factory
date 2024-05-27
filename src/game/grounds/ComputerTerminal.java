package game.grounds;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.TravelAction;
import game.items.*;
import game.items.consumables.EnergyDrinkPrinter;
import game.actions.PurchaseAction;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ComputerTerminal extends Ground {
    private Action computerTerminal;
    private ArrayList<Printer> itemPrinters;
    private GameMap factoryMap;
    private GameMap moonMap;
    /**
     * Constructor
     *
     */
    public ComputerTerminal(ArrayList<Printer> itemPrinters,GameMap factoryMap, GameMap moonMap){
        super('=');
        this.itemPrinters = itemPrinters;
        this.factoryMap = factoryMap;
        this.moonMap = moonMap;
        this.itemPrinters.add(new TheseusPrinter()); // Add THESEUS to the list of printers

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
