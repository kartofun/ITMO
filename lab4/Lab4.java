/**
 * Created by Павел on 14.07.2016.
 */
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Comparator;
import static java.lang.Math.pow;

public class Lab4 {
    public static void main(String[] args) throws InterruptedException {
        //frame
        JFrame frame = new JFrame("Lab4");
        frame.setSize(400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(2, 1));
        frame.getContentPane().setBackground(new Color(197, 166, 115));


        JPanel panelUserInterface = new JPanel();
        JPanel panelR = new JPanel();
        JPanel panelPickCoordinate = new JPanel();
        JPanel panelPoint = new JPanel();
        GraphicPanel graphicPanel = new GraphicPanel();

        //panelUserInterface
        panelUserInterface.add(panelPickCoordinate);
        panelUserInterface.add(panelPoint);
        panelUserInterface.setLayout(new BoxLayout(panelUserInterface, BoxLayout.Y_AXIS));

        //panelR
        JLabel labelR = new JLabel("R ");
        JSpinner spinnerR = new JSpinner();
        spinnerR.setValue(5);
        panelR.add(labelR);
        panelR.add(spinnerR);
        panelR.setLayout(new BoxLayout(panelR, BoxLayout.X_AXIS));
        panelR.setMaximumSize(new Dimension(100, 50));

        //panelPickCoordinate
        JPanel panelX = new JPanel();
        JPanel panelY = new JPanel();
        panelPickCoordinate.add(panelR);
        panelPickCoordinate.add(panelX);
        panelPickCoordinate.add(panelY);
        panelPickCoordinate.setLayout(new BoxLayout(panelPickCoordinate, BoxLayout.X_AXIS));
        panelPickCoordinate.setMaximumSize(new Dimension(400, 300));
        panelPickCoordinate.setMinimumSize(new Dimension(400, 300));

        //panelX
        JLabel labelX = new JLabel("x");
        String[] listX = {"2.5", "-2", "-1", "0", "1", "3"};
        JList xList = new JList<>(listX);
        panelX.add(labelX);
        panelX.add(xList);
        panelX.setLayout(new BoxLayout(panelX, BoxLayout.Y_AXIS));
        panelX.setMinimumSize(new Dimension(200, 200));
        panelX.setMaximumSize(new Dimension(200, 200));


        //panelY
        JLabel labelY = new JLabel("y");
        ArrayList<JCheckBox> listY = new ArrayList<>();
        JCheckBox y1 = new JCheckBox("-2.5");
        JCheckBox y2 = new JCheckBox("-3");
        JCheckBox y3 = new JCheckBox("-1");
        JCheckBox y4 = new JCheckBox("0");
        JCheckBox y5 = new JCheckBox("1");
        JCheckBox y6 = new JCheckBox("3");
        panelY.add(labelY);
        listY.add(y1); //panelY.add(y1);
        listY.add(y2); //panelY.add(y2);
        listY.add(y3); //panelY.add(y3);
        listY.add(y4); //panelY.add(y4);
        listY.add(y5); //panelY.add(y5);
        listY.add(y6); //panelY.add(y6);
        for (int i = 0; i < listY.size(); i++)
            panelY.add(listY.get(i));
        panelY.setLayout(new BoxLayout(panelY, BoxLayout.Y_AXIS));
        panelY.setMinimumSize(new Dimension(200, 200));
        panelY.setMaximumSize(new Dimension(200, 200));

        //panelPoint
        JLabel point = new JLabel("Point");
        JTextField textPoint = new JTextField();
        panelPoint.add(point);
        panelPoint.add(textPoint);
        panelPoint.setLayout(new BoxLayout(panelPoint, BoxLayout.Y_AXIS));
        panelPoint.setMinimumSize(new Dimension(400, 50));
        panelPoint.setMaximumSize(new Dimension(400, 50));

        //graphicalPanel and listeners
        graphicPanel.setMaximumSize(new Dimension(300, 300));

        graphicPanel.setMinimumSize(new Dimension(300, 300));

        graphicPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                graphicPanel.point.x = (float)(e.getX() - 150);
                graphicPanel.point.y = (float)(e.getY() - 150);
                graphicPanel.xPoint = (float) (e.getX() - 150);
                graphicPanel.yPoint = -(float) (e.getY() - 150);
                textPoint.setText("(" + (float) (e.getX() - 150)/graphicPanel.factor/graphicPanel.R*graphicPanel.rPoint + "; " + -(float) (e.getY() - 150)/graphicPanel.factor/graphicPanel.R*graphicPanel.rPoint + ")");
                graphicPanel.update(graphicPanel.getGraphics());
                frame.update(frame.getGraphics());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        xList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                    int index = 0;
                    for (int i = 0; i < listY.size(); i++) {
                        if (listY.get(i).isSelected()) {
                        index = i;
                        }
                    }

                JCheckBox selectedY =  listY.get(index);

                graphicPanel.xPoint = Float.parseFloat(xList.getSelectedValue().toString())*graphicPanel.factor;
                textPoint.setText("(" + String.valueOf(xList.getSelectedValue()) + "; " + selectedY.getText() + ")");
                graphicPanel.point.x = Float.parseFloat(xList.getSelectedValue().toString())*graphicPanel.factor*graphicPanel.R/graphicPanel.rPoint;
                graphicPanel.update(graphicPanel.getGraphics());
                frame.update(frame.getGraphics());
            }
        } );

        spinnerR.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSpinner jSpinner = (JSpinner) e.getSource();
                graphicPanel.rPoint = (int) jSpinner.getValue();
                graphicPanel.point.x = graphicPanel.xPoint/graphicPanel.rPoint*graphicPanel.R;
                graphicPanel.point.y = graphicPanel.yPoint/ graphicPanel.rPoint*graphicPanel.R;
                graphicPanel.update(graphicPanel.getGraphics());
                frame.update(frame.getGraphics());

            }
        });

        for (int i = 0; i < listY.size(); i++) {
            final int index = i;
            listY.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (listY.get(index).isSelected()) {
                        textPoint.setText("(" + String.valueOf(xList.getSelectedValue()) + "; " + listY.get(index).getText() + ")");
                        for (int j = 0; j < listY.size(); j++) {
                            listY.get(j).setSelected(false);
                        }
                        listY.get(index).setSelected(true);
                        graphicPanel.yPoint = -Float.parseFloat((listY.get(index).getText()))*graphicPanel.factor;
                        System.out.println(graphicPanel.yPoint);
                        graphicPanel.point.y = -Float.parseFloat(listY.get(index).getText())*graphicPanel.factor*graphicPanel.R/graphicPanel.rPoint;
                        graphicPanel.update(graphicPanel.getGraphics());
                        frame.update(frame.getGraphics());

                        //g.fillOval((int)(Double.parseDouble(xList.getSelectedValue().toString())*graphicPanel.factor) + 150, -(int)(Double.parseDouble(listY.get(index).getText())*graphicPanel.factor) + 150, 5, 5);
                    }

                }
            });
        }

        frame.add(panelUserInterface);
        frame.add(graphicPanel);
        frame.setVisible(true);
    }

    public static class Dot{
        public float x;
        public float y;

        public Dot(float x, float y) {
            this.x = x;
            this.y = y;
            }
        public Dot (){}

        @Override
        public String toString() {
            String s = "(" + x + ", " + y + ")";
            return s;
        }
    }

    public static class GraphicPanel extends JPanel {
        int R = 5;
        int factor = 20;
        float xPoint = 0;
        float yPoint = 0;
        int rPoint = 5;
        Dot point = new Dot(500, 500);

        public GraphicPanel() {
            }


        @Override
        public void paint (Graphics g) {
            Graphics2D graphics = (Graphics2D) g;
            graphics.translate(150, 150);


            try {
            factor = 100/R;}
            catch (ArithmeticException e) {System.out.println("R == 0 it's very bad idea!!!");}

            int[] xPoint = {0, 0, R*factor/2, 0,  0, -R*factor/2, -R*factor/2};
            int[] yPoint = {0, -R*factor, 0, 0,  R*factor, R*factor, 0};

            Polygon polygon = new Polygon(xPoint, yPoint, 7);

            graphics.setPaint(new Color(23, 133, 6));
            graphics.fillArc(-R*factor, -R*factor, 2*R*factor, 2*R*factor, -90, 90);
            graphics.fillPolygon(polygon);

            if (checkDot(point.x, point.y))
                g.setColor(Color.RED);
            else
                g.setColor(Color.BLUE);
            g.fillOval((int)point.x, (int)point.y, 5, 5);
        }
        public boolean checkDot (float x, float y) {
            boolean checkFactor;

            if (y < 0)
                checkFactor = x >= 0 && x <= R*factor/2 && y <= 0 && y >= 2*x - R*factor;
            else
                checkFactor = (x >= -R*factor/2 && x <= 0 && y <= R*factor && y >= 0)
                        || (x > 0 && x <= R*factor && y >= 0 && Math.abs(y) <= Math.sqrt(pow(R*factor, 2) - pow(x, 2)));
            return checkFactor;
        }
        public float getxPoint() { return this.xPoint;}
        public float getyPoint() { return this.yPoint;}
    }

}
