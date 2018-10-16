/*
 * Ecole Centrale de Nantes
 * Option Informatique
 * Programation Oriente a Object
 * 
 */
package org.centrale.projet.objet;

/**
 *
 * @author EsauBZ
 */
public class Loup extends Monstre implements Combattant{

    /**
     * Constructeur avec parametres de la class loup
     *
     * @param pV points de vie
     * @param pA points d'attack
     * @param pP pourcentage par
     * @param dA damage
     * @param p point 2d position du loup
     * @param ptP
     */
    public Loup(int pV, int pA, int pP, int dA, Point2D p, int ptP) {
        super(pV, pA, pP, dA, p, ptP);
    }

    /**
     * constructeur sans parametres qui initialise tout en cero
     */
    public Loup() {
        super();
    }

    /**
     *
     * @param c
     */
    public void combattre(Creature c) {

    }
}
