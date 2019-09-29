package game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public class Game implements KeyListener {

    static Color r = Color.RED;
    static Color y = Color.YELLOW;
    static Color b = Color.CYAN;
    static Color g = Color.green;

    static Color selected;

    static Color[] colors = {r, y, b, g};

    static int pressedkey;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == VK_UP){
            selected = b;
            pressedkey = 0;
            notyfyall();
        }
        if (e.getKeyCode() == VK_RIGHT){
            selected = r;
            pressedkey = 1;
            notyfyall();
        }
        if (e.getKeyCode() == VK_DOWN){
            selected = y;
            pressedkey = 2;
            notyfyall();
        }
        if (e.getKeyCode() == VK_LEFT){
            selected = g;
            pressedkey = 3;
            notyfyall();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void notyfyall(){
        Driver.updare();
    }
}
