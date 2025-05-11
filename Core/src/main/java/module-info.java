module Core {
    requires Common;
    requires javafx.graphics;

    opens emil.komp.asteroids.main to javafx.graphics;

    uses emil.komp.asteroids.common.services.IEntityProcessingService;
    uses emil.komp.asteroids.common.services.IGamePluginService;
    uses emil.komp.asteroids.common.services.IPostEntityProcessingService;

}