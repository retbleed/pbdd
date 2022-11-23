import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Style extends JComponent {

    private int status;

    static final int height = 768;
    static final int width = 1368;

    public Style(int  status){
        this.status = status;
    }

    public void paintComponent (Graphics g)
    {
        Graphics2D g2= (Graphics2D)g;


        Color statusColorA = new Color(61, 51, 95);
        Color statusColorB = new Color(106, 62, 113);
        Color statusColorC = new Color(166, 165, 182);

        g2.setColor(statusColorA);
        g2.fillRect(0, 0, width, 50);

        g2.setColor(statusColorB);
        g2.fillRect(0, 50, width, 30);

        g2.setColor(statusColorA);
        g2.fillRect(0, height - 50, width, 25);

        switch (status){
            case 1:
                g2.setColor(statusColorC);
                g2.fillRect(235, 100, 1100, 600);
                break;
            case 2:
                g2.setColor(statusColorC);
                g2.fillRect(10, 100, 1000, 550);

                g2.setColor(statusColorC);
                g2.fillRect(1050, 100, 265, 150);

                g2.setColor(statusColorC);
                g2.fillRect(1050, 300, 265, 350);
                break;
            default:
                break;
            }
        }

    }
