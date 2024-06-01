package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.spawners.Spawner;
import game.actors.enemies.Enemy;

import java.util.Random;

/**
 * Class representing Crater Ground type.
 */
public class Crater extends Ground {
    private Spawner spawner;

    /**
     * Constructor for crater, a ground object that can spawn monsters (randomised).
     */
    public Crater() {
        super('u');
    }

    /**
     * Non-default constructor for crater, a ground object that can spawn specific monsters.
     *
     * @param spawner an object of enemy for the crater to spawn.
     */
    public Crater(Spawner spawner) {
        super('u');
        this.spawner = spawner;
    }


    /**
     * The Crater can spawn enemy at each turn.
     *
     * @param location The location of the Crater
     */
    @Override
    public void tick(Location location) {
        Enemy creature = spawner.spawn();
        if (spawner.hasChance()){
            while (true) {
                int randNum = new Random().nextInt(8);
                Location spawnLocation = location.getExits().get(randNum).getDestination();
                if (spawnLocation.canActorEnter(creature)) {
                    if (!spawnLocation.containsAnActor()) {
                        spawnLocation.addActor(creature);
                        break;
                    }
                }
            }
        }
    }
}