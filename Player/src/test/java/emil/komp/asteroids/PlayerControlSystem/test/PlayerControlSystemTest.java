package emil.komp.asteroids.PlayerControlSystem.test;

import emil.komp.asteroids.Player.Player;
import emil.komp.asteroids.Player.PlayerControlSystem;
import emil.komp.asteroids.common.Data.Entity;
import emil.komp.asteroids.common.Data.Gamedata;
import emil.komp.asteroids.common.Data.GameKeys;
import emil.komp.asteroids.common.Data.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlayerControlSystemTest {

    private PlayerControlSystem playerControlSystem;
    private Gamedata gamedata;
    private World world;
    private Entity player;
    private GameKeys keys;

    @BeforeEach
    public void setup() {
        playerControlSystem = new PlayerControlSystem();
        gamedata = mock(Gamedata.class);
        world = mock(World.class);
        keys = mock(GameKeys.class);

        when(gamedata.getKeys()).thenReturn(keys);
        when(gamedata.getDisplayWidth()).thenReturn(800);
        when(gamedata.getDisplayHeight()).thenReturn(600);

        player = new Entity();
        player.setX(100);
        player.setY(100);
        player.setRotation(0);

        when(world.getEntities(Player.class)).thenReturn(Collections.singletonList(player));
    }

    @Test
    public void testPlayerMovesUp() {
        when(keys.isDown(GameKeys.UP)).thenReturn(true);

        playerControlSystem.process(gamedata, world);

        assertTrue(player.getX() > 100, "Player should move right at rotation 0");
        assertEquals(100, player.getY(), 0.01, "Y should remain unchanged at rotation 0");
    }

    @Test
    public void testPlayerRotatesLeft() {
        when(keys.isDown(GameKeys.LEFT)).thenReturn(true);

        playerControlSystem.process(gamedata, world);

        assertEquals(-5, player.getRotation(), "Player should rotate -5 degrees");
    }

    @Test
    public void testPlayerRotatesRight() {
        when(keys.isDown(GameKeys.RIGHT)).thenReturn(true);

        playerControlSystem.process(gamedata, world);

        assertEquals(5, player.getRotation(), "Player should rotate +5 degrees");
    }

    @Test
    public void testPlayerScreenWrappingLeft() {
        player.setX(-10);

        playerControlSystem.process(gamedata, world);

        assertEquals(1, player.getX(), "Player should wrap to x=1 if out of bounds");
    }

    @Test
    public void testPlayerScreenWrappingBottom() {
        player.setY(700);

        playerControlSystem.process(gamedata, world);

        assertEquals(599, player.getY(), "Player should stay inside bottom screen edge");
    }
}
