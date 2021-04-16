package views;

import observables.Chronometer;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Classe abstraite permettant d'observer les chronomètres.
 * @author Forestier Quentin & Herzig Melvyn.
 * @date 15/04/2021
 * @version 1.0.0
 */
public abstract class ChronometerView extends JPanel implements Observer
{
    /**
     * Largeur/hauteur de la vue.
     */
    protected static final int DIMENSION = 200;

    /**
     * Chronomètre observé.
     */
    protected Chronometer chronometer;

    /**
     * Constructeur.
     * @param chrono Chronomètre à observer.
     */
    public ChronometerView(Chronometer chrono)
    {
        if(chrono == null) return;

        addMouseListener(new MouseAdapter()
        {
            // Arrêt/démarrage en cas de click.
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(chrono.isRunning())
                {
                    chrono.stop();
                }
                else
                {
                    chrono.start();
                }
            }
        });

        chrono.attach(this);
        chronometer = chrono;

        repaint();
    }

    /**
     * Accède à la taille souhaitée.
     * @return Retourne Dimension(DIMENSION, DIMENSION).
     */
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(DIMENSION, DIMENSION);
    }

    /**
     * Accède au message à afficher sur la vue.
     * @return String du message à afficher.
     */
    public String getMessage()
    {
        return String.format("Chrono #%d", chronometer.getId());
    }

    /**
     * Met à jour la vue.
     */
    @Override
    public void update()
    {
        repaint();
    }

    /**
     * Ordonne à la vue de se détacher du sujet.
     */
    public void detach()
    {
        chronometer.detach(this);
    }
}
