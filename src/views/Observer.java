/*
 -----------------------------------------------------------------------------------
 Cours       : MCR
 Fichier     : views.Observer.java
 Auteur(s)   : Forestier Quentin & Herzig Melvyn
 Date        : 15.04.2021
 -----------------------------------------------------------------------------------
 */

package views;

/**
 * Interface à utiliser pour définir un observateur.
 * @author Forestier Quentin & Herzig Melvyn.
 * @date 15/04/2021
 * @version 1.0.0
 */
public interface Observer
{
    /**
     * Méthode appelée pour mettre à jour l'observateur
     */
    void update();
}
