package views;

import observables.Chronometer;

import java.awt.*;
import java.awt.geom.Line2D;

public abstract class AnalogView extends ChronometerView
{
    private Image backGround;

    // aiguilles
    private final static int   H_NEEDLE_LENGTH = (int)(DIMENSION / 2 * 0.4);
    private final static int   H_NEEDLE_WIDTH  = 4;
    private final static Color H_NEEDLE_COLOR  = Color.BLACK;

    private final static int   M_NEEDLE_LENGTH = (int)(DIMENSION / 2 * 0.6);
    private final static int   M_NEEDLE_WIDTH  = 3;
    private final static Color M_NEEDLE_COLOR  = Color.BLUE;

    private final static int   S_NEEDLE_LENGTH = (int)(DIMENSION / 2 * 0.8);
    private final static int   S_NEEDLE_WIDTH  = 2;
    private final static Color S_NEEDLE_COLOR  = Color.RED;

    public AnalogView(Chronometer chrono)
    {
        super(chrono);
        backGround = getImage().getScaledInstance(getPreferredSize().width, getPreferredSize().height, 0);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(backGround,0,0, null);
        paintNeedles(g);
        repaint();
    }

    private void paintNeedles(Graphics g)
    {
        paintNeedle(g, chronometer.toSeconds() , S_NEEDLE_LENGTH, S_NEEDLE_WIDTH, S_NEEDLE_COLOR);
        paintNeedle(g, chronometer.toMinutes() , M_NEEDLE_LENGTH, M_NEEDLE_WIDTH, M_NEEDLE_COLOR);
        paintNeedle(g, chronometer.toHours() * 5, H_NEEDLE_LENGTH, H_NEEDLE_WIDTH, H_NEEDLE_COLOR);
    }

    private void paintNeedle(Graphics g, int degree, int length, int width, Color color)
    {
        double center = DIMENSION/2;
        double rad = Math.toRadians(degree * 6);
        double endX = center + (length * Math.sin(rad));
        double endY = center - (length * Math.cos(rad));

        Line2D needle = new Line2D.Double(center, center, endX, endY);

        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(width));
        g2d.draw(needle);
    }

    protected abstract Image getImage();
}
