/*
 -----------------------------------------------------------------------------------
 Cours       : MCR
 Fichier     : button.ButtonChronometerManager.java
 Auteur(s)   : Forestier Quentin & Herzig Melvyn
 Date        : 15.04.2021
 -----------------------------------------------------------------------------------
 */

package buttons;

import observables.Chronometer;

/**
 * Permet de définir un comportement pour le bouton vis-à-vis de son chronomètre.
 * @author Forestier Quentin & Herzig Melvyn
 * @date 15/04/2021
 * @version 1.0.0
 */
public abstract class ButtonChronometerManager
{
   /**
    * Effectue une action sur le chronomètre c.
    * @param c Chronomètre à manipuler.
    */
   public abstract void manage(Chronometer c);
}
