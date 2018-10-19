/*
 * Ecole Centrale de Nantes
 * Option Informatique
 * Programation Oriente a Object
 * 
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 *
 * @author EsauBZ
 */
public class Guerrier extends Personnage implements Combattant {

    /**
     * Constructeur de la class Guerrier, il fait un appel a le constructeur de
     * la super class que recoit tout le parametres
     *
     * @param nom nombre du personnage
     * @param pV points de vie
     * @param ptM points magie
     * @param pA pourcentage attack
     * @param pP pourcentage par
     * @param pM pourcentage magie
     * @param rM resistence magie
     * @param dA damage
     * @param dM damage magie
     * @param distMax distance d'attack maximal
     * @param p point 2d de la position du personage
     * @param ptP
     */
    public Guerrier(String nom, int pV, int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D p, int ptP) {
        super(nom, pV, ptM, pA, pP, pM, rM, dA, dM, distMax, p, ptP);
    }

    /**
     *
     */
    public Guerrier() {
        super();
    }

    /**
     * Method que effectué un combat avec un créature qui est proche
     *
     * @param c parametre du class creature pour combattre
     */
    @Override
    public void combattre(Creature c) {
        Random gA = new Random();
        int indiceCombat = gA.nextInt(100);
        if(indiceCombat <= this.getPourcentageAtt()){
            System.out.println("L'at");
        }
    }
}
