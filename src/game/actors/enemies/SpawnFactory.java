package game.actors.enemies;

import game.actors.enemies.Enemy;

public interface SpawnFactory<Creature extends Enemy > {
    Creature spawn();
}
