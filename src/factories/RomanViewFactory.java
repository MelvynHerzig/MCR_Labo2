/*
 -----------------------------------------------------------------------------------
 Cours       : MCR
 Fichier     : factories.RomanViewFactory.java
 Auteur(s)   : Forestier Quentin & Herzig Melvyn
 Date        : 15.04.2021
 -----------------------------------------------------------------------------------
 */

package factories;

import observables.Chronometer;
import views.ChronometerView;
import views.RomanView;

/**
 * Classe implémentant une fabrique de vue romaine
 * @author Forestier Quentin & Herzig Melvyn
 * @date 15.04.2021
 * @version 1.0.0
 */
public class RomanViewFactory extends ChronometerViewFactory
{
    /**
     * Instance de l'usine.
     */
    private static RomanViewFactory instance;

    /**
     * Constructeur.
     */
    private RomanViewFactory(){}

    /**
     * Accesseur sur l'instance de l'usine.
     * @return Retourne une référence sur l'usine.
     */
    public static RomanViewFactory getInstance()
    {
        if(instance == null)
        {
            instance = new RomanViewFactory();
        }

        return instance;
    }

    /**
     * Crée une vue analogique à chiffre romain.
     * @param chrono Chronomètres que la vue doit afficher.
     * @return Retourne la vue pour le chronomètre chrono.
     */
    @Override
    public ChronometerView createView(Chronometer chrono)
    {
        return new RomanView(chrono);
    }
}
