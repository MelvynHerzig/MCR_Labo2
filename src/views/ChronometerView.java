package views;

import observables.Chronometer;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;

public abstract class ChronometerView implements Observer
{

    private LinkedList<Chronometer> chronometers;
    private JPanel drawzone;


    public ChronometerView(Chronometer chrono)
    {
        this(new LinkedList<Chronometer>(){{add(chrono);}});
    }

    public ChronometerView(LinkedList<Chronometer> chronometerList)
    {
        this.chronometers = new LinkedList<>();
        chronometers.addAll(chronometerList);

        for (Chronometer c: chronometers)
        {
            c.attach(this);
        }

        JFrame frame = new JFrame();
        drawzone = new JPanel();

        frame.getContentPane().add(drawzone, BorderLayout.CENTER);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void update()
    {
        updateView(drawzone.getGraphics());
    }

    abstract void updateView(Graphics g);
}
