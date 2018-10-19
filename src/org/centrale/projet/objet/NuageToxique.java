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
public class NuageToxique extends Objet implements Deplacable, Combattant {

    private int ptVie;

    /**
     * Constructeur de nuage avec trois parametres, pour la position dans le
     * monde on a deux coordonnes et sa vie.
     *
     * @param px position en x
     * @param py position en Y
     * @param ptv
     */
    public NuageToxique(int px, int py, int ptv) {
        super(px, py);
        ptVie = ptv;
    }

    /**
     *
     * @param p point dans le monde
     * @param ptv points de vie
     */
    public NuageToxique(Point2D p, int ptv) {
        super(p);
        ptVie = ptv;
    }

    /**
     * Constructeur de nuage san parametres initialise tout en cero
     */
    public NuageToxique() {
        super(0, 0);
    }

    /**
     *
     * @param ptVie
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    /**
     *
     * @return points de vie
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     * Methode de deplacement de la nuage, le random donne un numero aleatoire
     * pour la direcction que la nuage prends dans le deplacement.
     */
    @Override
    public void deplacer() {
        Random gA = new Random();
        switch (gA.nextInt(8) + 1) {
            case 1:
                this.getPos().translate(0, -2);
                break;
            case 2:
                this.getPos().translate(0, 2);
                break;
            case 3:
                this.getPos().translate(-2, 0);
                break;
            case 4:
                this.getPos().translate(2, 0);
                break;
            case 5:
                this.getPos().translate(-2, -2);
                break;
            case 6:
                this.getPos().translate(2, 2);
                break;
            case 7:
                this.getPos().translate(-2, 2);
                break;
            case 8:
                this.getPos().translate(2, -2);
                break;
            default:

                break;
        }
    }

    /**
     * Methode combattre de la nuage, parametre de la creature avec laquel la
     * nuage se battre.
     *
     * @param cr creature pour se battre
     */
    @Override
    public void combattre(Creature cr) {

    }

    /**
     * Methode qui affiche a la nuage avec ses paramentres
     */
    @Override
    public void affiche() {
        System.out.println("");
        System.out.println("**************************************");
        System.out.println("Nuage Toxique");
        this.getPos().affiche();
        System.out.println("Vie Nuage " + ptVie);
        System.out.println("**************************************");
    }

}
