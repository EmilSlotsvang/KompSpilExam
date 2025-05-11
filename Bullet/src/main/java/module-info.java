import emil.komp.asteroids.common.bullet.BulletSPI;
import emil.komp.asteroids.common.services.IEntityProcessingService;
import emil.komp.asteroids.common.services.IGamePluginService;

module Bullet {
    requires Common;
    requires CommonBullet;
    provides IGamePluginService with emil.komp.asteroids.bulletsystem.BulletPlugin;
    provides BulletSPI with emil.komp.asteroids.bulletsystem.BulletControlSystem;
    provides IEntityProcessingService with emil.komp.asteroids.bulletsystem.BulletControlSystem;

}