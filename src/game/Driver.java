package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

public class Driver implements Runnable{

    JFrame frame;
    static Canvas canvas;
    static ColorManager colorManager = new ColorManager();
    static boolean running = true;

    public Driver(){
        frame = new JFrame("COLOR GAME");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas = new Canvas());
        frame.addKeyListener(new Game());
        frame.setSize(320,320);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        new Thread(this).start();

    }



    private void render() {
        BufferStrategy bs = canvas.getBufferStrategy();
        if (bs == null){
            canvas.createBufferStrategy(2);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(colorManager.getColor());
        g.fillRect(0,0,320,320);
        g.dispose();
        bs.show();
    }

    public static void updare(){
        if (Game.selected != Game.colors[ColorManager.laststatus]){
            running = false;
        } else {
            colorManager.getRandom();
        }
    }



    @Override
    public void run() {
        BasicTimer timer = new BasicTimer(60);
        while (running) {
            timer.sync();
            render();
            System.out.println(colorManager.status);

            if (running == false){
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }

        }
    }


    public static void main(String[] args) {
        new Driver();
    }

}
