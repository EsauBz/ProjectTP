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
 * @author ishida
 */
public class Point2D {

    private int coordX;
    private int coordY;

    /**
     * Constructor sans parametres initialise les deux parametres en cero
     */
    public Point2D() {
        coordX = 0;
        coordY = 0;
    }

    /**
     * Constructor avec parametres
     *
     * @param x coordX s'initialise dans le valeur de X
     * @param y coordY s'initialise dans le valeur de Y
     */
    public Point2D(int x, int y) {
        coordX = x;
        coordY = y;
    }

    /**
     * Constructor avec parametre object Point2D
     *
     * @param objt (class Point2D) represent l'objet Point qu'on veut faire un
     * copie
     */
    public Point2D(Point2D objt) {
        coordX = objt.getCoordX();
        coordY = objt.getCoordY();
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public void setPosition(int x, int y) {
        coordX = x;
        coordY = y;
    }

    /**
     * @param dx valeur du differentiel qu'on veut faire a la position du
     * coordone X
     * @param dy valeur du differentiel qu'on veut faire a la position du
     * coordone Y
     */
    public void translate(int dx, int dy) {
        coordX = coordX + dx;
        coordY = coordY + dy;
    }

    /**
     * methode qui affiche les valeurs de coordX et coordY qui represent une
     * position dans le joue
     */
    public void affiche() {

        System.out.println("[Position en X: " + coordX + " Position en Y: " + coordY + "]");       
    }

    /**
     *
     * @param p point2d
     * @return float represent distance entre deux points
     */
    public float distance(Point2D p) {
        float dif;
        dif = (float) Math.sqrt(Math.pow(Math.abs(coordX - p.getCoordX()), 2) + Math.pow(Math.abs(coordY - p.getCoordY()), 2));
        return dif;
    }

    /**
     *
     * @param p la fonction recoit un point pour verifier si a la meme position
     * @return un boolean True si les points ont la meme position False sinon.
     */
    public boolean memePos(Point2D p) {
        boolean dif = false;
        if (p.getCoordX() == this.coordX && p.getCoordY() == this.coordY) {
            dif = true;
        }
        return dif;
    }
}
