package emil.komp.asteroids.main;

import emil.komp.asteroids.common.services.IEntityProcessingService;
import emil.komp.asteroids.common.services.IGamePluginService;
import emil.komp.asteroids.common.services.IPostEntityProcessingService;
import emil.komp.asteroids.common.services.IScore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ServiceLoader;


    @Configuration
    @ComponentScan(basePackages = "emil.komp.asteroids")
    public class SpringConf {

        @Bean
        public Iterable<IGamePluginService> gamePluginServices() {
            return ServiceLoader.load(IGamePluginService.class);
        }

        @Bean
        public Iterable<IEntityProcessingService> entityProcessingServices() {
            return ServiceLoader.load(IEntityProcessingService.class);
        }

        @Bean
        public Iterable<IPostEntityProcessingService> postEntityProcessingServices() {
            return ServiceLoader.load(IPostEntityProcessingService.class);
        }
       /*@Bean
        public IScore scores() {
            return ServiceLoader.load(IScore.class).findFirst().orElse(null);
        }

        */
    }
