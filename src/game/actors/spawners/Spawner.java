package game.actors.spawners;

import game.actors.enemies.Enemy;

public interface Spawner {
    Enemy spawn();
    boolean hasChance();
}
