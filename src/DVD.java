import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.*;
import java.util.concurrent.*;
import resources.Resources;

public class DVD extends JPanel{

    private int xPos = 0, yPos = 0;
    private int cornerHits;

    private Executor executor;
    private JLabel logo;
    private JLabel logoShadow;
    private JLabel hits;
    
    Dimension screenSize;

    public DVD(){
        super(null);
        Resources r = Resources.getInstance();

        setOpaque(false);
        setDoubleBuffered(true);

        logo = new JLabel();
        add(logo);
        logo.setBounds(0,0,512,236);
        logo.setIcon(r.getGeneralIcon(0));
        
        logoShadow = new JLabel();
        add(logoShadow);
        logoShadow.setBounds(0,0,650,300);
        logoShadow.setIcon(r.getGeneralIcon(6));

        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Dimension size;
        hits = new JLabel("Corner hits: " + cornerHits);
        add(hits);
        size = hits.getPreferredSize();
        hits.setForeground(Color.white);
        hits.setFont (hits.getFont ().deriveFont (30.0f));
        hits.setBounds(screenSize.width/2 - size.width*3/2, screenSize.height/2 - size.height*3/2, size.width*3, size.height*3);


        JLabel bg = new JLabel();
        add(bg);
        bg.setBounds(0,0, screenSize.width, screenSize.height);
        Image newimg = r.getGeneralIcon(5).getImage().getScaledInstance(screenSize.width, screenSize.height,  java.awt.Image.SCALE_SMOOTH); 
        ImageIcon imageIcon = new ImageIcon(newimg); 
        bg.setIcon(imageIcon);

        setVisible(true);
        setFocusable(true);
        executor = Executors.newSingleThreadExecutor();

        executor.execute(() -> Update());     
    }
    private void Update(){
        Resources r = Resources.getInstance();
        Random rand = new Random();

        int xDir = 1;
        int yDir = 1;

        while(true){
            if(xPos <= screenSize.width - 512 && xPos >= 0){
                xPos += xDir;
            }
            if(yPos <= screenSize.height - 236 && yPos >= 0){
                yPos += yDir;
            }

            if(xPos == screenSize.width - 512 || xPos == 0){
                xDir *= -1;
                logo.setIcon(r.getGeneralIcon(rand.nextInt(5)));
            }
            if(yPos == screenSize.height - 236 || yPos == 0){
                yDir *= -1;
                logo.setIcon(r.getGeneralIcon(rand.nextInt(5)));
            }


            if((xPos == 0 && yPos == screenSize.height - 236) || (xPos == screenSize.width - 512 && yPos == screenSize.height - 236)
                || (xPos == 0 && yPos == 0) || (xPos == screenSize.width - 512 && yPos == 0)){
                cornerHits += 1;
                hits.setText("Corner hits: " + cornerHits);
            }

            logo.setLocation(xPos,yPos);
            logoShadow.setLocation(xPos - 69,yPos - 32);
            try { 
                Thread.sleep(7); 
            }
            catch (InterruptedException e) { 
            } 
        }
    }
}