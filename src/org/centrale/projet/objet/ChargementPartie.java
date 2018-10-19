/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author guiishida
 */
public class ChargementPartie {
    
    //attribut nomFichier contenant le nom du fichier à charger
    private final String nomFichier;
    
    //attribut responsable pour faire la lecture du fichier qu'on chargera
    private BufferedReader fichier;
    
    /**
     * Constructeur de la class ChargementPartie avec un parametre
     * 
     *
     * @param fichierNom de type String
     */
    
    public ChargementPartie(String fichierNom){
        nomFichier = fichierNom; 
    }
    
    public void chargerPartie(){ //type World
        lecture();
        
        
        
        return;
    }
    
    /**
     * 
     * Methode lecture() pour faire la lecture du fichier
     * 
    */
    public void lecture(){
        try {
            String ligne;
            fichier = new BufferedReader(new FileReader(nomFichier));
            ligne = fichier.readLine();
            String delimiteurs = " ,.;";
            if (ligne != null) {
                int coordX = 0;
                int coordY = 0;
                // on declare un 'tokenizer' pour decouper chaque ligne
                // en fonction des delimiteurs
                StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteurs);
                                
                // If pour récuperer la valeur de la largeur du monde
                if (tokenizer.hasMoreTokens()){
                    String mot1 = tokenizer.nextToken();
                    String largueur = tokenizer.nextToken();
                    try {
                        coordX = Integer.parseInt(largueur);
                    } catch (NumberFormatException e) {
                        System.err.println(e.getMessage());  
                    }  
                }
                ligne = fichier.readLine();
                
                // If pour récuperer la valeur de l'hauteur du monde
                if (tokenizer.hasMoreTokens()){
                    String mot2 = tokenizer.nextToken();
                    String hauteur = tokenizer.nextToken();
                    try {
                        coordY = Integer.parseInt(hauteur);
                    } catch (NumberFormatException e) {
                        System.err.println(e.getMessage());  
                    }  
                }
                //Initialisation du monde avec un constructeur de deux parametres
                World monde = new World(coordX, coordY);
                
                while (ligne != null){
                    while(tokenizer.hasMoreTokens()) {
                        // nextToken() retourne le prochain 'mot' decoupee par les delimiteurs
                        String mot = tokenizer.nextToken();
                        
                        switch(mot){
                            
                            case "Guerrier" : 
                        }
                    }
                
                    ligne = fichier.readLine();
                }
                
            }

            fichier.close();
        } catch (IOException e) {
            System.out.println(e);
        }     
  }    
    
}
