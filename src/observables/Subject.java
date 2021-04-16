package observables;

import views.Observer;
import java.util.LinkedList;

/**
 * Classe abstraite implémentant la base d'un objet observable.
 * @author Forestier Quentin & Herzig Melvyn.
 * @date 15/04/2021
 * @version 1.0.0
 */
public abstract class Subject
{
    /**
     * Liste de observateurs.
     */
    private final LinkedList<Observer> observers;

    /**
     * Constructeur.
     */
    Subject()
    {
        observers = new LinkedList<>();
    }

    /**
     * Attache un observateur.
     * @param o Observateur à afficher.
     */
    public void attach(Observer o)
    {
        observers.add(o);
    }

    /**
     * Enlève un observateur.
     * @param o Observateur à enlever.
     */
    public void detach(Observer o)
    {
        observers.remove(o);
    }

    /**
     * Indique aux observateur de se mettre à jour.
     */
    public void notifyObservers()
    {
        for (Observer o : observers)
        {
            o.update();
        }
    }
}
