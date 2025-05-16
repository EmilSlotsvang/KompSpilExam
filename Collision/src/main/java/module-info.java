import emil.komp.asteroids.common.services.IPostEntityProcessingService;

module Collision {
    requires Common;
    provides IPostEntityProcessingService with emil.komp.asteroids.collisionSystem.CollisionDetector;
    requires Commonasteroids;
    uses emil.komp.asteroids.common.asteroids.IAsteroidSplitter;



}