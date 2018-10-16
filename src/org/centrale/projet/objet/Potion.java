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

    /**
     * 
     * @param x
     * @param y 
     */
    public Potion(int x, int y) {
        super(x,y);               
    }
    /**
     * 
     * @param p 
     */
    public Potion(Point2D p) {
        super(p);               
    }
       
}
