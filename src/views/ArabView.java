package views;

import observables.Chronometer;

import java.awt.*;

public class ArabView extends AnalogView
{

    public ArabView(Chronometer chrono)
    {
        super(chrono);
    }

    @Override
    protected Image getImage()
    {
        return Toolkit.getDefaultToolkit().getImage("src/views/cadrans/cadran_chiffres_arabes.jpg");
    }
}
