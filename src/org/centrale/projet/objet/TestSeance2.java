/*
 * Ecole Centrale de Nantes
 * Option Informatique
 * Programation Oriente a Object
 * 
 */
package org.centrale.projet.objet;

import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;
//import org.apache.commons.io.filefilter.WildcardFileFilter;

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
            
            case "2" :  String nomFichier;
                        World monde;
                        System.out.println("Choisissez le fichier que vous voulez telechargez: ");
                        nomFichier = sc.next();
                        ChargementPartie load = new ChargementPartie(nomFichier);
                        monde = load.chargerPartie();
                        int b = 1;
                        while (b < 3){
                            if( b == 1){
                                monde.afficheWorld();
                                b++;
                            }
                            monde.getListJouer().get(0).getPerso().affiche();
                            monde.tourdeJeu();
                        }
                        break;
                    
            case "3" : System.out.println("Merci de jouer World of ECN \n");
                       break;
                    
            default :  System.out.println("Merci de jouer World of ECN \n");
                       break;
        }
    }

   
}


