import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;

public class PendulumPanel extends JPanel {

    Pendulum[] pens;
    public final static int LENGTH = 500;
    private double time;

    public PendulumPanel(Pendulum[] pendulums){
        this.pens = pendulums;
        this.setPreferredSize(new Dimension(LENGTH,LENGTH));
        this.setBackground(Color.LIGHT_GRAY);
    }

    public void setTime(double t){
        this.time = t;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);


        for (Pendulum p : this.pens){
            g.setColor(p.getColor());
            double[] loc = p.get_location(this.time);
            double x = (loc[0]*LENGTH/2)*p.getLength() + LENGTH/2;
            double y = (loc[1]*LENGTH/2)*p.getLength();
            g.fillOval((int)(x - p.getRadius()), (int)(y - p.getRadius()), (int) p.getRadius()*2,(int) p.getRadius()*2);
            g.drawLine((int)x, (int)y, LENGTH/2, 0);
        }

    }
}
