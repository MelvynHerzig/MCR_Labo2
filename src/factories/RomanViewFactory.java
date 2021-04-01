package factories;

import observables.Chronometer;
import views.ChronometerView;
import views.RomanView;

/**
 * Classe implémentant une fabrique de vue romaine
 * @author Forestier Quentin & Herzig Melvyn
 * @date 01.04.2021
 */
public class RomanViewFactory extends ChronometerViewFactory
{
    private static RomanViewFactory instance;

    private RomanViewFactory(){}

    /**
     * Accesseur sur l'instance de l'usine.
     * @return Retourne une référence sur l'usine
     */
    public static RomanViewFactory getInstance()
    {
        if(instance == null)
        {
            instance = new RomanViewFactory();
        }

        return instance;
    }

    @Override
    public ChronometerView createView(Chronometer chrono)
    {
        return new RomanView(chrono);
    }
}
