import emil.komp.asteroids.common.services.IEntityProcessingService;
import emil.komp.asteroids.common.services.IGamePluginService;
import emil.komp.asteroids.common.services.IPostEntityProcessingService;

module Core {
    requires Common;
    requires javafx.graphics;

    requires spring.context;
        requires spring.core;
    requires spring.beans;

    exports emil.komp.asteroids.main to spring.context;

    opens emil.komp.asteroids.main to javafx.graphics, spring.core, spring.beans;

    uses emil.komp.asteroids.common.services.IEntityProcessingService;
    uses emil.komp.asteroids.common.services.IGamePluginService;
    uses emil.komp.asteroids.common.services.IPostEntityProcessingService;


}