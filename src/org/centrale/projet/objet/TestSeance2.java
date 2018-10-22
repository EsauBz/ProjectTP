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
            
            case "2" : String menuCharge;
                       System.out.println("Menu Chargement ");
                       System.out.println("Veuillez choisir le fichier que vous voulez charger: ");
                       //File folder = new File("C:\\Users\\guiishida\\CENTRALE NANTES\\Informatique\\ProgrammationObjet\\TPs\\TP6\\ProjectTP");
                       
                       /*File dir = new File(".");
                       FileFilter fileFilter = new WildcardFileFilter("*.txt");
                       File[] files = dir.listFiles(fileFilter);
                       for (int i = 0; i < files.length; i++) {
                            System.out.println((i + 1) + ") " + files[i]);
                       }*/
                       
                       /*
                       FileFilter fileFilter = new WildcardFileFilter("*.txt");
                       File[] listOfFiles = folder.listFiles();

                       for (int i = 0; i < listOfFiles.length; i++) {
                           if (listOfFiles[i].isFile()) {
                                System.out.println("File " + listOfFiles[i].getName());
                           } else if (listOfFiles[i].isDirectory()) {
                                System.out.println("Directory " + listOfFiles[i].getName());
                           }
                       }*/
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
                                      load.chargerPartie();
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


