import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AutoClicker extends JFrame implements ActionListener {

    private Clicker clicker;

    public AutoClicker() {
        super("AutoClicker");
        setSize(Parameters.FRAME_SIZE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(null);
        getContentPane().setBackground(Parameters.MAIN_COLOR);

        addGuiComponents();
        clicker = new Clicker();
    }

    private void addGuiComponents() {
        JLabel titleLabel = new JLabel();
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");

        titleLabel.setText("AutoClicker by APAP");
        titleLabel.setForeground(Parameters.FONT_COLOR);

        titleLabel.setBounds(10, 20, Parameters.BUTTON_SIZE.width, Parameters.BUTTON_SIZE.height);

        startButton.setBackground(Parameters.START_BUTTON_COLOR);
        stopButton.setBackground(Parameters.STOP_BUTTON_COLOR);

        startButton.setBounds(10, titleLabel.getY() + 200, Parameters.BUTTON_SIZE.width, Parameters.BUTTON_SIZE.height);
        startButton.addActionListener(this);

        stopButton.setBounds(startButton.getX() + 200, titleLabel.getY() + 200, Parameters.BUTTON_SIZE.width, Parameters.BUTTON_SIZE.height);
        stopButton.addActionListener(this);

        // Add to frame
        getContentPane().add(startButton);
        getContentPane().add(stopButton);
        getContentPane().add(titleLabel);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Stop clicker before quit app
                clicker.stopClicking();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton sourceButton = (JButton) e.getSource();
            if (sourceButton.getText().equals("Start")) {
                clicker.startClicking();
            } else if (sourceButton.getText().equals("Stop")) {
                clicker.stopClicking();
            }
        }
    }
}
