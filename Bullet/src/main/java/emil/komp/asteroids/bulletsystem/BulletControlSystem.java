package emil.komp.asteroids.bulletsystem;

import emil.komp.asteroids.common.Data.Entity;
import emil.komp.asteroids.common.Data.Gamedata;
import emil.komp.asteroids.common.Data.World;
import emil.komp.asteroids.common.bullet.Bullet;
import emil.komp.asteroids.common.bullet.BulletSPI;
import emil.komp.asteroids.common.services.IEntityProcessingService;



public class BulletControlSystem implements IEntityProcessingService, BulletSPI {
    @Override
    public void process(Gamedata gamedata, World world) {

        for(Entity bullet : world.getEntities(Bullet.class)) {
            double changeX = Math.cos(Math.toRadians(bullet.getRotation()));
            double changeY = Math.sin(Math.toRadians(bullet.getRotation()));
            bullet.setX(bullet.getX()+changeX*3);
            bullet.setY(bullet.getY()+changeY*3);
        }
    }


    @Override
    public Entity CreateBullet(Entity entity, Gamedata gamedata) {
        Entity bullet = new Bullet();
        bullet.setPolygonCoordinates(1, -1, 1, 1, -1, 1, -1, -1);
        double changeX = Math.cos(Math.toRadians(entity.getRotation()));
        double changeY = Math.sin(Math.toRadians(entity.getRotation()));
        bullet.setX(entity.getX() + changeX*10);
        bullet.setY(entity.getY() + changeY*10);
        bullet.setRotation(entity.getRotation());
        bullet.setRadius(1);
        return bullet;
    }
}