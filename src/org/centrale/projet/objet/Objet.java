/**
 * Ecole Centrale de Nantes
 * Option Informatique
 * Programation Oriente a Object
 *
 */
package org.centrale.projet.objet;

/**
 *
 * @author EsauBZ
 */
public class Objet extends ElementDeJeu {

    /**
     *
     * @param x
     * @param y
     */
    public Objet(int x, int y) {
        super(x, y);
    }

    /**
     * Constructeur avec un parametre Point2D
     */
    public Objet(Point2D p) {
        super(p);
    }

    /**
     * Constructeur par defaut sans parametres initialise tout en cero
     */
    public Objet() {
        super(0, 0);
    }

}
