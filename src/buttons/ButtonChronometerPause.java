/*
 -----------------------------------------------------------------------------------
 Cours       : MCR
 Fichier     : button.ButtonChronometerPause.java
 Auteur(s)   : Forestier Quentin & Herzig Melvyn
 Date        : 01.04.2021
 -----------------------------------------------------------------------------------
 */

package buttons;

import observables.Chronometer;

/**
 * Classe permettant au bouton de mettre en pause un chronomètre.
 * @author Forestier Quentin & Herzig Melvyn
 * @date 01/04/2021
 */
public class ButtonChronometerPause extends ButtonChronometerManager
{
   /**
    * Met en pause le chronomètre c.
    * @param c Chronomètre à manipuler.
    */
   public void manage(Chronometer c)
   {
      c.stop();
   }
}