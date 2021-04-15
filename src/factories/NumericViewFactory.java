/*
 -----------------------------------------------------------------------------------
 Cours       : MCR
 Fichier     : factories.NumericViewFactory.java
 Auteur(s)   : Forestier Quentin & Herzig Melvyn
 Date        : 15.04.2021
 -----------------------------------------------------------------------------------
 */

package factories;

import observables.Chronometer;
import views.ChronometerView;
import views.NumericView;

/**
 * Classe implémentant une fabrique de vue numéric
 * @author Forestier Quentin & Herzig Melvyn
 * @date 15.04.2021
 * @version 1.0.0
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

    /**
     * Crée une vue numérique.
     * @param chrono Chronomètres que la vue doit afficher.
     * @return Retourne la vue pour le chronomètre chrono.
     */
    @Override
    public ChronometerView createView(Chronometer chrono)
    {
        return new NumericView(chrono);
    }
}
