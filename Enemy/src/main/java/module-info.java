import emil.komp.asteroids.common.services.IEntityProcessingService;
import emil.komp.asteroids.common.services.IGamePluginService;

module Enemy {
    requires Common;
    requires CommonBullet;

    uses emil.komp.asteroids.common.bullet.BulletSPI;

    provides IEntityProcessingService with emil.komp.asteroids.Enemy.EnemySpaceshipControlSystem;
    provides IGamePluginService with emil.komp.asteroids.Enemy.EnemyPlugin;
}