/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 *
 * @author esaud
 */
public class Mage extends Personnage implements Combattant{

    /**
     *
     * @param nom nom du mage
     * @param pV points de vie
     * @param ptM points de magie
     * @param pA pourcentage attack
     * @param pP pourcentage par
     * @param pM pourcentage magie
     * @param rM resistence magie
     * @param dA damage
     * @param dM damage magie
     * @param distMax distance maximal pour faire un attack
     * @param p point 2d de la position du personage
     * @param ptP
     */
    public Mage(String nom, int pV, int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D p, int ptP) {
        super(nom, pV, ptM, pA, pP, pM, rM, dA, dM, distMax, p, ptP);
    }

    /**
     * Constructeur de la class Mage sans parametres, initialise tout en cero
     * dans le constructeur de super class
     */
    public Mage() {
        super();
    }

    public void combattre(Creature c) {

    }
}
