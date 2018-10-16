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
 */
public class TestSeance2 {

    public static void main(String[] args) {

        /**
         * Creation du Monde WoE *
         */
        World w = new World();        
        
        int a = 1;
       while (a < 3) {
            /**
              affiche tous les personnages *
              */     
           if(a==1){
                w.afficheWorld();
                a++;
           }
            w.getListJouer().get(0).getPerso().affiche();
            /**
             * Tour de Jeu*
             */
            w.tourdeJeu();           
        }      
       /*
        Joueur p1 = new Joueur();
        Joueur p2 = new Joueur();        
        p1.getPerso().affiche();
        
        p2.getPerso().affiche();
*/
    }
}


