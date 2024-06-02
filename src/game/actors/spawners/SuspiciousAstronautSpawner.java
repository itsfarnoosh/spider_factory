package game.actors.spawners;

import game.actors.enemies.Enemy;
import game.actors.enemies.SuspiciousAstronaut;

public class SuspiciousAstronautSpawner implements Spawner {
    @Override
    public Enemy spawn() {
        return new SuspiciousAstronaut();
    }

    @Override
    public boolean hasChance() {
        double spawnChance = new SuspiciousAstronaut().getSpawnChance();
        if (spawnChance > Math.random()){
            return true;
        }
        return false;
    }
}
