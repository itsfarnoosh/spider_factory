package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.ArrayList;
import java.util.List;

public class ComputerTerminal extends Ground {

    /**
     * Constructor
     *
     */
    public ComputerTerminal(){
        super('=');
    }

    /**
     * restrict actor from moving into the location
     *
     * @param actor the actors
     * @return restrict access
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
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
        List<Action> purchaseActions = new ArrayList<>(
                List.of(new PurchaseAction(new EnergyDrinkPrinter(10, 20)),
                        new PurchaseAction(new DragonSlayerPrinter(100, 50)),
                        new PurchaseAction(new ToiletPaperPrinter(5, 75))));

        ActionList actions = new ActionList();
        actions.add(purchaseActions);
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
