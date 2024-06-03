package game.actors.enemies;

public interface SpawnFactory<Creature extends Enemy > {
    Creature spawn();
}
