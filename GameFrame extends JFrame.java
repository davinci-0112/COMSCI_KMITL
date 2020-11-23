import javax.swing.*;

public class GameFrame extends JFrame {

    private JFrame gameFrame2;      // กำหนดให้คลาสหรือสมาชิกสามารถเข้าถึงได้ภายในคลาสเดียวกันเท่านั้น
    private int width = 650;        // กำหนดให้คลาสหรือสมาชิกสามารถเข้าถึงได้ภายในคลาสเดียวกันเท่านั้น
    private int Height = 900;       // กำหนดให้คลาสหรือสมาชิกสามารถเข้าถึงได้ภายในคลาสเดียวกันเท่านั้น
    private GamePanel panel;        // กำหนดให้คลาสหรือสมาชิกสามารถเข้าถึงได้ภายในคลาสเดียวกันเท่านั้น


    public GameFrame() {
        panel = new GamePanel(width, Height); //กำหนดขนาดของพาแนล
        gameFrame2 = new JFrame();  //สร้างชื่อให้เฟรม
        gameFrame2.setTitle("SHOOT EGG");   //สร้างชื่อเกม
        gameFrame2.setSize(width, Height);  //กำหนดขนาดของเฟรม
        gameFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //ทำให้สามารถปิดโปรมแกรม
        gameFrame2.setVisible(true);  //แสดงเฟรม
        gameFrame2.setResizable(false);//ทำให้ขยายจอไม่ได้
        gameFrame2.setIconImage(new ImageIcon(this.getClass().getResource("/pic/egg.png")).getImage());  //สร้างรูปไอคอนเกม
        gameFrame2.add(panel); //เพิ่มพาแนลมาบนเฟรม
        gameFrame2.pack();  // ปรับขนาดให้พาแนลพอดีกับเฟรม
        panel.start();      //เริ่มพาแนล
    } 
}