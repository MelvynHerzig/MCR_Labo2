package factories;

import observables.Chronometer;
import views.ArabView;
import views.ChronometerView;

/**
 * Classe implémentant une fabrique de vue arabe
 * @author Forestier Quentin & Herzig Melvyn
 * @date 01.04.2021
 */
public class ArabViewFactory extends ChronometerViewFactory
{
    private static ArabViewFactory instance;

    private ArabViewFactory(){}

    /**
     * Accesseur sur l'instance de l'usine.
     * @return Retourne une référence sur l'usine
     */
    public static ArabViewFactory getInstance()
    {
        if(instance == null)
        {
            instance = new ArabViewFactory();
        }

        return instance;
    }

    @Override
    public ChronometerView createView(Chronometer... chronos)
    {
        return new ArabView(chronos);
    }
}
