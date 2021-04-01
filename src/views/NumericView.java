package views;

import observables.Chronometer;

import javax.swing.*;


public class NumericView extends ChronometerView
{
    public NumericView(Chronometer... chrono)
    {
        super(chrono);
    }

    @Override
    void updateView()
    {

        for (int i = 0; i < drawzones.size() && i < chronometers.size(); ++i)
        {

            drawzones.get(i).getGraphics().drawRect(0,0, 200,200);

            String str = String.format("Chrono #%d: %d", chronometers.get(i).getId(), chronometers.get(i).getElapsedTime());
            int posX = 100 - drawzones.get(i).getGraphics().getFontMetrics().stringWidth(str) / 2;
            System.out.println(posX);
            drawzones.get(i).getGraphics().drawString(str, posX, 95);
        }
    }
}
