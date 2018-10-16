/*
 * Ecole Centrale de Nantes
 * Option Informatique
 * Programation Oriente a Object
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 *
 * @author EsauBZ
 */
public class Mana extends Potion{
     int pointPotion;
    
    public Mana(int pointx, int pointy) {        
        super(pointx, pointy);
        Random gA = new Random();
        pointPotion = 25;
    }
    public Mana(Point2D p) {        
        super(p);
        Random gA = new Random();
        pointPotion = 25;
    }
    /**
     * 
     */
    @Override
    public void affiche() {
        System.out.println("");
        System.out.println("**************************************");
        System.out.println("Potion Mana: " + pointPotion + "Points");
        this.getPos().affiche();
        System.out.println("**************************************");        
    }
}
