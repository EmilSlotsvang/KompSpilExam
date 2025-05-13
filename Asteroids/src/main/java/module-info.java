import emil.komp.asteroids.common.services.IEntityProcessingService;
import emil.komp.asteroids.common.services.IGamePluginService;

module Asteroids {
    requires Commonasteroids;
    requires Common;
    provides IGamePluginService with emil.komp.asteroids.Asteroids.AsteroidPlugin;
    provides IEntityProcessingService with emil.komp.asteroids.Asteroids.AsteroidProcessor;
}