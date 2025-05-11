import emil.komp.asteroids.common.services.IPostEntityProcessingService;

module Collision {
    requires Common;
    provides IPostEntityProcessingService with emil.komp.asteroids.collisionSystem.CollisionDetector;
}