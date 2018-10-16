/**
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
public class Monstre extends Creature {

    /**
     * Constructeur avec parametres de la super class Monstre
     *
     * @param pV Les points de vie du Monstre
     * @param pA Le pourcentage d'Attack du Monstre
     * @param pP Le pourcentage de par du Monstre
     * @param dA Les points de damage attack
     * @param pos variable (point) qui represent la position du Monstre
     * @param ptP
     */
    public Monstre(int pV, int pA, int pP, int dA, Point2D pos, int ptP) {
        super(pV, pA, pP, dA, pos, ptP);

    }

    /**
     * Constructeur avec un parametre de type monstre
     *
     * @param m (class monstre) reçoit un objet du type monstre et fait un copie
     */
    public Monstre(Monstre m) {
        super(m.getPtVie(), m.getPourcentageAtt(), m.getPourcentagePar(), m.getDegAtt(), m.getPos(), m.getPtPar());
    }

    /**
     * Constructeur sans parametres du class monstre qui initialise tous en cero
     */
    public Monstre() {
        super();
    }

    /**
     * methode affiche: cet methode affiche toute l'information du Monstre touts
     * les parametres initiaux sont affiches dans l'ecran avec un petit
     * description.
     *
     */
    public void affiche() {

        System.out.println("");
        System.out.println("**************************************");
        System.out.println(this.getClass().toString());
        System.out.println("Le Monstre a " + this.getPtVie() + " points de vie");
        System.out.println("Pourcentage d'attaque du Monstre: " + this.getPourcentageAtt());
        System.out.println("Pourcentage de Par du Monstre: " + this.getPourcentagePar());
        System.out.println("Damage Attaque du Monstre: " + this.getDegAtt());
        this.getPos().affiche();
    }
}
