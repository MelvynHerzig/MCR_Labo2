/*
 -----------------------------------------------------------------------------------
 Cours       : MCR
 Fichier     : button.ButtonChronometerStart.java
 Auteur(s)   : Forestier Quentin & Herzig Melvyn
 Date        : 01.04.2021
 -----------------------------------------------------------------------------------
 */

package buttons;

import observables.Chronometer;

/**
 * Classe permettant au bouton de démarrer un chronomètre.
 * @author Forestier Quentin & Herzig Melvyn
 * @date 01/04/2021
 */
public class ButtonChronometerStart extends ButtonChronometerManager
{
   /**
    * Démarre le chronomètre c.
    * @param c Chronomètre à manipuler.
    */
   public void manage(Chronometer c)
   {
      c.start();
   }
}
