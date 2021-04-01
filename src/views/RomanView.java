package views;

import observables.Chronometer;

import java.awt.*;

public class RomanView extends AnalogView
{

    public RomanView(Chronometer chrono)
    {
        super(chrono);
    }

    @Override
    protected Image getImage()
    {
        return Toolkit.getDefaultToolkit().getImage("src/views/cadrans/cadran_chiffres_romains.jpg");
    }
}
