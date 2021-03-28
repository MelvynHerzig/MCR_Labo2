package views;

import observables.Chronometer;

import java.awt.*;
import java.util.LinkedList;

public abstract class AnalogView extends ChronometerView
{

    public AnalogView(Chronometer chrono)
    {
        super(chrono);
    }
    public AnalogView(LinkedList<Chronometer> chrono)
    {
        super(chrono);
    }


    @Override
    void updateView(Graphics g)
    {

    }

    protected abstract Image getImage();
}
