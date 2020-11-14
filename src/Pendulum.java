import java.awt.*;
import java.util.List;
import java.lang.Math;

public class Pendulum {

    private double length;
    private Color color;
    private double w;
    private final static double AMPLITUDE = 0.25;
    private double radius = 10;

    public Pendulum(double length, Color c){
        this.length = length;
        this.color = c;
        this.w = Math.sqrt(10/length);
    }

    public void setRadius(double r){
        this.radius = r;
    }
    public double getRadius(){
        return this.radius;
    }
    public double getLength(){
        return this.length;
    }
    public Color getColor(){
        return this.color;
    }

    public double[] get_location(double time){
        // do some physics
        double x = AMPLITUDE * Math.cos(this.w * time);
        double x_location = Math.sin(x);
        double y_location = Math.cos(x);
        double[] location = {x_location, y_location};
        return location;
    }

}
