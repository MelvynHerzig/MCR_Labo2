package views;

import observables.Chronometer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class ChronometerView extends JPanel implements Observer
{
    protected static final int DIMENSION = 200;

    protected Chronometer chronometer;

    public ChronometerView(Chronometer chrono)
    {
        if(chrono == null) return;

        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(chrono.isRunning())
                {
                    chrono.stop();
                }
                else
                {
                    chrono.start();
                }
            }
        });

        chrono.attach(this);
        chronometer = chrono;

        repaint();
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(DIMENSION, DIMENSION);
    }

    public String getMessage()
    {
        return String.format("Chrono #%d", chronometer.getId());
    }

    @Override
    public void update()
    {
        repaint();
    }
}
