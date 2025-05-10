package emil.komp.asteroids.common.Data;

import java.io.Serializable;
import java.util.UUID;

public class Entity implements Serializable {

private final UUID Id = UUID.randomUUID();

double[] polygonCoordinates;


    double x;
    double y;

    double rotation;

    float radius;

    public String getId() {
        return Id.toString();
    }

    public void setPolygonCoordinates(double... coordinates) {
        this.polygonCoordinates = coordinates;
    }

    public double[] getPolygonCoordinates() {
        return polygonCoordinates;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

 }
