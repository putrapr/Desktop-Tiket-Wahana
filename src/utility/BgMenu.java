package utility;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BgMenu extends JPanel {
    private Image image;
    
    public BgMenu() {
        image = new ImageIcon(getClass().getResource("/img/bg2.jpg")).getImage();
    }
    
    @Override
    protected void paintComponent (Graphics graphics) {
        super.paintComponent(graphics);
        
        Graphics2D gd = (Graphics2D) graphics.create();
        gd.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        gd.dispose();
    }    
}