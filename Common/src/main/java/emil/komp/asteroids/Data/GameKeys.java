package emil.komp.asteroids.Data;

public class GameKeys {

    private static Boolean[] key;
    private static Boolean[] Pkey;

    private static final int NUM_KEYS =5;

    public static final int UP = 0;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int SPACE = 3;

    public GameKeys() {
    key = new Boolean[NUM_KEYS];
    Pkey = new Boolean[NUM_KEYS];
    }

    public void update(){
        for (int i = 0; i <NUM_KEYS ; i++) {
        Pkey[i] = key[i];
        }
    }

    public void setKey(int k, Boolean b) {
        key[k]=b;

    }

    public boolean isDown (int k) {
    return key [k];
    }

    public boolean isUp (int k) {
    return key[k] && !Pkey[k];
    }
}
