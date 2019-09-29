package game;

import java.awt.*;

public class ColorManager {
    static int status;
    static int laststatus;


    public int getRandom() {
        int random = (int) (Math.random() * 4);
        status = random;
        if (status == laststatus) {
            getRandom();
        }
        return status;
    }

    public Color getColor() {
        Color c = Game.colors[status];
        laststatus = status;
        return c;
    }

}
