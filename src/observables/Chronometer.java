package observables;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chronometer extends Subject implements ActionListener
{
    private int elapsedTime;
    private final Timer timer;
    private int id;

    public Chronometer(int id)
    {
        this.id = id;
        elapsedTime = 0;
        timer = new Timer(1000, this);
    }

    public void reset()
    {
        elapsedTime = 0;
        notifyObservers();
    }

    public void stop()
    {
        timer.stop();
    }

    public void start()
    {
        timer.start();
    }

    public int getElapsedTime()
    {
        return elapsedTime;
    }

    public int getId()
    {
        return id;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(timer.isRunning())
        {
            ++elapsedTime;
            notifyObservers();
        }
    }
}
