import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        new Main().show();
    }

    private JFrame frame;
    private PendulumPanel mainPanel;

    public void show(){
        frame = new JFrame("Pendulums");
        int pen_number = 12;
        Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK};
        Pendulum[] pens = new Pendulum[pen_number];
        double length = 1.8;
        for (int i = 0; i < pen_number; i++){
            System.out.println("Length is" + String.valueOf(length));
            pens[i] = new Pendulum(length, colors[i % colors.length]);
            double gl = 10/length;
            double y = Math.PI/12;
            length = 10/(gl + 2*y*Math.sqrt(gl) + Math.pow(y, 2));
        }

        mainPanel = new PendulumPanel(pens);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.pack();

        double time = 0;
        double increment = 0.01;
        boolean running = true;
        while (running){
            frame.repaint();
            if (time == 0){
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            time += increment;
            mainPanel.setTime(time);

            try{
                Thread.sleep((long)(increment*1000));
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
