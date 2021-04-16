import buttons.ButtonChronometerManager;
import buttons.ButtonChronometerPause;
import buttons.ButtonChronometerReset;
import buttons.ButtonChronometerStart;
import factories.ArabViewFactory;
import factories.ChronometerViewFactory;
import factories.NumericViewFactory;
import factories.RomanViewFactory;
import observables.Chronometer;
import views.ChronometerView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

/**
 * Classe permettant de contrôler les chronomètres.
 * Elle peut les ouvrir, les réinitialiser, les démarrer et les arrêter.
 * @author Forestier Quentin & Herzig Melvyn.
 * @date 15/04/2021
 * @version 1.0.0
 */
public class Controller
{
    /**
     * Liste des chronomètres (sujets)
     */
    private final LinkedList<Chronometer> chronometers;

    /**
     * Usines à observers, vue qui affichent les chronomètres.
     */
    private final ArabViewFactory    arabViewFactory;
    private final RomanViewFactory   romanViewFactory;
    private final NumericViewFactory numericViewFactory;

    /**
     * Constructeur.
     * @param nbChrono nombre de chronomètre à prendre en charge.
     */
    public Controller(Integer nbChrono)
    {
        chronometers = new LinkedList<Chronometer>();

        arabViewFactory    = ArabViewFactory.getInstance();
        romanViewFactory   = RomanViewFactory.getInstance();
        numericViewFactory = NumericViewFactory.getInstance();

        // Construction de la fenêtre principale.
        JFrame frame = new JFrame("Control panel");

        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(nbChrono + 1, 0));
        frame.getContentPane().add(mainPanel);

        // Ajout des panels avec boutons pour chronomètre.
        for (int i = 0; i < nbChrono; ++i)
        {
            mainPanel.add(createSpecificChronoPanel(i + 1));
        }

        // Ajout du panel de contrôl global
        mainPanel.add(createAllChronoPanel());

        // Affichage
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /**
     * Crée le panel de contrôle pour un chronomètre.
     * @param idChrono Id du chronomètre associé.
     * @return Retourne le panel avec les boutons liés au chronomètre.
     */
    private JPanel createSpecificChronoPanel(int idChrono)
    {
        Chronometer c = new Chronometer(idChrono);
        chronometers.add(c);
        JPanel line = new JPanel();

        line.add(new JLabel("Chrono #" + idChrono));
        line.add(createChronometerManagerButton(new ButtonChronometerStart(), c, "Démarrer"));
        line.add(createChronometerManagerButton(new ButtonChronometerPause(), c, "Arrêter"));
        line.add(createChronometerManagerButton(new ButtonChronometerReset(), c, "Réinitialiser"));
        line.add(createViewButton(romanViewFactory  , "Cadran romain" , c));
        line.add(createViewButton(arabViewFactory   , "Cadran arabe"  , c));
        line.add(createViewButton(numericViewFactory, "Cadran numéric", c));

        return line;
    }

    /**
     * Crée le panel de contrôle qui permet d'afficher tous les chronomètres.
     * @return Retourne le panel avec les boutons liés aux chronomètres.
     */
    private JPanel createAllChronoPanel()
    {
        JPanel line = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        line.add( new JLabel("Tous les chronos"));
        line.add( createViewButton(romanViewFactory  , "Cadran romain" , chronometers.toArray(new Chronometer[0])));
        line.add( createViewButton(arabViewFactory   , "Cadran arabe"  , chronometers.toArray(new Chronometer[0])));
        line.add( createViewButton(numericViewFactory, "Cadran numéric", chronometers.toArray(new Chronometer[0])));

        return line;
    }

    /**
     * Crée un bouton de contrôle (pause, reset, sart) lié à un chronomètre
     * @param bcm Action sur le chronomètre.
     * @param chronometer Chronomètre contrôlé.
     * @param buttonTitle Titre du bouton.
     * @return Retourne le bouton configuré avec l'action associée.
     */
    private static JButton createChronometerManagerButton(ButtonChronometerManager bcm, Chronometer chronometer , String buttonTitle)
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

    /**
     * Crée un bouton qui permet d'ouvrir une vue sur un chronomètre.
     * @param factory Usine à vue.
     * @param text Titre du bouton.
     * @param chronos Chronomètres qui seront affichés par le bouton.
     * @return Retourne le bouton configuré pour ouvrir les vue sur les chronomètres.
     */
    private JButton createViewButton(ChronometerViewFactory factory, String text, Chronometer... chronos)
    {
        JButton btn = new JButton(text);
        btn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                createFrame(factory, chronos);
            }
        });

        return btn;
    }

    /**
     * Crée une fenêtre qui affiche une vue sur les chronomètres en paramètre
     * @param factory Usine à vue.
     * @param chronos Chronomètre à observer.
     */
    private void createFrame(ChronometerViewFactory factory, Chronometer... chronos)
    {
        JFrame frame = new JFrame();
        JPanel container = new JPanel(new FlowLayout(FlowLayout.LEADING));
        LinkedList<ChronometerView> views = new LinkedList<ChronometerView>();

        // Création des vues liés aux chronomètres.
        for (Chronometer chrono: chronos)
        {
            ChronometerView view = factory.createView(chrono);
            container.add(view);
            views.add(view);
        }

        // Détachement des vues à la fermeture du programme.
        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                super.windowClosing(e);
                for(ChronometerView view : views)
                {
                    view.detach();
                }
            }
        });

        frame.getContentPane().add(container, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Entrée du programme.
     * @param args Acepte un argument: le nombre de chronomètre à utiliser.
     */
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
