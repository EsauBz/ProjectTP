/**
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
     * Method que effectué un combat avec un créature qui est dans la zone
     * d'attaque du Mage. Un variable random represent un dé qui est lance pour
     * savoir premierement si l'attaque est reussi. Le mage utilise un point de
     * mana toujours.
     *
     * @param c parametre du class creature pour combattre
     */
    @Override
    public void combattre(Creature c) {
        Random gA = new Random();
        int indiceCombat = gA.nextInt(100);
        this.setPtMana(this.getPtMana() - 1);

        if (indiceCombat <= this.getPourcentageAtt()) {/* attaque reussi*/

            c.setPtVie(c.getPtVie() - this.getDegAtt());
            System.out.println("Combat de mage contre" + c.getClass());
            System.out.println("Dammage Direct");
            System.out.println("Le dammge causé était: " + (this.getDegAtt()));

            c.affiche();
        } else {
            /* attaque echoue*/
            System.out.println("L'attaque a échoué");
        }
    }
}
