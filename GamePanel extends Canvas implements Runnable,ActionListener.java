import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.*;


public class GamePanel extends Canvas implements Runnable,ActionListener{
    
    private  int Width = 0; 
    private  int Height = 0;
 //private  int FPS = 60;
    private  int ticks = 0;
    private  int second = 0;
    private  int minute = 0;
    private int totalEnemy = 40; //กำหนดจำนวนศัตรู

    private boolean running = false;//ให้การเริ่มเกมเป็นfalse
    private Thread thread;
   

    private Player player;
    private BufferedImage bglocation;
    private Enemy enemy;
    private Bullet bullet;
   // private Control c;      //

    private int enemyX = 0;
    private int enemyY = 0;
    private int positionX = 0;
    private int positionY = 0; 

    
    
    public GamePanel(int x, int y) {
        Width = x;
        Height = y;
        thread = new Thread(this,"Dispaly");
        player = new Player();
        bullet = new Bullet();
        enemy = new Enemy(5, 8); // กำหนกให้ศัตรูมี 5 แถว แถวละ 8 ตัว
        
        bglocation = LoadImages.loadImages("/pic/bg.jpg");
        
        this.setFocusable(true); //ใช้กำหนดว่า view สามารถ ได้รับ focus หรือไม่
        this.addKeyListener(new KeyInput(player));
        this.setPreferredSize(new Dimension(Width, Height));
        this.setMinimumSize(new Dimension(Width, Height));
        this.setMaximumSize(new Dimension(Width, Height));
    }

    public synchronized void start() {//synchronized(ขณะนั้นจะมีเพียง thread เดียวเท่านั้นที่กำลังทำงาน)
        
        if(running == false) {
            running = true;
            thread.start();
        }
    }

    public synchronized void stop() {
        if(running == true) {
            running = false;
            try {                               //ในบล็อคคำสั่งของ try เป็นส่วนของโปรแกรมที่อาจจะทำให้เกิด exception ขึ้น 
                thread.join();
            } catch (InterruptedException e) {  //catch เป็นการจัดการกับ exception แต่ละแบบ
                e.printStackTrace();            // ใช้ในการบอกรายละเอียดเกี่ยวกับข้อผิดพลาดให้กับเรา เช่น บรรทัดที่ทำให้เกิดความผิดพลาด และคลาสที่รัน
            }
        }
        
    }
    
    @Override
    public void run() {                             //ทำเวลา นาที : วินาที
        
        double tickPerTime = 1000000000 / 60;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        while (running == true) {

            now = System.nanoTime();
            delta +=(now - lastTime) / tickPerTime;
            timer += now - lastTime;
            lastTime = now;
            
            if(delta >= 1) {
                update();
                draw();
                ticks++;
                if(ticks == 60 ) second++ ;     if(second == 60)    {second=0; minute++ ;}
                delta--;
            }
            if(timer >= 1000000000) {  
                
                timer = 0;          
                ticks = 0;          //ไม่ให้เกิน60
            }
        }
        stop();
    }    

    

    public void update() {
        player.update();
        //bullet.update();
        
        //enemy.update();
       // c.update();         //
        
    }

    public void draw() {

        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics2D g2 = (Graphics2D) bs.getDrawGraphics();

        g2.clearRect(0, 0, Width, Height);
        
        g2.drawImage(bglocation, 0, 0, Width,Height,null);
        g2.drawString("[ TIME ] "+ minute +" : "+ second +" . "+ticks , 10, 20);
       
       
        player.draw(g2);
        enemy.draw(g2);
     
     

        bs.show();
        g2.dispose();

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < enemy.map.length; i++) {
            for(int j = 0; j < enemy.map[0].length; j++) {
                if(enemy.map[i][j] > 0) {
                    enemyX = j * enemy.positionX + 65;
                    enemyY = i * enemy.positionY + 50;
                    positionX = enemy.positionX;
                    positionY = enemy.positionY;

                    
                }
            }

        }
    }

    
    
    
}
