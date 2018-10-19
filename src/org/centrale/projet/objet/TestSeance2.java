/*
 * Ecole Centrale de Nantes
 * Option Informatique
 * Programation Oriente a Object
 * 
 */
package org.centrale.projet.objet;

import java.util.Scanner;

/**
 *
 * @author EsauBZ
 */
public class TestSeance2 {

    public static void main(String[] args) {
        
        String startMenu;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the World of ECN!");
        System.out.println("------------------------------------------------------- \n");
        System.out.println("Start Menu:");
        System.out.println("1) Nouveau jeu ");
        System.out.println("2) Charger un jeu");
        System.out.println("3) Exit \n");
        System.out.println("Veuillez choisir votre option: ");
        startMenu = sc.next();
        System.out.println("\n");
        
        switch (startMenu) {
            case "1" : World w = new World();  /* Creation du Monde WoE */
                       int a = 1;
                       while (a < 3) {
                       /**
                       afficher tous les personnages *
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
                       break;
            
            case "2" : String menuCharge;
                       System.out.println("Menu Chargement: ");
                       System.out.println("1) Chargement Automatique");
                       System.out.println("2) Chargement Manuel ");
                       System.out.println("Choisissez l'option de chargement: ");
                       menuCharge = sc.next(); 
                       
                       switch(menuCharge){
                           
                           case "1" : 
                                      System.out.println("Chargement Complet! \n");
                                      break;
                                      
                           case "2" : String fichierNom;
                                      System.out.println("Ecrivez le nom du ficher à charger: ");
                                      fichierNom = sc.next();
                                      ChargementPartie load = new ChargementPartie(fichierNom);
                                      break;
                           default :  System.out.println("Vous n'avez suivi les instructions! See ya later! \n");
                                      break;
                       }
                       
                       break;
                    
            case "3" : System.out.println("Merci de jouer World of ECN \n");
                       break;
                    
            default :  System.out.println("Merci de jouer World of ECN \n");
                       break;
        }
    }

   
}


