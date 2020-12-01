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
        // Print an error message in case file is not found with a try/catch block
        int placement = 0; // Position i x-led

        for(Vehicle v : vehicles) {
            points.add(new Point(placement, 0)); //ny point för varje ny bild

            try {
                // You can remove the "pics" part if running outside of IntelliJ and
                // everything is in the same main folder.
                // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

                // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
                // if you are starting in IntelliJ.
                images.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + v.getModelName() + ".jpg")));


            } catch (IOException ex) {
                ex.printStackTrace();
            }
            v.setLocX(placement);
            placement += 100;
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int i = 0; i < images.size(); i++){
              g.drawImage(images.get(i), points.get(i).x, points.get(i).y, null); // see javadoc for more info on the parameters


          }



    }}


