package game.actors.spawners;

import game.actors.enemies.Enemy;
import game.actors.enemies.HuntsmanSpider;

public class HuntsmanSpiderSpawner implements Spawner {
    @Override
    public Enemy spawn() {
        return new HuntsmanSpider();
    }

    @Override
    public boolean hasChance() {
        double spawnChance = new HuntsmanSpider().getSpawnChance();
        if (spawnChance > Math.random()){
            return true;
        }
        return false;
    }
}
