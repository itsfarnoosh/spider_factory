package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//Intern can attack AlienBug
//AlienBug wander around
//AlienBug Follow the intern
//AlienBug has 2 hit points
//alien bug doesn't pick up scraps****
//alien bug doesn't drop anything after death***

/**
 * AlienBug class that extends Enemy and includes behaviors for following and collecting scraps.
 */
public class AlienBug extends Enemy {
    /** Map of priorities to Behaviours */
    private Map<Integer, Behaviour> behaviours = new HashMap<>();
    // This creature has 2 hit points.
    private static final Random random = new Random();


    public AlienBug(Actor player) {
        super(generateUniqueName(), 'a', 2);
//      this.behaviours.put(1, new StealScrapsBehaviour()); // Custom behavior for stealing scraps
        this.behaviours.put(1, new FollowBehaviour(player));// within the surroundings of the bug (i.e. one exit away), it will start following the Intern.
        this.behaviours.put(2, new WanderBehaviour()); // Custom behavior for wandering


    }

    /**
     * Generates a unique name for each Alien Bug instance.
     * @return A string representing the unique name "Feature-XXX" where XXX are random digits
     */
    private static String generateUniqueName() {
        int randomDigits = 100 + random.nextInt(900); // Generates a number from 100 to 999
        return "Feature-" + randomDigits;
    }
    //the Alien Bug cannot attack the Intern.
    /**
     * Called once per turn, allows the Alien Bug to perform actions like moving or stealing.
     * @param actions The list of possible actions this turn
     * @param lastAction The last action performed by this Actor
     * @param map The game map containing this Actor
     * @param display The I/O object to which messages may be written
     * @return the Action this Actor chooses to perform this turn
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Map.Entry<Integer, Behaviour> behaviourEntry : behaviours.entrySet()) {
            Action action = behaviourEntry.getValue().getAction(this, map);
            if (action != null) {
                display.println(action.menuDescription(this));
                return action;
            }
        }
        return new DoNothingAction();
    }

   /**
     * The Alien bug can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }




}
