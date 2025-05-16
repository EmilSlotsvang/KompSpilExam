package emil.komp.asteroids.Asteroids;

import emil.komp.asteroids.common.Data.Entity;
import emil.komp.asteroids.common.Data.World;
import emil.komp.asteroids.common.asteroids.IAsteroidSplitter;
import emil.komp.asteroids.common.asteroids.asteroid;

public class AsteroidSplitterImpl implements IAsteroidSplitter {

    @Override
    public void createAsteroids(Entity original, World world) {
        float newRadius = original.getRadius() /2;

        if (newRadius < 3) return;

        for (int i = 0; i < 2; i++) {
            Entity smallAsteroid = new asteroid();
            smallAsteroid.setRadius(newRadius);
            smallAsteroid.setX(original.getX() + (Math.random() - 0.5) * 10);
            smallAsteroid.setY(original.getY() + (Math.random() - 0.5) * 10);
            smallAsteroid.setRotation((int) (Math.random() * 360));
            smallAsteroid.setPolygonCoordinates(
                    newRadius, -newRadius, -newRadius, -newRadius, -newRadius, newRadius, newRadius, newRadius
            );

            world.addEntity(smallAsteroid);
            System.out.println("[DEBUG] Splitting asteroid with radius: " + smallAsteroid.getRadius());
        }
    }
}

