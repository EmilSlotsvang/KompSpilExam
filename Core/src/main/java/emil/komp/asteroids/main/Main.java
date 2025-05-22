package emil.komp.asteroids.main;


import emil.komp.asteroids.common.Data.*;
import emil.komp.asteroids.common.services.IEntityProcessingService;
import emil.komp.asteroids.common.services.IGamePluginService;
import emil.komp.asteroids.common.services.IPostEntityProcessingService;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main extends Application {

    private final Gamedata gameData = new Gamedata();
    private final World world = new World();
    private final Map<Entity, Polygon> polygons = new ConcurrentHashMap<>();
    private final Pane gameWindow = new Pane();

    private Iterable<IGamePluginService> gamePluginServices;
    private Iterable<IEntityProcessingService> entityProcessingServices;
    private Iterable<IPostEntityProcessingService> postEntityProcessingServices;

    public static void main(String[] args) {
        launch(Main.class);
    }


    
    @Override
    public void start(Stage window) throws Exception {
        // Initialize Spring application context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConf.class);

        // Retrieve beans from SpringConfig
        gamePluginServices = context.getBean("gamePluginServices", Iterable.class);
        entityProcessingServices = context.getBean("entityProcessingServices", Iterable.class);
        postEntityProcessingServices = context.getBean("postEntityProcessingServices", Iterable.class);


        gameWindow.setPrefSize(gameData.getDisplayWidth(), gameData.getDisplayHeight());


        Scene scene = new Scene(gameWindow);
        scene.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.LEFT)) {
                gameData.getKeys().setKey(GameKeys.LEFT, true);
            }
            if (event.getCode().equals(KeyCode.RIGHT)) {
                gameData.getKeys().setKey(GameKeys.RIGHT, true);
            }
            if (event.getCode().equals(KeyCode.UP)) {
                gameData.getKeys().setKey(GameKeys.UP, true);
            }
            if (event.getCode().equals(KeyCode.SPACE)) {
                gameData.getKeys().setKey(GameKeys.SPACE, true);
            }
        });
        scene.setOnKeyReleased(event -> {
            if (event.getCode().equals(KeyCode.LEFT)) {
                gameData.getKeys().setKey(GameKeys.LEFT, false);
            }
            if (event.getCode().equals(KeyCode.RIGHT)) {
                gameData.getKeys().setKey(GameKeys.RIGHT, false);
            }
            if (event.getCode().equals(KeyCode.UP)) {
                gameData.getKeys().setKey(GameKeys.UP, false);
            }
            if (event.getCode().equals(KeyCode.SPACE)) {
                gameData.getKeys().setKey(GameKeys.SPACE, false);
            }
        });

        // Use Spring beans instead of ServiceLoaderHelper
        for (IGamePluginService iGamePlugin : gamePluginServices) {
            iGamePlugin.start(gameData, world);
        }
        for (Entity entity : world.getEntities()) {
            Polygon polygon = new Polygon(entity.getPolygonCoordinates());
            polygons.put(entity, polygon);
            gameWindow.getChildren().add(polygon);
        }
        render();
        window.setScene(scene);
        window.setTitle("ASTEROIDS");
        window.show();
    }

    private void render() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                draw();
                gameData.getKeys().update();
            }
        }.start();
    }

    private void update() {
        for (IEntityProcessingService entityProcessorService : entityProcessingServices) {
            entityProcessorService.process(gameData, world);
        }
        for (IPostEntityProcessingService postEntityProcessorService : postEntityProcessingServices) {
            postEntityProcessorService.process(gameData, world);
        }
    }

    private void draw() {
        for (Entity polygonEntity : polygons.keySet()) {
            if (!world.getEntities().contains(polygonEntity)) {
                Polygon removedPolygon = polygons.get(polygonEntity);
                polygons.remove(polygonEntity);
                gameWindow.getChildren().remove(removedPolygon);
            }
        }

        for (Entity entity : world.getEntities()) {
            Polygon polygon = polygons.get(entity);
            if (polygon == null) {
                polygon = new Polygon(entity.getPolygonCoordinates());
                polygons.put(entity, polygon);
                gameWindow.getChildren().add(polygon);
            }
            polygon.setTranslateX(entity.getX());
            polygon.setTranslateY(entity.getY());
            polygon.setRotate(entity.getRotation());
        }
    }
}
/*
public class Main extends Application {

    private  final SpringConf serviceLoaderHelper = new SpringConf();
    private final Gamedata gamedata = new Gamedata();

    private final World world = new World();
    private final Map <Entity, Polygon> polygons = new ConcurrentHashMap<>();
    private final Pane gameWindow = new Pane();


    public static void main(String[] args) {
        System.out.println("Hello World!");
        launch(Main.class);
    }

    @Override
    public void start(Stage stage) throws Exception {

        gameWindow.setPrefSize(gamedata.getDisplayHeight(), gamedata.getDisplayHeight());
        // Text text = new Text(10,10,IPostEntityProcessingService.getKillsteak);
        Scene scene = new Scene (gameWindow);

        scene.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.LEFT)) {
                gamedata.getKeys().setKey(GameKeys.LEFT, true);
            }
            if (event.getCode().equals(KeyCode.RIGHT)) {
                gamedata.getKeys().setKey(GameKeys.RIGHT, true);
            }
            if (event.getCode().equals(KeyCode.UP)) {
                gamedata.getKeys().setKey(GameKeys.UP, true);
            }
            if (event.getCode().equals(KeyCode.SPACE)) {
                gamedata.getKeys().setKey(GameKeys.SPACE, true);
            }
        });
        scene.setOnKeyReleased(event -> {
            if (event.getCode().equals(KeyCode.LEFT)) {
                gamedata.getKeys().setKey(GameKeys.LEFT, false);
            }
            if (event.getCode().equals(KeyCode.RIGHT)) {
                gamedata.getKeys().setKey(GameKeys.RIGHT, false);
            }
            if (event.getCode().equals(KeyCode.UP)) {
                gamedata.getKeys().setKey(GameKeys.UP, false);
            }
            if (event.getCode().equals(KeyCode.SPACE)) {
                gamedata.getKeys().setKey(GameKeys.SPACE, false);
            }

        });

            for (IGamePluginService iGamePlugin : serviceLoaderHelper.getPluginServices()){
                iGamePlugin.start(gamedata, world);
            }
            for (Entity entity : world.getEntities()){
                Polygon polygon = new Polygon(entity.getPolygonCoordinates());
                polygons.put(entity, polygon);
                gameWindow.getChildren().add(polygon);
            }
            render();
            stage.setScene(scene);
            stage.setTitle("Exam game");
            stage.show();



    }
    private void render(){
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                draw();
                gamedata.getKeys().update();
            }
        }.start();
    }

    private void update() {
        for (IEntityProcessingService entityProcessorService : serviceLoaderHelper.getEntityProcessingServices()) {
            entityProcessorService.process(gamedata, world);
        }

        for (IPostEntityProcessingService postEntityProcessorService : serviceLoaderHelper.getPostEntityProcessingServices()) {
            postEntityProcessorService.process(gamedata, world);
        }
    }

    private void draw(){
        for (Entity polygonEntity : polygons.keySet()){
            if(!world.getEntities().contains(polygonEntity)){
                Polygon removePolygon = polygons.get(polygonEntity);
                polygons.remove(polygonEntity);
                gameWindow.getChildren().remove(removePolygon);

            }
        }
        for (Entity entity : world.getEntities()){
            Polygon polygon = polygons.get(entity);
            if (polygon == null){
                polygon = new Polygon(entity.getPolygonCoordinates());
                polygons.put(entity, polygon);
                gameWindow.getChildren().add(polygon);
            }
            polygon.setTranslateX(entity.getX());
            polygon.setTranslateY(entity.getY());
            polygon.setRotate(entity.getRotation());


        }

        }
    }

 */
