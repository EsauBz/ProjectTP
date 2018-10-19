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
public class Loup extends Monstre implements Combattant {

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
     * Method que effectué un combat corps a corps du Loup contre un creature.
     * Un variable random represent un dé qui est lance pour savoir premierement
     * si l'attaque est reussi. La creature peut se protege et pour un dé
     * (random) est lance.
     *
     * @param c parametre du class creature pour combattre.
     */
    @Override
    public void combattre(Creature c) {
        Random gA = new Random();
        int indiceCombat = gA.nextInt(100);
        if (indiceCombat <= this.getPourcentageAtt()) {/* attaque reussi*/

            System.out.println("Combat de Loup contre" + c.getClass());
            System.out.println("L'attaque était certaine");

            indiceCombat = gA.nextInt(100);
            /* lance le dé un autre fois*/
            if (indiceCombat <= c.getPourcentagePar()) {
                c.setPtVie(c.getPtVie() - (this.getDegAtt() - c.getPtPar()));

                System.out.println("la créature était protégée");
                System.out.println("Le dammge causé était: " + (this.getDegAtt() - c.getPtPar()));
            } else {
                c.setPtVie(c.getPtVie() - this.getDegAtt());

                System.out.println("Dammage Direct");
                System.out.println("Le dammge causé était: " + (this.getDegAtt()));
            }
            c.affiche();
        } else {
            /* attaque echoue*/
            System.out.println("L'attaque a échoué");
        }
    }
}
