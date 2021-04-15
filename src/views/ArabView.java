/*
 -----------------------------------------------------------------------------------
 Cours       : MCR
 Fichier     : views.ArabView.java
 Auteur(s)   : Forestier Quentin & Herzig Melvyn
 Date        : 15.04.2021
 -----------------------------------------------------------------------------------
 */

package views;

import observables.Chronometer;
import java.awt.*;

/**
 * Classe implémentant une vue à cadran avec chiffres arabes sur le chronomètre.
 * @author Forestier Quentin & Herzig Melvyn.
 * @date 15/04/2021
 * @version 1.0.0
 */
public class ArabView extends AnalogView
{

    /**
     * Constructeur.
     * @param chrono Chronomètre à afficher
     */
    public ArabView(Chronometer chrono)
    {
        super(chrono);
    }

    /**
     * Accède à l'image de fond représentant le cadran à chiffres arabes.
     * @return Retourne l'image du cadran.
     */
    @Override
    protected Image getImage()
    {
        return Toolkit.getDefaultToolkit().getImage("src/views/cadrans/cadran_chiffres_arabes.jpg");
    }
}
