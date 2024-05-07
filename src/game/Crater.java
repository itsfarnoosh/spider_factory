package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class representing Crater Ground type.
 */
public class Crater extends Ground {
    private Enemy spawnCreature;

    /**
     * Constructor for crater, a ground object than can spawn huntsman spiders.
     */
    public Crater(Enemy spawnCreature) {
        super('u');
        this.spawnCreature = spawnCreature;
    }


    /**
     * The Crater can spawn Huntsman Spiders at each turn.
     *
     * @param location The location of the Crater
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        if (Math.random() <= this.spawnCreature.getSpawnChance()) {
            Random rand = new Random();
            while (true) {
                Location spawnLocation = location.getExits().get(rand.nextInt(location.getExits().size()))
                        .getDestination();
                if (spawnLocation.canActorEnter(this.spawnCreature)) {
                    if (!spawnLocation.containsAnActor()) {
                        spawnLocation.addActor(this.spawnCreature);
                        break;
                    }
                }
            }
        }
    }
}