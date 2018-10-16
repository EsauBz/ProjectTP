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
public class Creature extends ElementDeJeu implements Deplacable {
   
    private int ptVie;
    /* parametre point de vie*/
    private int pourcentageAtt;
    /* parametre pourcentage attack*/
    private int pourcentagePar;
    /* pourcentage par*/
    private int degAtt;
    /* damage attack*/
    private int ptPar;

    /**
     * Constructeur de la super class Creature avec parametres
     *
     * @param pV point de vie
     * @param pA pourcentage attack
     * @param pP pourcentage par
     * @param dA damage
     * @param pos position (point2d)
     * @param ptP
     */
    public Creature(int pV, int pA, int pP, int dA, Point2D pos, int ptP) {
        super(pos);
        ptVie = pV;
        pourcentageAtt = pA;
        pourcentagePar = pP;
        degAtt = dA;
        ptPar = ptP;     
    }

    /**
     * constructeur de la super class creature sans parametres, initialise tout
     * en cero
     */
    public Creature() {
        super(0,0);
        ptVie = 0;
        pourcentageAtt = 0;
        pourcentagePar = 0;
        degAtt = 0;
        ptPar = 0;        
    }
  

    /**
     *
     * @return point de vie
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     *
     * @return pourcentace attack
     */
    public int getPourcentageAtt() {
        return pourcentageAtt;
    }

    /**
     *
     * @return
     */
    public int getPourcentagePar() {
        return pourcentagePar;
    }

    /**
     *
     * @return
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     *
     * @return
     */
    public int getPtPar() {
        return ptPar;
    }

    /**
     *
     * @param ptVie
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    /**
     *
     * @param pourcentageAtt
     */
    public void setPourcentageAtt(int pourcentageAtt) {
        this.pourcentageAtt = pourcentageAtt;
    }

    /**
     *
     * @param pourcentagePar
     */
    public void setPourcentagePar(int pourcentagePar) {
        this.pourcentagePar = pourcentagePar;
    }

    /**
     *
     * @param degAtt
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     *
     * @param ptPar
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    /**
     * Methode deplace: cet methode donne la possibilite de changer la position
     * d'un creature dans 8 directions differents, pour le moment avec un switch
     * que change aleatoirement
     *
     */
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

}
