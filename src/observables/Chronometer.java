/*
 -----------------------------------------------------------------------------------
 Cours       : MCR
 Fichier     : observables.Chronometer.java
 Auteur(s)   : Forestier Quentin & Herzig Melvyn
 Date        : 15.04.2021
 -----------------------------------------------------------------------------------
 */

package observables;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe implémentant un chronomètre observable.
 * @author Forestier Quentin & Herzig Melvyn.
 * @date 15/04/2021
 * @version 1.0.0
 */
public class Chronometer extends Subject implements ActionListener
{
    /**
     * Identifiant du chronomètre.
     */
    private final int id;

    /**
     * Timer qui rythme le chronomètre.
     */
    private final Timer timer;

    /**
     * Heures écoulées
     */
    private int hours = 0;

    /**
     * Minutes écoulées
     */
    private int minutes = 0;

    /**
     * Secondes écoulées
     */
    private int seconds = 0;

    /**
     * Constructeur
     * @param id Identifiant du chronomètre
     */
    public Chronometer(int id)
    {
        this.id = id;
        timer = new Timer(1000, this);
    }

    /**
     * Réinitialise le chronomètre.
     */
    public void reset()
    {
        hours = 0;
        minutes = 0;
        seconds = 0;
        notifyObservers();
    }

    /**
     * Arrête le chronomètre
     */
    public void stop()
    {
        timer.stop();
    }

    /**
     * Démarre le chronomètre
     */
    public void start()
    {
        timer.start();
    }

    /**
     * Accesseur à l'identifiant du chronomètre
     * @return Retourne l'identifiant du chronomètre.
     */
    public int getId()
    {
        return id;
    }

    /**
     * Accesseur de l'état du crhonomètre.
     * @return Retourne vrai si le chronomètre est enclenché sinon faux.
     */
    public boolean isRunning()
    {
        return timer.isRunning();
    }

    /**
     * Arrête ou démarre le chronomètre lorsque une action est faite.
     * @param e Événement de l'action effectuée.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(timer.isRunning())
        {
            ++seconds;
            if(seconds == 60)
            {
                ++minutes;

                if(minutes == 60)
                {
                    ++hours;
                    minutes = 0;
                }

                seconds = 0;
            }

            notifyObservers();
        }
    }

    /**
     * Accesseur au nombre de seconde en cours
     * @return Retourne le nombre de secondes actuelles.
     */
    public int getSeconds()
    {
        return seconds;
    }

    /**
     * Accesseur au nombre de minutes en cours.
     * @return Retourne le nombre de minutes actuelles.
     */
    public int getMinutes()
    {
        return minutes;
    }

    /**
     * Accesseur au nombre d'heures en cours.
     * @return Retourne le nombre d'heures actuelles.
     */
    public int getHours()
    {
        return hours;
    }
}
