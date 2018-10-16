/*
 Ecole Centrale de Nantes
 * Option Informatique
 * Programation Oriente a Object
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 *
 * @author EsauBZ
 */
public class Soin extends Potion {

    int pointPotion;

    public Soin(int pointx, int pointy) {
        super(pointx, pointy);
        Random gA = new Random();
        pointPotion = 25;
    }

    public Soin(Point2D p) {
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
        System.out.println("Potion Soin: " + pointPotion + "Points");
        this.getPos().affiche();
        System.out.println("**************************************");        
    }
}
