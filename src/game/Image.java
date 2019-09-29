package game;

import javax.imageio.ImageIO;
import javax.tools.Tool;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {

    File img1 = new File("src\\texture\\0.png");
    File img2 = new File("src\\texture\\1.png");
    File img3 = new File("src\\texture\\2.png");
    File img4 = new File("src\\texture\\3.png");

    BufferedImage img01 = ImageIO.read(img1);
    BufferedImage img02 = ImageIO.read(img2);
    BufferedImage img03 = ImageIO.read(img3);
    BufferedImage img04 = ImageIO.read(img4);

    BufferedImage[] images = {img01, img02, img03, img04};

    public BufferedImage makeittransparent(BufferedImage image) {
        BufferedImage tmpImg = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) tmpImg.getGraphics();
        g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
        image = tmpImg;
        return image;
    }


    public Image() throws IOException {
    }
}
