package emil.komp.asteroids.common.Data;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class World {

private final Map<String, Entity> entityMap = new ConcurrentHashMap<>();

    public String addEntity(Entity entity){
        entityMap.put(entity.getId(), entity);
        return entity.getId();


    }


    public void removeEntity(Entity entity) {
        entityMap.remove(entity.getId());
    }

    public Collection<Entity> getEntities() {
        return entityMap.values();
    }

    public<E extends Entity> List<Entity> getEntities(Class<E>... entityTypes){
        List <Entity> r = new ArrayList<>();
        for (Entity e : getEntities()) {
            for (Class<E> entityType : entityTypes) {
                if (entityType.equals(e.getClass())) {
                    r.add(e);
                }
            }
        }
    return r;

    }

    public Entity getEntity(String id) {
    return entityMap.get(id);
    }


}