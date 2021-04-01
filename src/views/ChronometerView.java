package views;

import observables.Chronometer;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;

public abstract class ChronometerView implements Observer
{
    protected final int DIMENSION = 200;


    protected LinkedList<Chronometer> chronometers;
    protected LinkedList<JPanel> drawzones;


    public ChronometerView(Chronometer... chronos)
    {

        if(chronos == null) return;

        chronometers = new LinkedList<>();
        drawzones = new LinkedList<>();

        JFrame frame = new JFrame();
        JPanel container = new JPanel(new FlowLayout(FlowLayout.LEADING));

        for (Chronometer c: chronos)
        {
            c.attach(this);
            chronometers.add(c);
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(DIMENSION, DIMENSION));
            container.add(panel);
            drawzones.add(panel);
        }


        frame.getContentPane().add(container, BorderLayout.CENTER);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        updateView();
    }

    @Override
    public void update()
    {
        updateView();
    }


    abstract void updateView();


}
