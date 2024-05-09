package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.HuntsmanSpider;
import game.actors.enemies.SuspiciousAstronaut;
import game.actors.enemies.AlienBug;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class representing Crater Ground type.
 */
public class Crater extends Ground {

    private final int indexToSpawn;

    /**
     * Constructor for crater, a ground object that can spawn monsters (randomised).
     */
    public Crater() {
        super('u');
        int numOfCreatures = 3;
        Random random = new Random();
        this.indexToSpawn = random.nextInt(numOfCreatures);
    }

    /**
     * Non-default constructor for crater, a ground object that can spawn specific monsters.
     *
     * @param enemy an object of enemy for the crater to spawn.
     */
    public Crater(Enemy enemy) {
        super('u');
        int numOfCreatures = 3;
        Random random = new Random();
        this.indexToSpawn = enemy.getMonster().ordinal();
    }


    /**
     * The Crater can spawn enemy at each turn.
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