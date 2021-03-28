package views;

import observables.Chronometer;

import java.awt.*;
import java.util.LinkedList;

public class NumericView extends ChronometerView
{
    public NumericView(Chronometer chrono)
    {
        super(chrono);
    }
    public NumericView(LinkedList<Chronometer> chrono)
    {
        super(chrono);
    }

    @Override
    void updateView(Graphics g)
    {

    }
}
