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
public class ElementDeJeu {

    private Point2D pos;

    /* parametre de point sur le plane*/

    /**
     * Constructuer element de jeu avec un point2d
     *
     * @param p
     */
    public ElementDeJeu(Point2D p) {
        pos = new Point2D(p);
    }

    /**
     * Constucteur d'element de jeu avec ses positions dans le monde avec deux
     * integers
     *
     * @param x
     * @param y
     */
    public ElementDeJeu(int x, int y) {
        pos = new Point2D(x, y);
    }

    public void affiche() {

    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

}
