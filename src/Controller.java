import observables.Chronometer;
import views.RomanView;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Controller
{
    private LinkedList<Chronometer> chronometers;

    public Controller(Integer nbChrono)
    {
        chronometers = new LinkedList<Chronometer>();

        JFrame controlFrame = new JFrame("Panneau de contrôle");
        JPanel mainPanel = new JPanel();

        Border padding = BorderFactory.createEmptyBorder(10, 5, 10, 5);
        mainPanel.setBorder(padding);

        controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlFrame.getContentPane().add(mainPanel, BorderLayout.CENTER);

        mainPanel.setLayout(new GridLayout(nbChrono + 1, 0, 10, 10));

        for (int i = 0; i < nbChrono; ++i)
        {
            createChronoInterface(mainPanel, i + 1);
        }

        createAllChronoLine(mainPanel);

        controlFrame.setResizable(false);
        controlFrame.pack();
        controlFrame.setVisible(true);
    }

    private void createChronoInterface(JPanel mainPanel, int idChrono)
    {
        Chronometer chrono = new Chronometer(idChrono);
        chronometers.add(chrono);
        JPanel timerPanel = new JPanel();
        timerPanel.setLayout(new GridLayout(0, 7, 10, 10));

        JLabel name = new JLabel("Chrono #" + chrono.getId(), JLabel.CENTER);
        timerPanel.add(name);

        JButton start = new JButton("Démarrer");
        start.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                chrono.start();
            }
        });
        timerPanel.add(start);

        JButton stop = new JButton("Arrêter");
        stop.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                chrono.stop();
            }
        });
        timerPanel.add(stop);

        JButton reset = new JButton("Réinitialiser");
        stop.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                chrono.reset();
            }
        });
        timerPanel.add(reset);

        JButton roman = new JButton("Cadran romain");
        roman.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new RomanView(chrono);
            }
        });
        timerPanel.add(roman);

        JButton arab = new JButton("Cadran arabe");
        arab.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new RomanView(chrono);
            }
        });
        timerPanel.add(arab);

        JButton numeric = new JButton("Cadran numérique");
        numeric.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new RomanView(chrono);
            }
        });
        timerPanel.add(numeric);


        mainPanel.add(timerPanel);
    }

    private void createAllChronoLine(JPanel mainPanel)
    {
        JPanel timerPanel = new JPanel();
        timerPanel.setLayout(new GridLayout(0, 7, 20, 10));

        for (int i = 0; i < 3; ++i)
        {
            JLabel tmp = new JLabel();
            timerPanel.add(tmp);
        }

        JLabel lbl = new JLabel("Tous les chronos");
        timerPanel.add(lbl);

        JButton roman = new JButton("Cadran romain");
        roman.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new RomanView(chronometers);
            }
        });
        timerPanel.add(roman);

        JButton arab = new JButton("Cadran arabe");
        arab.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new RomanView(chronometers);
            }
        });
        timerPanel.add(arab);

        JButton numeric = new JButton("Cadran numérique");
        numeric.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new RomanView(chronometers);
            }
        });
        timerPanel.add(numeric);


        mainPanel.add(timerPanel);
    }


    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.out.println("Argument missing : number of chronometer");
            return;
        }
        new Controller(Integer.parseInt(args[0]));


    }

}
