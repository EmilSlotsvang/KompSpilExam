package emil.komp.asteroids.common.services;

import emil.komp.asteroids.common.Data.Gamedata;
import emil.komp.asteroids.common.Data.World;

public interface IGamePluginService {

    void start(Gamedata gamedata, World world);
    void stop(Gamedata gamedata, World world);
}
