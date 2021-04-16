package buttons;

import observables.Chronometer;

/**
 * Classe permettant au bouton de mettre en pause un chronomètre.
 * @author Forestier Quentin & Herzig Melvyn
 * @date 15/04/2021
 * @version 1.0.0
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