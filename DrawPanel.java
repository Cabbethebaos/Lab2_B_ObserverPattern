import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    List<BufferedImage> images = new ArrayList<>();
    List<Point> points = new ArrayList<>();
    // To keep track of a singel cars position


    // TODO: Make this genereal for all cars
    void moveit(int x, int y, int idx){
        points.get(idx).setLocation(x,y);
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y,List<Vehicle> vehicles) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }



}

