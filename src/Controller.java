import buttons.ButtonChronometerManager;
import buttons.ButtonChronometerPause;
import buttons.ButtonChronometerReset;
import buttons.ButtonChronometerStart;
import factories.ArabViewFactory;
import factories.ChronometerViewFactory;
import factories.NumericViewFactory;
import factories.RomanViewFactory;
import observables.Chronometer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Controller
{
    private LinkedList<Chronometer> chronometers;

    private final RomanViewFactory romanViewFactory;
    private final ArabViewFactory arabViewFactory;
    private final NumericViewFactory numericViewFactory;

    public Controller(Integer nbChrono)
    {
        chronometers = new LinkedList<Chronometer>();

        romanViewFactory = RomanViewFactory.getInstance();
        arabViewFactory = ArabViewFactory.getInstance();
        numericViewFactory = NumericViewFactory.getInstance();

        // Construction de la fenêtre
        JFrame frame = new JFrame("Control panel");

        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(nbChrono + 1, 0));
        frame.getContentPane().add(mainPanel);

        // Ajout des panels avec boutons pour chronomètre.
        for (int i = 0; i < nbChrono; ++i)
        {
            mainPanel.add(createChronoPanel(i + 1));
        }


        mainPanel.add(createAllChronoPanel());


        // Affichage
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private JPanel createChronoPanel(int idChrono)
    {
        Chronometer c = new Chronometer(idChrono);
        chronometers.add(c);
        JPanel line = new JPanel();

        line.add(new JLabel("Chrono #" + idChrono));
        line.add(createChronometerManagerButton(new ButtonChronometerStart(), c, "Démarrer"));
        line.add(createChronometerManagerButton(new ButtonChronometerPause(), c, "Arrêter"));
        line.add(createChronometerManagerButton(new ButtonChronometerReset(), c, "Réinitialiser"));
        line.add(createViewButton(romanViewFactory, "Cadran romain", c));
        line.add(createViewButton(arabViewFactory, "Cadran arabe", c));
        line.add(createViewButton(numericViewFactory, "Cadran numéric", c));

        return line;
    }

    private JPanel createAllChronoPanel()
    {
        JPanel line = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel lbl = new JLabel("Tous les chronos");
        JButton b4 = createViewButton(romanViewFactory, "Cadran romain", chronometers.toArray(new Chronometer[0]));
        JButton b5 = createViewButton(arabViewFactory, "Cadran arabe", chronometers.toArray(new Chronometer[0]));
        JButton b6 = createViewButton(numericViewFactory, "Cadran numéric", chronometers.toArray(new Chronometer[0]));
        line.add(lbl);
        line.add(b4);
        line.add(b5);
        line.add(b6);

        return line;
    }

    public static JButton createChronometerManagerButton(ButtonChronometerManager bcm, Chronometer chronometer , String buttonTitle)
    {
        JButton button = new JButton(buttonTitle);

        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                bcm.manage(chronometer);
            }
        });

        return button;
    }

    private JButton createViewButton(ChronometerViewFactory factory, String text, Chronometer... c)
    {
        JButton btn = new JButton(text);
        btn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                factory.createView(c);
            }
        });

        return btn;
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
