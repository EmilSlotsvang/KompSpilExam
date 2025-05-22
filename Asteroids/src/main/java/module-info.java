import emil.komp.asteroids.common.services.IEntityProcessingService;
import emil.komp.asteroids.common.services.IGamePluginService;
import emil.komp.asteroids.common.asteroids.IAsteroidSplitter;

module Asteroids {
    requires Common;
    requires Commonasteroids;


    provides IGamePluginService with emil.komp.asteroids.Asteroids.AsteroidPlugin;
    provides IEntityProcessingService with emil.komp.asteroids.Asteroids.AsteroidProcessor;
    provides IAsteroidSplitter with emil.komp.asteroids.Asteroids.AsteroidSplitterImpl;
}