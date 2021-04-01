package observables;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;

public class Chronometer extends Subject implements ActionListener
{
    private int id;

    private final Timer timer;

    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;

    public Chronometer(int id)
    {
        this.id = id;
        timer = new Timer(1, this);
    }

    public void reset()
    {
        hours = 0;
        minutes = 0;
        seconds = 0;
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

    public int getId()
    {
        return id;
    }

    public boolean isRunning()
    {
        return timer.isRunning();
    }

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

    public int toSeconds()
    {
        return seconds;
    }

    public int toMinutes()
    {
        return minutes;
    }

    public int toHours()
    {
        return hours;
    }
}
