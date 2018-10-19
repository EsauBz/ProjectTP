/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 *
 * @author esaud
 */
public class Mage extends Personnage implements Combattant {

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

    /**
     *
     * @param c
     */
    @Override
    public void combattre(Creature c) {
        Random gA = new Random();
        int indiceCombat = gA.nextInt(100);
        this.setPtMana(this.getPtMana() - 1);
        System.out.println("************************");
        if (indiceCombat <= this.getPourcentageAtt()) {/* attaque reussi*/
            
            c.setPtVie(c.getPtVie() - this.getDegAtt());
            System.out.println("Dammage Direct");
            System.out.println("Le dammge causé était: " + (this.getDegAtt()));

        } else {
            /* attaque echoue*/
            System.out.println("L'attaque a échoué");
        }
    }
}
