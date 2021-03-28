package observables;

import views.Observer;

import java.util.LinkedList;

public class Subject
{
    LinkedList<Observer> observers;

    Subject()
    {
        observers = new LinkedList<>();
    }

    public void attach(Observer o)
    {
        observers.add(o);
    }

    public void detach(Observer o)
    {
        observers.remove(o);
    }

    public void notifyObservers()
    {
        for (Observer o : observers)
        {
            o.update();
        }
    }
}
