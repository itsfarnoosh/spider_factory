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

    private int indexToSpawn;

    /**
     * Constructor for crater, a ground object than can spawn huntsman spiders.
     */
    public Crater() {
        super('u');
        int numOfCreatures = 3;
        Random random = new Random();
        this.indexToSpawn = random.nextInt(numOfCreatures);
    }


    /**
     * The Crater can spawn Huntsman Spiders at each turn.
     *
     * @param location The location of the Crater
     */
    @Override
    public void tick(Location location) {
        ArrayList<Enemy> spawnCreatures = new ArrayList<Enemy>();
        spawnCreatures.add(new HuntsmanSpider());
        spawnCreatures.add(new AlienBug());
        spawnCreatures.add((new SuspiciousAstronaut()));
        super.tick(location);
        if (Math.random() <= spawnCreatures.get(indexToSpawn).getSpawnChance()) {
            Random rand = new Random();
            while (true) {
                Location spawnLocation = location.getExits().get(rand.nextInt(location.getExits().size()))
                        .getDestination();
                if (spawnLocation.canActorEnter(spawnCreatures.get(indexToSpawn))) {
                    if (!spawnLocation.containsAnActor()) {
                        spawnLocation.addActor(spawnCreatures.get(indexToSpawn));
                        break;
                    }
                }
            }
        }
    }
}