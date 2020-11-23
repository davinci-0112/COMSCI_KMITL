import java.awt.image.BufferedImage;


public class Boss {
    private BufferedImage enemylocation;
    public BufferedImage enemy[] = new BufferedImage[1];
    private SpriteSheet enemyss;

    public Boss() {
        enemylocation = LoadImages.loadImages("/pic/too.png");

        enemyss = new SpriteSheet(enemylocation);

        getBoss();
    }

    public void getBoss() {
        enemy[0] = enemyss.crop(0, 0, 60, 60);

    }


}