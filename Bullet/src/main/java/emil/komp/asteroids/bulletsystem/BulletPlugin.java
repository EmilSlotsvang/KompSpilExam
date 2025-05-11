package emil.komp.asteroids.bulletsystem;

import emil.komp.asteroids.common.Data.Entity;
import emil.komp.asteroids.common.Data.Gamedata;
import emil.komp.asteroids.common.Data.World;
import emil.komp.asteroids.common.bullet.Bullet;
import emil.komp.asteroids.common.services.IGamePluginService;

public class BulletPlugin implements IGamePluginService {
    @Override
    public void start(Gamedata gamedata, World world) {

    }

    @Override
    public void stop(Gamedata gamedata, World world) {
        for(Entity e : world.getEntities()){
            if(e.getClass() == Bullet.class){
                world.removeEntity(e);
            }
        }
    }
}
