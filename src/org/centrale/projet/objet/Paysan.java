/*
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
public class Paysan extends Personnage{
    
    public Paysan(){
        super();
    }
    public Paysan(Paysan p){
        super(p.getNom(),p.getPtVie(),p.getPtMana(),p.getPourcentageAtt(),p.getPourcentagePar(),p.getPourcentageMag(),p.getPourcentageResistMag(),p.getDegAtt(),p.getDegMag(),p.getDistAttMax(),p.getPos(), p.getPtPar());
        
    }
    public Paysan(String nom, int pV, int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D p, int ptP){
        super(nom, pV, ptM, pA, pP, pM, rM, dA, dM, distMax, p, ptP);
    }
    
}
