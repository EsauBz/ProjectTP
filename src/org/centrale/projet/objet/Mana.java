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
public class Mana extends Potion {

    public Mana(int pointx, int pointy, int pt) {
        super(pointx, pointy, pt);
    }

    public Mana(Point2D p, int pt) {
        super(p, pt);
    }

    /**
     *
     */
    @Override
    public void affiche() {
        System.out.println("**************************************");
        System.out.println("Potion Mana: " + this.getPointPotion() + "Points");
        this.getPos().affiche();   
    }
}
