package emil.komp.asteroids.common.bullet;

import emil.komp.asteroids.common.Data.Entity;
import emil.komp.asteroids.common.Data.Gamedata;

public interface BulletSPI {
    Entity CreateBullet(Entity entity, Gamedata gamedata);

}
