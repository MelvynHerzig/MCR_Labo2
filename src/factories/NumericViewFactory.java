package factories;

import observables.Chronometer;
import views.ChronometerView;
import views.NumericView;

/**
 * Classe implémentant une fabrique de vue numéric
 * @author Forestier Quentin & Herzig Melvyn
 * @date 01.04.2021
 */
public class NumericViewFactory extends ChronometerViewFactory
{
    private static NumericViewFactory instance;

    private NumericViewFactory(){}

    /**
     * Accesseur sur l'instance de l'usine.
     * @return Retourne une référence sur l'usine
     */
    public static NumericViewFactory getInstance()
    {
        if(instance == null)
        {
            instance = new NumericViewFactory();
        }

        return instance;
    }

    @Override
    public ChronometerView createView(Chronometer chrono)
    {
        return new NumericView(chrono);
    }
}
