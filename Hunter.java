import java.awt.image.BufferedImage;


public class Hunter {
    private BufferedImage playerlocation;

    public BufferedImage player[] = new BufferedImage[1];

    private SpriteSheet playerss;

    public Hunter() {
        playerlocation = LoadImages.loadImages("/pic/tank.png");

        playerss = new SpriteSheet(playerlocation);

        getHunter();
    }

    public void getHunter() {
        player[0] = playerss.crop(0, 0, 60, 60);

    }


}