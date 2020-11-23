import java.awt.Graphics;
//import java.awt.event.KeyEvent;


public class Enemy {
    public int map[][];
    public int positionX ;
    public int positionY ;

    //private int scaleX = 60;
    //private int scaleY = 60;
   // private int speedX = 0;
    //private int speedY = 0;
    //private int speed = 0;
    //private int direction = 0;

   // private boolean Right = false;
    //private boolean Left = false;
    //private boolean Move = false;

     private Boss En;

    public Enemy(int row, int col) {
        map = new int[row][col];
        for(int i = 0; i<map.length; i++) {
            for(int j = 0; j<map[0].length; j++) {
                map[i][j] = 1;
            }
        }
        positionX = 550/col;
        positionY = 600/row;
        En = new Boss();

    }

    public void update() {
       // Move();
    }

    public void draw(Graphics g2) {
       for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] > 0){
                    g2.drawImage(En.enemy[0], j * positionX + 65, i * positionY + 50, 60, 60, null);
                }
            }
        }
    }

    public void setEnemyValue(int value, int row, int col) {
        map[row][col] = value;
    }


}