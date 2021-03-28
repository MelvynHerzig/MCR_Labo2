package views;

import observables.Chronometer;

import java.awt.*;
import java.util.LinkedList;

public class RomanView extends AnalogView
{
    public RomanView(Chronometer chrono)
    {
        super(chrono);
    }
    public RomanView(LinkedList<Chronometer> chrono)
    {
        super(chrono);
    }

    @Override
    protected Image getImage()
    {
        return null;
    }
}
