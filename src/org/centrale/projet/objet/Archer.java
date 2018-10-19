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
 *
 * Class archer qui represent un jouer dans le joue WoE
 */
public class Archer extends Personnage implements Combattant {

    private int nbFleches;

    /*atribut de la class pour savoir combien des fleches il reste*/
    /**
     * Constructeur de clasee Archer sans parametres (par défaut) initialise
     * tout en cero
     *
     */
    public Archer() {
        super();
        nbFleches = 0;
    }

    /**
     * Constructeur de la class archer que fait un copie d'un archer sur autre
     * object de la meme class
     *
     * @param a object de la class archer
     */
    public Archer(Archer a) {
        super(a.getNom(), a.getPtVie(), a.getPtMana(), a.getPourcentageAtt(), a.getPourcentagePar(), a.getPourcentageMag(), a.getPourcentageResistMag(), a.getDegAtt(), a.getDegMag(), a.getDistAttMax(), a.getPos(), a.getPtPar());
        nbFleches = a.getNbFleches();
    }

    /**
     * Constructeur de clasee Archer avec parametres
     *
     * Dans le diagram de class sur hippocampus il manque un attribut sur le
     * constructeur de Personnage il utilise 11 parametres mais sur le
     * constructeur dans le diagram de Archer il utilise seulement 10
     *
     * @param nom nom du personnage
     * @param pV points de vie
     * @param ptM points magics
     * @param pA pourcentage attack
     * @param pP pourcentage par
     * @param pM pourcentage magie
     * @param rM resistence magie
     * @param dA damage attack
     * @param dM damage magie
     * @param distMax distance d'attack maximal
     * @param pos point 2d de la position du personage
     * @param nbF nombre de fleches
     * @param ptP
     */
    public Archer(String nom, int pV, int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int nbF, int ptP) {
        super(nom, pV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos, ptP);
        nbFleches = nbF;
    }

    /**
     *
     * @return nbFleches nombre fleches du archer
     */
    public int getNbFleches() {
        return nbFleches;
    }

    /**
     * @param nbFleches parametre qui modifie le nombre de fleches que l'archer
     * port
     *
     */
    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }

    /**
     * Methode pour arricher l'information du personnage Archer il fait un appel
     * a le method affiche de son super class mais il ajoute le nombre de
     * fleches.
     *
     *
     */
    @Override
    public void affiche() {
        super.affiche();
        System.out.println("Vous avez: " + nbFleches + " Fleches");
    }

    /**
     * Method que effectué un combat avec un créature qui est dans la zone
     * d'attaque de l'archer. Un variable random represent un dé qui est lance
     * pour savoir premierement si l'attaque est reussi. L'archer utilise un
     * fleche toujours.
     *
     * @param c parametre du class creature
     */
    @Override
    public void combattre(Creature c) {
        Random gA = new Random();
        int indiceCombat = gA.nextInt(100);
        this.setNbFleches(this.getNbFleches() - 1);

        if (indiceCombat <= this.getPourcentageAtt()) {
            /* Attaque reussi*/
            c.setPtVie(c.getPtVie() - this.getDegAtt());
            System.out.println("Combat d'archer contre" + c.getClass());
            System.out.println("Dammage Direct");
            System.out.println("Le dammge causé était: " + (this.getDegAtt()));

            c.affiche();
        } else {
            /*Attaque echoue*/
            System.out.println("L'attaque a échoué");
        }
    }

}
