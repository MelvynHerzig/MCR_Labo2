package views;

import observables.Chronometer;

import java.awt.*;
import java.time.Duration;

public class NumericView extends ChronometerView
{
    public NumericView(Chronometer chrono)
    {
        super(chrono);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        String str = String.format("%s: %02dh %02dm %02ds", getMessage() , chronometer.toHours(), chronometer.toMinutes(), chronometer.toSeconds());
        int posX = 100 - g.getFontMetrics().stringWidth(str) / 2; // alignement horizontal au centre.
        g.drawString(str, posX, 95);
    }
}
