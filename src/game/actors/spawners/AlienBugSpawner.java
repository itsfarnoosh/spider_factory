package game.actors.spawners;

import game.actors.enemies.AlienBug;
import game.actors.enemies.Enemy;

public class AlienBugSpawner implements Spawner {
    @Override
    public Enemy spawn() {
        return new AlienBug();
    }

    @Override
    public boolean hasChance() {
        double spawnChance = new AlienBug().getSpawnChance();
        if (spawnChance > Math.random()){
            return true;
        }
        return false;
    }
}
