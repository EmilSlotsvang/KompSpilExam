package emil.komp.asteroids.collisionSystem;

import emil.komp.asteroids.common.Data.Entity;
import emil.komp.asteroids.common.Data.World;
import emil.komp.asteroids.common.Data.Gamedata;
import emil.komp.asteroids.common.services.IPostEntityProcessingService;
import emil.komp.asteroids.common.asteroids.IAsteroidSplitter;
import emil.komp.asteroids.common.services.IScore;

import java.util.ServiceLoader;

public class CollisionDetector implements IPostEntityProcessingService {

    int score = 0;
    @Override
    public void process(Gamedata gamedata, World world) {

        // Load splitter én gang i stedet for i hvert kald
        ServiceLoader<IAsteroidSplitter> loader = ServiceLoader.load(IAsteroidSplitter.class);
        IAsteroidSplitter splitter = loader.findFirst().orElse(null);


        //System.out.println();
        //ServiceLoader.load(IScore.class).findFirst().ifPresent(score -> {System.out.println(score.get());});

        for (Entity e1 : world.getEntities()) {
            for (Entity e2 : world.getEntities()) {

                if (e1.getId().equals(e2.getId())) continue;

                if (this.collides(e1, e2)) {

                    // Split begge hvis de er asteroider
                    if (splitter != null) {
                        if (isAsteroid(e1)) {
                            splitter.createAsteroids(e1, world);
                        }
                        if (isAsteroid(e2)) {
                            splitter.createAsteroids(e2, world);
                        }
                    }
                    System.out.println("[DEBUG] Removing entity: " + e1.getId());
                    world.removeEntity(e1);
                    world.removeEntity(e2);
                    //score = Integer.parseInt(ServiceLoader.load(IScore.class).findFirst().ifPresent(score -> {score.get();}));

                    break;
                }
            }
        }
    }

    public boolean collides(Entity e1, Entity e2) {
        float dx = (float) e1.getX() - (float) e2.getX();
        float dy = (float) e1.getY() - (float) e2.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        return distance < (e1.getRadius() + e2.getRadius());
    }

    private boolean isAsteroid(Entity entity) {
        return entity.getClass().getSimpleName().equals("asteroid");
    }
}