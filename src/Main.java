import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame fr = new JFrame("Вращение прямой вокруг точки которая двигается по отрезку");
        fr.setPreferredSize(new Dimension(300, 300));
        final JPanel pan = new JPanel();
        fr.add(pan);

        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();

        Timer tm = new Timer(500, new ActionListener() {
            int i = 0;
            int counter = -2;
            int g = 0;

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Graphics2D gr = (Graphics2D) pan.getRootPane().getGraphics();
                pan.update(gr);

                if (i % 50 == 0){
                    counter = -counter;
                }
                g = g + counter;


                Point elliPoint = new Point(150+g,150);


                gr.fill(new Ellipse2D.Float(elliPoint.x - 25, elliPoint.y - 15, 10, 10));

                GeneralPath path = new GeneralPath();
                path.append(new Line2D.Float(new Point(elliPoint.x - 40, elliPoint.y + 15), new Point(elliPoint.x - 10, elliPoint.y + 15)), true);

                AffineTransform tranforms = AffineTransform.getRotateInstance((i++) * 0.07, elliPoint.x -25, elliPoint.y - 15);
                gr.transform(tranforms);
                gr.draw(path);
            }
        });

        tm.start();
    }
}