import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AutoClicker autoClicker = new AutoClicker();
            autoClicker.setVisible(true);
        });
    }
}
