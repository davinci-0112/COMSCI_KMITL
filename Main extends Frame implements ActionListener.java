//import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

public class Main extends Frame implements ActionListener {
    private JFrame gameFrame;   // กำหนดให้คลาสหรือสมาชิกสามารถเข้าถึงได้ภายในคลาสเดียวกันเท่านั้น
    private JTextField Tstart;  // กำหนดให้คลาสหรือสมาชิกสามารถเข้าถึงได้ภายในคลาสเดียวกันเท่านั้น
    private JButton BNew;       // กำหนดให้คลาสหรือสมาชิกสามารถเข้าถึงได้ภายในคลาสเดียวกันเท่านั้น
    private JButton BExit;      // กำหนดให้คลาสหรือสมาชิกสามารถเข้าถึงได้ภายในคลาสเดียวกันเท่านั้น


    public Main() {
        gameFrame = new JFrame();   //สร้างชื่อให้เฟรมไว้เรียกใช้
        gameFrame.setTitle("SHOOT EGG");    //กำหนดชื่อเกม
        Tstart = new JTextField("                    Are You ready");   //สร้างข้อความแสดงก่อนเริ่มเกม
        BNew = new JButton("Start");    //สร้างปุ่มเริ่มเกม
        BExit = new JButton("Exit");    //สร้างปุ่มออกเกม
        
        gameFrame.setBounds(20, 50, 650, 900);      //กำหนดขนาดและตำแหน่งของเฟรมเกม
        Tstart.setBounds(200, 200, 200, 80);        //กำหนดขนาดและตำแหน่งของข้อความ
        BNew.setBounds(100, 500, 400, 100);         //กำหนดขนาดและตำแหน่งของปุ่มเริ่ม
        BExit.setBounds(100, 700, 400, 100);        //กำหนดขนาดและตำแหน่งของปุ่มออก


        Tstart.setEditable(false);      //กำหนดให้แก้ไขข้อความไม่ได้

        gameFrame.add(Tstart);  //เพิ่มข้อความเข้ามาในเกม
        gameFrame.add(BNew);    //เพิ่มปุ่มเริ่มเข้ามาในเกม
        gameFrame.add(BExit);   //เพิ่มปุ่มเริ่มออกมาในเกม
        gameFrame.setIconImage(new ImageIcon(this.getClass().getResource("/pic/egg.png")).getImage());   //สร้างรูปไอคอนเกม
        gameFrame.setLayout(null);//แสดงปุ่ม
        gameFrame.setVisible(true);//แสดงเฟรม
        gameFrame.setResizable(false);//ทำให้ขยายจอไม่ได้
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //ทำให้สามารถปิดโปรมแกรม
        
        
        BNew.addActionListener(this);   //ปุ่มนี้สามารถทำงานได้
        BExit.addActionListener(this);  //ปุ่มนี้สามารถทำงานได้
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String clickerButton = e.getActionCommand();    //สร้างชื่อให้e.getActionCommand()
        if(clickerButton.equals("Start")){              //ถ้าคลิ๊กที่ปุ่มStart
        GameFrame play = new GameFrame();               //เปิดเฟรมของClass GameFrame
        gameFrame.setVisible(false);                    //ปิดเฟรมgameFrame
        }
        if(clickerButton.equals("Exit")){               //ถ้าคลิ๊กที่ปุ่มExit
            gameFrame.setVisible(false);                //ปิดเฟรมgameFrame
        }
    }
    
 
     
    
}