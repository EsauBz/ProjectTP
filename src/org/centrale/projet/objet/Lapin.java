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
 *
 */
public class Lapin extends Monstre {

    /**
     * Constructeur sans parametres de la class Lapin qui initialise tout en
     * cero
     */
    public Lapin() {
        super();
    }

    /**
     * Constructeur de la class Lapin qui initialise l'object avec les
     * parametres d'un autre object lapin
     *
     * @param i parametre lapin
     */
    public Lapin(Lapin i) {
        super(i.getPtVie(), i.getPourcentageAtt(), i.getPourcentagePar(), i.getDegAtt(), i.getPos(), i.getPtPar());
    }

    /**
     * Constructeur de la class lapin avec parametres.
     *
     * @param pV points de vie
     * @param pA pourcentage attack
     * @param pP pourcentage par
     * @param dA damage
     * @param p point 2d position
     * @param ptP
     */
    public Lapin(int pV, int pA, int pP, int dA, Point2D p, int ptP) {
        super(pV, pA, pP, dA, p, ptP);
    }
}
