import java.awt.image.BufferedImage;

public class Bullet {

    private BufferedImage blocation;
    public BufferedImage bullet[] = new BufferedImage[1];
    private SpriteSheet bss;


    public int x,y ;



    public Bullet() {


        blocation = LoadImages.loadImages("/pic/bullet.png");
        bss = new SpriteSheet(blocation); 
        getBullet();
    }

    public void getBullet() {
        bullet[0] = bss.crop(0, 0, 15 , 30);

    }


}