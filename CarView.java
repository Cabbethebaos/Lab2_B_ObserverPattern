import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarView extends JFrame implements Observer {
    /**
     * Anger storleken på vår view
     */
    private static final int X = 800;
    private static final int Y = 800;

    /**
     * Deklerationa av det som kommer att utgöra vyn
     */
    DrawPanel drawPanel;
    JPanel controlPanel = new JPanel();
    CarController carController;

    /**
     * Dekleration av gas knappens instans variabler
     */
    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    /**
     * Dekleration av brake knappens instans variabler
     */
    JPanel brakePanel = new JPanel();
    JSpinner brakeSpinner = new JSpinner();
    int brakeAmount = 0;
    JLabel brakeLabel = new JLabel("Amount of gas");

    /**
     * Dekleration av knapparna som läggs till frame'n
     */
    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Bed");
    JButton addCarButton = new JButton("Add Car");
    JButton removeCarButton = new JButton("Remove Car");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    /**
     * Konstruktor som tar ett namn på frame'n och ett argument av typ CarController och initierar den.
     * @param cc
     */
    public CarView(CarController cc){
        this.carController = cc;
        this.drawPanel = new DrawPanel(X, Y-240, cc.m.vehicles);
        initComponents();
    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents() {

        this.setTitle("title");
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);



        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        /**
         * Gör dessamma för brake som för gas
         */
        brakeSpinner = new JSpinner(spinnerModel);
        brakeSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                brakeAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        controlPanel.setLayout(new GridLayout(2,6));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(addCarButton, 6);
        controlPanel.add(removeCarButton, 7);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);



        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.gas(gasAmount);
            }
        });

        /**
         * ActionListener för BRAKE knappen.
         */
        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.brake(brakeAmount);
            }
        });

        /**
         * ActionListener för START knappen.
         */
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.start();
            }
        });

        /**
         * ActionListener för STOP knappen.
         */
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.stop();
            }
        });

        /**
         * ActionListener för TURBO-ON knappen.
         */
        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.turboOn();
            }
        });

        /**
         * ActionListener för TURBO-OFF knappen.
         */
        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.turboOff();
            }
        });

        /**
         * ActionListener för Scania LIFT-BED knappen.
         */
        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.liftBed();
            }
        });

        /**
         * ActionListener för Scania LOWER-BED knappen.
         */
        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.lowerBed();
            }
        });

        addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.addCar();
                drawPanel.addPointsAndImages(carController.m.vehicles.get((carController.m.vehicles.size()) -1));}
        });

        removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.removeCar();
            }
        });

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
        for (Vehicle v : carController.m.vehicles) {
            if(v.getLocation().y > 500 || v.getLocation().y < 0 || v.getLocation().x < 0 || v.getLocation().x > 700)
                v.turnAround();


            v.move();
            int x = (int) Math.round(v.getLocation().x);
            int y = (int) Math.round(v.getLocation().y);
            drawPanel.moveit(x, y, carController.m.vehicles.indexOf(v));
            // repaint() calls the paintComponent method of the panel
            drawPanel.repaint();

        }
    }
}