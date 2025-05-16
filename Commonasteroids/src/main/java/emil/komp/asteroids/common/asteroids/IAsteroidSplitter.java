package emil.komp.asteroids.common.asteroids;

import emil.komp.asteroids.common.Data.Entity;

import emil.komp.asteroids.common.Data.World;

public interface IAsteroidSplitter {
    void createAsteroids(Entity original, World world);
}
