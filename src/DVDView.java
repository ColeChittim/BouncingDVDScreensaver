import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.*;

public class DVDView {

    private static Executor executor;
    
    public static void main(String[] args){
        DVD dvd = new DVD();

        JFrame frame = new JFrame("DVD Screensaver");

        frame.setUndecorated(true);
        frame.setResizable(false);
        frame.getContentPane().add(dvd);
        frame.getContentPane().setBackground(Color.black);
        frame.validate();
        GraphicsEnvironment.getLocalGraphicsEnvironment()
                   .getDefaultScreenDevice()
                   .setFullScreenWindow(frame);

        executor = Executors.newSingleThreadExecutor();

        frame.addMouseListener(
            new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                executor.execute(() -> System.exit(0));
            }
        });
    }
}