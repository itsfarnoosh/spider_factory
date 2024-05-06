package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import java.util.Random;

/**
 * Class representing Crater Ground type.
 */
public class Crater extends Ground {

    /**
     * Constructor for crater, a ground object than can spawn huntsman spiders.
     */
    public Crater() {
        super('u');
    }

    /**
     * The Crater can spawn Huntsman Spiders at each turn.
     *
     * @param location The location of the Crater
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        if (Math.random() <= 0.05) {
            Random rand = new Random();
            while (true) {
                Location spawnLocation = location.getExits().get(rand.nextInt(location.getExits().size()))
                        .getDestination();
                HuntsmanSpider huntsmanSpider = new HuntsmanSpider();
                SuspiciousAstronaut suspiciousAstronaut = new SuspiciousAstronaut();
                if (spawnLocation.canActorEnter(huntsmanSpider)) {
                    if (!spawnLocation.containsAnActor()) {
                        spawnLocation.addActor(huntsmanSpider);
                        break;
                    }
                }
            }
        }
    }
}