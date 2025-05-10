package emil.komp.asteroids.common.Data;


public class Gamedata {

    private GameKeys keys = new GameKeys();

    public int getDisplayWidth() {
        return displayWidth;
    }

    public void setDisplayWidth(int displayWidth) {
        this.displayWidth = displayWidth;
    }

    public int getDisplayHeight() {
        return displayHeight;
    }

    public void setDisplayHeight(int displayHeight) {
        this.displayHeight = displayHeight;
    }

    private int displayWidth = 800;
    private int displayHeight = 800;


    public GameKeys getKeys() {
    return keys;

    }
}
