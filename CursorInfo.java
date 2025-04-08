import java.awt.*;
import javax.swing.*;


public class CursorInfo extends JFrame {

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    
    Point coord = MouseInfo.getPointerInfo().getLocation();
    Color color;
    Robot robot;

    public CursorInfo(){

        this.setTitle("Cursor Info");
        this.setSize(500,400);

        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(300,300));
        contentPane.setBackground(new Color(192,192,192));

        label1 = new JLabel();
        label1.setBounds(0,0,300,99);
        label1.setBackground(new Color(220,220,220));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("SansSerif",0,30));
        label1.setText("-");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setVerticalAlignment(SwingConstants.CENTER);
        label1.setOpaque(true);
        label1.setVisible(true);
        
        label2 = new JLabel();
        label2.setBounds(0,101,300,100);
        label2.setBackground(new Color(220,220,220));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("SansSerif",0,30));
        label2.setText("-");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setVerticalAlignment(SwingConstants.CENTER);
        label2.setOpaque(true);
        label2.setVisible(true);
        
        label3 = new JLabel();
        label3.setBounds(0,202,300,100);
        label3.setBackground(new Color(220,220,220));
        label3.setForeground(new Color(0,0,0));
        label3.setEnabled(true);
        label3.setOpaque(true);
        label3.setVisible(true);

        contentPane.add(label1);
        contentPane.add(label2);
        contentPane.add(label3);

        this.add(contentPane);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
        
        try
        {
            robot = new Robot();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        mainLoop();
    }
    public void mainLoop()
    {
        coord = MouseInfo.getPointerInfo().getLocation();
        while(true)
        {
            coord = MouseInfo.getPointerInfo().getLocation();
            color = robot.getPixelColor((int)coord.getX(), (int)coord.getY());
            label1.setText(coord.getX()+" , "+coord.getY());
            label2.setText(color.getRed()+"R , "+color.getGreen()+"G , "+color.getBlue()+"B");
            label3.setBackground(color);
            robot.delay(30);
        }
    }
    public static void main(String[] args)
    {
        new CursorInfo();
    }
}