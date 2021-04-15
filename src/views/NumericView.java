/*
 -----------------------------------------------------------------------------------
 Cours       : MCR
 Fichier     : views.NumericView.java
 Auteur(s)   : Forestier Quentin & Herzig Melvyn
 Date        : 15.04.2021
 -----------------------------------------------------------------------------------
 */

package views;

import observables.Chronometer;
import java.awt.*;

/**
 * Classe implémentant une vue numérique sur un chronomètre.
 * @author Forestier Quentin & Herzig Melvyn.
 * @date 15/04/2021
 * @version 1.0.0
 */
public class NumericView extends ChronometerView
{
    /**
     * Constructeur.
     * @param chrono Chronomètre observé.
     */
    public NumericView(Chronometer chrono)
    {
        super(chrono);
    }

    /**
     * Affichage de la vue sur le graphics.
     * @param g Graphics afficheur de la vue.
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        String str = String.format("%s: %02dh %02dm %02ds", getMessage() , chronometer.getHours(), chronometer.getMinutes(), chronometer.getSeconds());
        int posX = (DIMENSION / 2) - (g.getFontMetrics().stringWidth(str) / 2); // Alignement horizontal au centre.
        int posY = (DIMENSION / 2) - (g.getFontMetrics().getHeight() / 2);      // Centrage vertical du text.
        g.drawString(str, posX, posY);
    }
}
