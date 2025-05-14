package emil.komp.asteroids.Player;

import emil.komp.asteroids.common.Data.Gamedata;
import emil.komp.asteroids.common.Data.World;
import emil.komp.asteroids.common.services.IGamePluginService;
import emil.komp.asteroids.common.Data.Entity;


public class PlayerPlugin implements IGamePluginService {

    private Entity player;

    public PlayerPlugin() {

    }


    @Override
    public void start(Gamedata gamedata, World world) {
    player = CreatePlayerShip(gamedata);
    world.addEntity(player);

    }

    private Entity CreatePlayerShip(Gamedata gamedata) {

        Entity PlayerShip = new Player();
        PlayerShip.setPolygonCoordinates(-5,-5,10,0,-5,5);
        PlayerShip.setX(gamedata.getDisplayHeight()/2);
        PlayerShip.setY(gamedata.getDisplayWidth()/2);
        PlayerShip.setRadius(8);
        return PlayerShip;

    }

    @Override
    public void stop(Gamedata gamedata, World world) {

        world.removeEntity(player);
    }
}
