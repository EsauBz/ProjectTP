/*
 * Ecole Centrale de Nantes
 * Option Informatique
 * Programation Oriente a Object
 */
package org.centrale.projet.objet;

/**
 *
 * @author EsauBZ
 */
public class Potion extends Objet{     

    int pointPotion;
    /**
     * 
     * @param x
     * @param y 
     * @param pt 
     */
    public Potion(int x, int y, int pt) {
        super(x,y);           
        pointPotion = pt;
    }
    /**
     * 
     * @param p 
     * @param pt 
     */
    public Potion(Point2D p, int pt) {
        super(p);   
        pointPotion = pt;
    }

    public int getPointPotion() {
        return pointPotion;
    }

    public void setPointPotion(int pointPotion) {
        this.pointPotion = pointPotion;
    }
       
}
