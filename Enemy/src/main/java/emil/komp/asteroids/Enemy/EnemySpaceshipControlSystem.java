package emil.komp.asteroids.Enemy;

import emil.komp.asteroids.common.Data.Entity;
import emil.komp.asteroids.common.Data.Gamedata;
import emil.komp.asteroids.common.Data.World;
import emil.komp.asteroids.common.services.IEntityProcessingService;
import emil.komp.asteroids.common.bullet.BulletSPI;

import java.util.Collection;
import java.util.Random;
import java.util.ServiceLoader;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toList;

import static java.util.stream.Collectors.toList;



public class EnemySpaceshipControlSystem implements IEntityProcessingService {

    private Random random = new Random();
    private final Map<Entity, Long> lastShotTimes = new HashMap<>();
    private final long cooldownMs = 2000;

    @Override
    public void process(Gamedata gameData, World world) {
        long currentTime = System.currentTimeMillis();

        for (Entity enemy : world.getEntities(Enemy.class)) {
            float randomnumber = random.nextFloat(0, 1);
            long lastShot = lastShotTimes.getOrDefault(enemy, 0L);

            if (randomnumber > 0.75 && (currentTime - lastShot) >= cooldownMs) {

                getBulletSPIs().stream().findFirst().ifPresent(
                        spi -> {
                            world.addEntity(spi.CreateBullet(enemy, gameData));
                            lastShotTimes.put(enemy, currentTime);
                        }
                );
            }

            if (randomnumber > 0.40 && randomnumber <= 0.75) {
                // Moves Left
                enemy.setRotation(enemy.getRotation() - 5);
            } else if (randomnumber > 0.25 && randomnumber <= 0.40) {
                // Moves Right
                enemy.setRotation(enemy.getRotation() + 5);
            } else if (randomnumber > 0 && randomnumber <= 0.60) {
                // Moves Forward
                double changeX = Math.cos(Math.toRadians(enemy.getRotation()));
                double changeY = Math.sin(Math.toRadians(enemy.getRotation()));
                enemy.setX(enemy.getX() + changeX);
                enemy.setY(enemy.getY() + changeY);
            }

            // Screen boundaries
            if (enemy.getX() < 0) {
                enemy.setX(1);
            }
            if (enemy.getX() > gameData.getDisplayWidth()) {
                enemy.setX(gameData.getDisplayWidth() - 1);
            }
            if (enemy.getY() < 0) {
                enemy.setY(1);
            }
            if (enemy.getY() > gameData.getDisplayHeight()) {
                enemy.setY(gameData.getDisplayHeight() - 1);
            }
        }
    }

    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}