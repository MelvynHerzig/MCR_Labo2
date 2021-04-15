/*
 -----------------------------------------------------------------------------------
 Cours       : MCR
 Fichier     : factories.ChronometerViewFactory.java
 Auteur(s)   : Forestier Quentin & Herzig Melvyn
 Date        : 15.04.2021
 -----------------------------------------------------------------------------------
 */

package factories;

import observables.Chronometer;
import views.ChronometerView;

/**
 * Classe abstraite qui génère des ChronometerView selon l'affichage souhaité
 * @author Forestier Quentin & Herzig Melvyn
 * @date 15.04.2021
 * @version 1.0.0
 */
public abstract class ChronometerViewFactory
{
    /**
     * Crée une ChronometerView
     * @param chrono Chronomètres que la vue doit afficher
     * @return Retourne la ChronometerView créée
     */
    public abstract ChronometerView createView(Chronometer chrono);
}
