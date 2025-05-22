package emil.komp.asteroids.common.services;

import emil.komp.asteroids.common.Data.Gamedata;
import emil.komp.asteroids.common.Data.World;

/**
 * Interface for game plugin services that can be started and stopped within the game engine.
 * Implementations of this interface define the setup and teardown behavior for specific game modules.
 */
public interface IGamePluginService {

    /**
     * Initializes and adds entities or resources to the game world.
     *
     * @param gamedata the game data containing settings and configurations
     * @param world    the game world where entities should be added or initialized
     */
    void start(Gamedata gamedata, World world);

    /**
     * Removes entities or cleans up resources from the game world.
     *
     * @param gamedata the game data containing settings and configurations
     * @param world    the game world where entities should be removed or cleaned up
     */
    void stop(Gamedata gamedata, World world);
}