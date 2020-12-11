import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SpeedView extends JFrame implements Observer{

    private static final int X = 300;
    private static final int Y = 100;

    JPanel speedPanel = new JPanel();
    DrawSpeedPanel drawSpeedPanel;

    private List<JLabel> carLabels = new ArrayList<>();

    CarModel m;

    public SpeedView(CarModel m){
        this.m = m;

        this.drawSpeedPanel = new DrawSpeedPanel(X, Y-40);
        createLabel();
    }

    private void createLabel(){
        for(Vehicle v : m.vehicles){
            carLabels.add(new JLabel(v.getModelName() + ": " + v.getCurrentSpeed() + " kmh."));
            System.out.println(v.getModelName() + ": " + v.getCurrentSpeed() + " kmh.");
        }
        initLabel();
    }

    private void initLabel(){
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawSpeedPanel);

        speedPanel.setLayout(new GridLayout(10,1));

        int i = 0;
        for(JLabel label : carLabels){
            speedPanel.add(label, i);
            i++;
        }

        this.add(speedPanel);


        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void update() {
        repaint();

        for(Vehicle v : m.vehicles)
            for(JLabel label : carLabels)
                if(label.toString().contains(v.getModelName()))
                    label.setText(v.getModelName() + ": " + v.getCurrentSpeed() + ".");


    }


}
