package emil.komp.asteroids.collisionSystem;

import emil.komp.asteroids.common.Data.Entity;
import emil.komp.asteroids.common.Data.World;
import emil.komp.asteroids.common.Data.Gamedata;
import emil.komp.asteroids.common.services.IPostEntityProcessingService;



public class CollisionDetector implements IPostEntityProcessingService {



    @Override
    public void process(Gamedata gamedata, World world) {

        for( Entity e1 : world.getEntities() ) {
            for( Entity e2 : world.getEntities() ) {
            if(e1.getId().equals(e2.getId())) {
                continue;
            }
            if(this.collides(e1, e2)) {

                world.removeEntity(e1);
                world.removeEntity(e2);

            }
            }
        }
    }

    public boolean collides(Entity e1, Entity e2) {
        float dx= (float) e1.getX()-(float) e2.getX();
        float dy= (float) e1.getY()-(float) e2.getY();
        float distance = (float) Math.sqrt(dx*dx+dy*dy);
        return distance <(e1.getRadius() + e2.getRadius());
    }
}
