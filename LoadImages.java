import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LoadImages {

    public static BufferedImage loadImages(String location) {
        try {
            return ImageIO.read(LoadImages.class.getResource(location));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        return null;
    }


}