import emil.komp.asteroids.common.services.IEntityProcessingService;
import emil.komp.asteroids.common.services.IGamePluginService;

module Player {
    requires Common;
    requires CommonBullet;

    uses emil.komp.asteroids.common.bullet.BulletSPI;
    provides IEntityProcessingService with emil.komp.asteroids.Player.PlayerControlSystem;
    provides IGamePluginService with emil.komp.asteroids.Player.PlayerPlugin;


}