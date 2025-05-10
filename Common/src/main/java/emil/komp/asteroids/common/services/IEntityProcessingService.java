package emil.komp.asteroids.common.services;

import emil.komp.asteroids.common.Data.World;
import emil.komp.asteroids.common.Data.Gamedata;

public interface IEntityProcessingService {

    void process(Gamedata gamedata, World world);
}
