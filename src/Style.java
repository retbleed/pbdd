import javax.swing.*;
import java.awt.*;

public class Style extends JComponent {

    private int status;

    static final int height = 1024;
    static final int width = 1440;

    public Style(int  status){
        this.status = status;
    }

    public void paintComponent (Graphics g)
    {
        Graphics2D g2= (Graphics2D)g;


        Color statusColorA = new Color(61, 51, 95);
        Color statusColorC = new Color(166, 165, 182);

        g2.setColor(statusColorA);
        g2.fillRect(0, 0, width, 79);



        switch (status){
            case 1:
                g2.setColor(statusColorC);
                g2.fillRect(235, 100, 1100, 600);
                break;
            case 2:
                g2.setColor(statusColorA);
                g2.fillRect(0, 79, 155, 945);

                g2.setColor(statusColorC);
                g2.fillRect(284, 229, 1027, 556);
                break;
            default:
                break;
            }
        }

    }
