import java.awt.*;
import java.awt.event.InputEvent;

public class Clicker {

    private int x = 1245;
    private int y = 376;
    private int interval = 4500;
    private Robot robot;
    private volatile boolean running;  // Dodaj zmienną logiczną
    private Thread clickerThread; // Dodaj zmienną do przechowywania wątku

    public Clicker() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        running = false;  // Zainicjuj jako false
        clickerThread = null; // Inicjalizuj wątek jako null
    }

    public void startClicking() {
        if (clickerThread == null || !clickerThread.isAlive()) {
            running = true;
            clickerThread = new Thread(() -> {
                while (running) {
                    robot.mouseMove(x, y);
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

                    try {
                        Thread.sleep(interval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            clickerThread.start();
        }
    }

    public void stopClicking() {
        running = false;
        if (clickerThread != null) {
            try {
                clickerThread.join();  // Oczekaj na zakończenie wątku
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
