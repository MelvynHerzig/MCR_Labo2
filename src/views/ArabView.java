package views;

import observables.Chronometer;

import java.awt.*;
import java.util.LinkedList;

public class ArabView extends AnalogView
{
    public ArabView(Chronometer chrono)
    {
        super(chrono);
    }
    public ArabView(LinkedList<Chronometer> chrono)
    {
        super(chrono);
    }

    @Override
    protected Image getImage()
    {
        return null;
    }
}
