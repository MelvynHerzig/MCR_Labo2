package views;

import observables.Chronometer;

import java.awt.*;

public class ArabView extends AnalogView
{

    public ArabView(Chronometer... chrono)
    {
        super(chrono);
    }

    @Override
    protected Image getImage()
    {
        return null;
    }
}
