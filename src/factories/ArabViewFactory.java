/*
 -----------------------------------------------------------------------------------
 Cours       : MCR
 Fichier     : factories.ArabViewFactory.java
 Auteur(s)   : Forestier Quentin & Herzig Melvyn
 Date        : 15.04.2021
 -----------------------------------------------------------------------------------
 */

package factories;

import observables.Chronometer;
import views.ArabView;
import views.ChronometerView;

/**
 * Classe implémentant une fabrique de vue arabe
 * @author Forestier Quentin & Herzig Melvyn
 * @date 15.04.2021
 * @version 1.0.0
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

    /**
     * Crée une vue analogique à chiffre arabes.
     * @param chrono Chronomètres que la vue doit afficher.
     * @return Retourne la vue pour le chronomètre chrono.
     */
    @Override
    public ChronometerView createView(Chronometer chrono)
    {
        return new ArabView(chrono);
    }
}
