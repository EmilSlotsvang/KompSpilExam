package emil.komp.asteroids.Asteroids;

import emil.komp.asteroids.common.Data.Entity;
import emil.komp.asteroids.common.Data.Gamedata;
import emil.komp.asteroids.common.Data.World;
import emil.komp.asteroids.common.asteroids.asteroid;
import emil.komp.asteroids.common.asteroids.IAsteroidSplitter;
import emil.komp.asteroids.common.services.IEntityProcessingService;

public class AsteroidProcessor implements IEntityProcessingService {

    private IAsteroidSplitter asteroidSplitter = new AsteroidSplitterImpl();

    @Override
    public void process(Gamedata gamedata, World world) {
        for (Entity asteroid : world.getEntities(asteroid.class)) {
            double changeX = Math.cos(Math.toRadians(asteroid.getRotation()));
            double changeY = Math.sin(Math.toRadians(asteroid.getRotation()));

            asteroid.setX(asteroid.getX() + changeX * 0.5);
            asteroid.setY(asteroid.getY() + changeY * 0.5);

            if (asteroid.getX() < 0) {
                asteroid.setX(asteroid.getX() * -gamedata.getDisplayWidth());
            }
            if (asteroid.getX() > gamedata.getDisplayWidth()) {
                asteroid.setX(asteroid.getX() % gamedata.getDisplayWidth());
            }
            if (asteroid.getY() < 0) {
                asteroid.setX(asteroid.getY() * -gamedata.getDisplayWidth());
            }
            if (asteroid.getY() > gamedata.getDisplayWidth()) {
                asteroid.setX(asteroid.getY() % gamedata.getDisplayWidth());
            }

        }
    }


}
