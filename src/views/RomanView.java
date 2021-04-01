package views;

import observables.Chronometer;

import java.awt.*;

public class RomanView extends AnalogView
{

    public RomanView(Chronometer... chrono)
    {
        super(chrono);
    }

    @Override
    protected Image getImage()
    {
        return null;
    }
}
