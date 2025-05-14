package emil.komp.asteroids.Player;

import emil.komp.asteroids.common.Data.Entity;
import emil.komp.asteroids.common.Data.Gamedata;
import emil.komp.asteroids.common.services.IEntityProcessingService;
import emil.komp.asteroids.common.Data.GameKeys;
import emil.komp.asteroids.common.Data.World;
import emil.komp.asteroids.common.bullet.BulletSPI;

import java.util.Collection;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;


public class PlayerControlSystem implements IEntityProcessingService {


    @Override
    public void process(Gamedata gamedata, World world) {

        for (Entity player : world.getEntities(Player.class)) {
            if (gamedata.getKeys().isDown(GameKeys.LEFT)) {
                player.setRotation(player.getRotation() - 5);
            }
            if (gamedata.getKeys().isDown(GameKeys.RIGHT)) {
                player.setRotation(player.getRotation() + 5);
            }
            if (gamedata.getKeys().isDown(GameKeys.UP)) {
                double changeX = Math.cos(Math.toRadians(player.getRotation()));
                double changeY = Math.sin(Math.toRadians(player.getRotation()));
                player.setX(player.getX() + changeX);
                player.setY(player.getY() + changeY);
            }
            if(gamedata.getKeys().isDown(GameKeys.SPACE)) {
                getBulletSPIs().stream().findFirst().ifPresent(
                        spi -> {world.addEntity(spi.CreateBullet(player, gamedata));}
                );
            }

            if (player.getX() < 0) {
                player.setX(1);
            }

            if (player.getX() > gamedata.getDisplayWidth()) {
                player.setX(gamedata.getDisplayWidth()-1);
            }

            if (player.getY() < 0) {
                player.setY(1);
            }

            if (player.getY() > gamedata.getDisplayHeight()) {
                player.setY(gamedata.getDisplayHeight()-1);
            }

        }
    }

    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }

    }

