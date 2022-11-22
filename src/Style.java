import javax.swing.*;
import java.awt.*;

public class Style extends JComponent {
    String status;

    static final int height = 768;
    static final int width = 1368;

    public Style(){

    }

    public void paintComponent (Graphics g)
    {
        Graphics2D g2= (Graphics2D)g;


        Color statusColorA = new Color(61, 51, 95);
        Color statusColorB = new Color(106, 62, 113);

        g2.setColor(statusColorA);
        g2.fillRect(0, 0, width, 50);

        g2.setColor(statusColorB);
        g2.fillRect(0, 50, width, 30);

        g2.setColor(statusColorA);
        g2.fillRect(0, height - 50, width, 50);

        }

    }
