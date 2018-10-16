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

    /**
     * Constructeur de nuage avec deux parametres por la position dans le monde
     *
     * @param px position en x
     * @param py position en Y
     */
    public NuageToxique(int px, int py) {
        super(px, py);
    }

    /**
     * Constructeur de nuage san parametres initialise tout en cero
     */
    public NuageToxique() {
        super(0, 0);
    }

    @Override
    public void deplacer() {
        Random gA = new Random();
        switch (gA.nextInt(8) + 1) {
            case 1:
                this.getPos().setCoordY(this.getPos().getCoordY() - 2);
                break;
            case 2:
                this.getPos().setCoordY(this.getPos().getCoordY() + 2);
                break;
            case 3:
                this.getPos().setCoordX(this.getPos().getCoordX() - 2);
                break;
            case 4:
                this.getPos().setCoordX(this.getPos().getCoordX() + 2);
                break;
            case 5:
                this.getPos().setCoordY(this.getPos().getCoordY() - 2);
                this.getPos().setCoordX(this.getPos().getCoordX() - 2);
                break;
            case 6:
                this.getPos().setCoordY(this.getPos().getCoordY() + 2);
                this.getPos().setCoordX(this.getPos().getCoordX() + 2);
                break;
            case 7:
                this.getPos().setCoordX(this.getPos().getCoordX() - 2);
                this.getPos().setCoordY(this.getPos().getCoordY() + 2);
                break;
            case 8:
                this.getPos().setCoordX(this.getPos().getCoordX() + 2);
                this.getPos().setCoordY(this.getPos().getCoordY() - 2);
                break;
            default:

                break;
        }
    }

    /**
     * Methode combattre de la nuage, parametre de la creature avec laquel la
     * nuage se battre
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
        System.out.println("**************************************");
    }

}
