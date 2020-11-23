import java.awt.image.BufferedImage;

public class SpriteSheet {

    BufferedImage images;

    public SpriteSheet(BufferedImage images) {
        this.images = images;
    }

    public BufferedImage crop(int x, int y, int crop1, int crop2) {
        return images.getSubimage(x,y,crop1,crop2);
    }


}