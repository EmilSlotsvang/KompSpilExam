package emil.komp.asteroids.Enemy;

import emil.komp.asteroids.common.Data.Entity;
import emil.komp.asteroids.common.Data.Gamedata;
import emil.komp.asteroids.common.Data.World;
import emil.komp.asteroids.common.services.IGamePluginService;

public class EnemyPlugin implements IGamePluginService {

    private Entity Enemy;

    public EnemyPlugin() {

    }

    @Override
    public void start(Gamedata gamedata, World world) {
        Enemy = createEnemy(gamedata);
        world.addEntity(Enemy);
    }


    private Entity createEnemy(Gamedata gamedata) {
        Entity enemy = new Enemy();
        enemy.setPolygonCoordinates(-5, -5, 10, 0, -5, 5);
        enemy.setX(gamedata.getDisplayHeight() / 4);
        enemy.setY(gamedata.getDisplayWidth() / 4);
        enemy.setRadius(8);
        return enemy;
    }

    @Override
    public void stop(Gamedata gamedata, World world) {
    world.removeEntity(Enemy);
    }



}
