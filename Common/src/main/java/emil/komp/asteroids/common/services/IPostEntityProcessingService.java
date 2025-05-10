package emil.komp.asteroids.common.services;

import emil.komp.asteroids.common.Data.Gamedata;
import emil.komp.asteroids.common.Data.World;

public interface IPostEntityProcessingService {
    void process(Gamedata gamedata, World world);
}
