package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class to represent hostile Enemy Actors.
 */
public abstract class Enemy extends Actor {

    /**
     * A map of the possible behaviours for the Enemy Actor.
     */
    protected Map<Integer, Behaviour> behaviours = new TreeMap<>();

    /**
     * The constructor of the Enemy class.
     *
     * @param name        The name of the Enemy
     * @param displayChar The character that will represent the Enemy in the display
     * @param hitPoints   The Enemy's starting hit points
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.ENEMY);
        this.behaviours.put(0, new AttackBehaviour());
    }

    /**
     * At each turn, the Enemy select a valid action to perform.
     *
     * @param actions    Collection of possible Actions for this Enemy
     * @param lastAction The Action this Enemy took last turn. Can do interesting things in
     *                   conjunction with Action.getNextAction()
     * @param map        The map containing the Enemy
     * @param display    The I/O object to which messages may be written
     * @return The Action to be performed
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null) {
                return action;
            }
        }
        return new DoNothingAction();
    }

    /**
     * The Enemy can be attacked by any actor that has the HOSTILE_TO_ENEMY capability.
     *
     * @param otherActor The Actor that might be performing an AttackAction on the Enemy
     * @param direction  String representing the direction of the other Actor
     * @param map        Current GameMap
     * @return A collection of Actions that can be performed on this Enemy by the other Actor
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }

    public abstract double getSpawnChance();
}