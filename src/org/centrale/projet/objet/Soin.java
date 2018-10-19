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

    public Soin(int pointx, int pointy, int pt) {
        super(pointx, pointy, pt);
        Random gA = new Random();
    }

    public Soin(Point2D p, int pt) {
        super(p, pt);
        Random gA = new Random();
    }

    /**
     *
     */
    @Override
    public void affiche() {
        System.out.println("**************************************");
        System.out.println("Potion Soin: " + this.getPointPotion() + "Points");
        this.getPos().affiche();
        System.out.println("**************************************");
    }
}
