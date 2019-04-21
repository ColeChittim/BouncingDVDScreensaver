package resources;

import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.ImageIcon;

public class Resources {
  private ImageIcon[] general;
 

  static Resources instance;

  private Resources() {
    final Class cls = Resources.class;
    general = new ImageIcon[7];

    String fn = "white.png";
    try (InputStream r = cls.getResourceAsStream(fn)) {
        general[0] = new ImageIcon (ImageIO.read(r));
    }
    catch (IOException e) {
        System.err.println("fn=\"" + fn + "\"");
        e.printStackTrace();
        System.exit(1);
    }
    fn = "blue.png";
    try (InputStream r = cls.getResourceAsStream(fn)) {
        general[1] = new ImageIcon (ImageIO.read(r));
    }
    catch (IOException e) {
        System.err.println("fn=\"" + fn + "\"");
        e.printStackTrace();
        System.exit(1);
    }
    fn = "green.png";
    try (InputStream r = cls.getResourceAsStream(fn)) {
        general[2] = new ImageIcon (ImageIO.read(r));
    }
    catch (IOException e) {
        System.err.println("fn=\"" + fn + "\"");
        e.printStackTrace();
        System.exit(1);
    }
    fn = "pink.png";
    try (InputStream r = cls.getResourceAsStream(fn)) {
        general[3] = new ImageIcon (ImageIO.read(r));
    }
    catch (IOException e) {
        System.err.println("fn=\"" + fn + "\"");
        e.printStackTrace();
        System.exit(1);
    }
    fn = "red.png";
    try (InputStream r = cls.getResourceAsStream(fn)) {
        general[4] = new ImageIcon (ImageIO.read(r));
    }
    catch (IOException e) {
        System.err.println("fn=\"" + fn + "\"");
        e.printStackTrace();
        System.exit(1);
    }
    fn = "bg.png";
    try (InputStream r = cls.getResourceAsStream(fn)) {
        general[5] = new ImageIcon (ImageIO.read(r));
    }
    catch (IOException e) {
        System.err.println("fn=\"" + fn + "\"");
        e.printStackTrace();
        System.exit(1);
    }

    fn = "shadow.png";
    try (InputStream r = cls.getResourceAsStream(fn)) {
        general[6] = new ImageIcon (ImageIO.read(r));
    }
    catch (IOException e) {
        System.err.println("fn=\"" + fn + "\"");
        e.printStackTrace();
        System.exit(1);
    }
  }
  public ImageIcon getGeneralIcon(int i) {
    return general[i];
  }
  public static Resources getInstance() {
    if (instance == null)
      instance = new Resources();
    return instance;
  }

}
