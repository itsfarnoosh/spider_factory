package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


//Suspicious Astronaut kills the intern
//Suspicious Astronaut wander around
//Suspicious Astronaut cannot enter the Intern’s spaceship ***
public class SuspiciousAstronaut extends Enemy {
    /** Map of priorities to Behaviours */
    private Map<Integer, Behaviour> behaviours = new TreeMap<>();


    public SuspiciousAstronaut() {
        super("Suspicious Astronaut", 'ඞ', 99);
        this.behaviours.put(999, new WanderBehaviour()); // Custom behavior for wandering
        this.spawnChance = 0.05;

    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;

        }
        return new DoNothingAction();
    }

    /**
     * Retrieves the intrinsic weapon of the SuspiciousAstronaut .
     *
     * @return the IntrinsicWeapon of the SuspiciousAstronaut
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon(){
        return new IntrinsicWeapon(2, "kill", 100);
    }
}