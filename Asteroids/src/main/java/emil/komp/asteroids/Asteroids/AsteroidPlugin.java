package emil.komp.asteroids.Asteroids;

import emil.komp.asteroids.common.Data.Entity;
import emil.komp.asteroids.common.Data.Gamedata;
import emil.komp.asteroids.common.Data.World;
import emil.komp.asteroids.common.services.IGamePluginService;
import emil.komp.asteroids.common.asteroids.asteroid;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AsteroidPlugin implements IGamePluginService {

    private ScheduledExecutorService scheduler;

    @Override
    public void start(Gamedata gamedata, World world) {

        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(() -> {
            Entity asteroid = createAsteroid(gamedata);
            world.addEntity(asteroid);
        }, 0, 3, TimeUnit.SECONDS);
    }

    @Override
    public void stop(Gamedata gamedata, World world) {


            scheduler.shutdownNow();




        for (Entity asteroid : world.getEntities(asteroid.class)) {
            world.removeEntity(asteroid);
        }
    }

    private Entity createAsteroid(Gamedata gamedata) {
        Entity asteroid = new asteroid();
        Random rand = new Random();
        int size = 6;
        asteroid.setPolygonCoordinates(size, -size, -size, -size, -size, size, size, size);
        asteroid.setX(rand.nextInt(gamedata.getDisplayWidth()));
        asteroid.setY(rand.nextInt(gamedata.getDisplayHeight()));
        asteroid.setRadius(size);
        asteroid.setRotation(rand.nextInt(90));
        return asteroid;

    }
}
