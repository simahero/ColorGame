package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.io.IOException;

public class Driver implements Runnable{

    JFrame frame;
    static Canvas canvas;
    static ColorManager colorManager = new ColorManager();
    Image image = new Image();
    static boolean running = true;
    static int count;
    static JLabel label = new JLabel("");


    public Driver() throws IOException {
        frame = new JFrame("COLOR GAME");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label.setLayout(null);
        frame.add(canvas = new Canvas());
        frame.addKeyListener(new Game());
        //frame.add(label);
        frame.setSize(640,400);
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
        g.drawImage(image.images[colorManager.status], 320 , 0, null);
        g.dispose();
        bs.show();
    }

    public static void updare(){
        if (Game.selected != Game.colors[ColorManager.laststatus]){
            running = false;
        } else {
            colorManager.getRandom();
            count += 100;
            label.setText("Score:" + count);
        }
    }



    @Override
    public void run() {
        BasicTimer timer = new BasicTimer(120);
        while (running) {
            timer.sync();
            render();
            System.out.println(colorManager.status);

            if (running == false){
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }

        }
    }


    public static void main(String[] args) throws IOException {
        new Driver();
    }

}
