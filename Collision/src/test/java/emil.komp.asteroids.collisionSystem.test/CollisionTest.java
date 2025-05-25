package emil.komp.asteroids.collisionSystem.test;


import org.junit.jupiter.api.Test;

import emil.komp.asteroids.common.Data.Entity;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CollisionTest {

    @Test
    void testCollisionDetection() {

        Entity playerShip = new Entity();
        playerShip.setX(50);
        playerShip.setY(50);
        playerShip.setRadius(10);
        System.out.println("This is the test telling you to pass ");

        Entity asteroid = new Entity();
        asteroid.setX(55);
        asteroid.setY(55);
        asteroid.setRadius(10);

        assertTrue(isColliding(playerShip, asteroid), "Collision should be detected");

        asteroid.setX(100);
        asteroid.setY(100);

        assertFalse(isColliding(playerShip, asteroid), "Collision should not be detected");
    }

    private boolean isColliding(Entity entity1, Entity entity2) {
        double dx = entity1.getX() - entity2.getX();
        double dy = entity1.getY() - entity2.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance < (entity1.getRadius() + entity2.getRadius());
    }
}