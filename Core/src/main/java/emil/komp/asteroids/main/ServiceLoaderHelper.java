package emil.komp.asteroids.main;

import emil.komp.asteroids.common.services.IEntityProcessingService;
import emil.komp.asteroids.common.services.IGamePluginService;
import emil.komp.asteroids.common.services.IPostEntityProcessingService;

import java.util.Collection;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;

public class ServiceLoaderHelper {

    public static Iterable<IGamePluginService> getPluginServices() {
        return ServiceLoader.load(IGamePluginService.class);
    }

    public static Iterable< IEntityProcessingService> getEntityProcessingServices() {
        return ServiceLoader.load(IEntityProcessingService.class);
    }

    public static Iterable<? extends IPostEntityProcessingService> getPostEntityProcessingServices() {
        return ServiceLoader.load(IPostEntityProcessingService.class);
    }
}
