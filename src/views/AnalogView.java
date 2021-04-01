package views;

import observables.Chronometer;

import java.awt.*;

public abstract class AnalogView extends ChronometerView
{

    public AnalogView(Chronometer... chrono)
    {
        super(chrono);
    }


    @Override
    void updateView()
    {

    }

    protected abstract Image getImage();
}
