import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
//import java.util.ArrayList;

public class Player {
    private int positionX = 0;
    private int positionY = 0;
    private int scaleX = 0;
    private int scaleY = 0;
    private int speedX = 0;
    private int speed = 0;
    private int direction = 0;
    private int FY = 0;
    private int FX = 0;
    //private int speedY = 0;

    private boolean Right = false;
    private boolean Left = false;
    private boolean Move = false;
    private boolean Shoot = false;

    private Hunter Hun;
    private Bullet b;
    private GamePanel gp;


    //static ArrayList bullets;

    public Player() {
        positionX = 325;
        positionY = 800;
        setScaleX(100);
        setScaleY(100);
        setspeed(7);
        FX = 325;
        FY = 800;

        Hun = new Hunter(); 
        b = new Bullet();
       // bullets = new ArrayList(); 
        
    }

    /*public static ArrayList getBullets() {

        return bullets;

    }*/

    /*public void fire() {
        
        
        //Bullet z = new Bullet(FX, FY);
       // bullets.add(z);
        
        //FY--;
        //System.out.println(FX + "  "+FY);
        
        
    }*/

    public void update() {
        Move();
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(Hun.player[0], positionX, positionY, scaleX, scaleY, null);
        
        while(Shoot == true) {
              
                g2.drawImage(b.bullet[0], FX +44, FY, 15, 30, null);
                FY -=30;
                if(FY <= 1) {Shoot = false;}
               // if(FY == gp.geteY()) {
                   // System.out.println(gp.geteY());
                
        }
        
    }

    public int reE() {
        return FY;
    }

    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            Right = true;
            setDirection(0);
           // Move = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            Left = true;
            setDirection(1);
           // Move = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            //fire();   
            Shoot = true;
            
        }
    }
    
    public void keyReleased(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){     
            Right = false;
            //Move = false;
            
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            Left = false;
            //Move = false;
            
        }
        
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            Shoot = false;
            //Move = false;
            
        }
        
    }

    

    

    public void Move() {
        if(positionX<=-3)positionX=564;
        if(positionX>=565)positionX=-2;

        if(Right == true) {
            positionX += speedX + speed;
            
        }

        if(Left == true) {
            positionX += speedX + -speed;
        }
        if(Shoot == true) {
             FX = positionX;
             FY = positionY;
            
        }
        
    }

    public int getPositionX(int positionX) {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX =positionX;
    }

    public int getPositionY(int positionY) {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getScaleX() {
        return scaleX;
    }

    public void setScaleX(int scaleX) {
        this.scaleX = scaleX;
    }

    public int getScaleY() {
        return scaleY;
    }

    public void setScaleY(int scaleY) {
        this.scaleY = scaleY;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    /*public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }*/

    public int getSpeed() {
        return speed;
    }

    public void setspeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}

 

