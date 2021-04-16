package views;

import observables.Chronometer;

import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.geom.Line2D;

/**
 * Classe abstraite implémentant la base d'une vue à cadran.
 * @author Forestier Quentin & Herzig Melvyn.
 * @date 15/04/2021
 * @version 1.0.0
 */
public abstract class AnalogView extends ChronometerView
{
    /**
     * Image de fond.
     */
    private final Image backGround;

    /**
     * Caractérisitique des aiguilles.
     */
    private final static int   H_NEEDLE_LENGTH = (int)(DIMENSION / 2 * 0.4);
    private final static int   H_NEEDLE_WIDTH  = 4;
    private final static Color H_NEEDLE_COLOR  = Color.BLACK;

    private final static int   M_NEEDLE_LENGTH = (int)(DIMENSION / 2 * 0.6);
    private final static int   M_NEEDLE_WIDTH  = 3;
    private final static Color M_NEEDLE_COLOR  = Color.BLUE;

    private final static int   S_NEEDLE_LENGTH = (int)(DIMENSION / 2 * 0.8);
    private final static int   S_NEEDLE_WIDTH  = 2;
    private final static Color S_NEEDLE_COLOR  = Color.RED;

    /**
     * Constructeur.
     * @param chrono Chronomètre à observer
     */
    public AnalogView(Chronometer chrono)
    {
        super(chrono);
        backGround = getImage().getScaledInstance(getPreferredSize().width, getPreferredSize().height, 0);
    }

    /**
     * Affiche la vue sur le graphique g.
     * @param g Graphique qui affiche la vue.
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        // Image de fond
        g.drawImage(backGround,0,0, null);

        // Nom du chronomètre
        String str = String.format("%s", getMessage());
        int posX = (DIMENSION / 2) - (g.getFontMetrics().stringWidth(str) / 2); // Alignement horizontal au centre.
        int posY = (DIMENSION / 2) + g.getFontMetrics().getHeight();            // Excentrage vertical du text.
        g.drawString(str, posX, posY);

        // Aiguilles
        paintNeedles(g);

        repaint();
    }

    /**
     * Affiche les aiguilles sur le graphique g.
     * @param g Graphique qui affiche la vue.
     */
    private void paintNeedles(Graphics g)
    {
        // Les calculs supplémentaires après les *6 et *30 permettent d'affiner
        // les déplacement des aiguilles.
        paintNeedle(g, chronometer.getSeconds() * 6                                    , S_NEEDLE_LENGTH, S_NEEDLE_WIDTH, S_NEEDLE_COLOR);
        paintNeedle(g, chronometer.getMinutes() * 6  + chronometer.getSeconds() / 10.0 , M_NEEDLE_LENGTH, M_NEEDLE_WIDTH, M_NEEDLE_COLOR);
        paintNeedle(g, chronometer.getHours()   * 30 + chronometer.getMinutes() / 2.0  , H_NEEDLE_LENGTH, H_NEEDLE_WIDTH, H_NEEDLE_COLOR);
    }

    /**
     * Affiche une aiguille sur le graphique.
     * @param g Graphique où peindre l'aiguille.
     * @param degree Degré de l'aiguille.
     * @param length Longueur de l'aiguille.
     * @param width Largeur de l'aiguille.
     * @param color Couleur de l'aiguille.
     */
    private void paintNeedle(Graphics g, double degree, int length, int width, Color color)
    {
        double center = DIMENSION / 2.0;
        double rad = Math.toRadians(degree);
        double endX = center + (length * Math.sin(rad));
        double endY = center - (length * Math.cos(rad));

        Line2D needle = new Line2D.Double(center, center, endX, endY);

        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(width));
        g2d.draw(needle);
    }

    /**
     * Accède à l'image de fond du cadran.
     * @return Retourne l'image à afficher en fond.
     */
    protected abstract Image getImage();
}
