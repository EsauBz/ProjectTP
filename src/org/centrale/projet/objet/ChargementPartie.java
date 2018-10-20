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
            if (ligne != null) { // si le fichier est rempli
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
                ligne = fichier.readLine();
                
                while (ligne != null){
                    //while(tokenizer.hasMoreTokens()) {
                        // nextToken() retourne le prochain 'mot' decoupee par les delimiteurs
                        //String mot = tokenizer.nextToken();
                        creerElementJeu(ligne, monde);                     
                    //}
                
                    ligne = fichier.readLine();
                }
                
            }

            fichier.close();
        } catch (IOException e) {
            System.out.println(e);
        }     
  }
    /**
     *Methode creerElementJeu qui creer un element du jeu selon le fichier reçu
     * @param line String qui contient le type d'element à Être cree
     * @param monde qui represente le monde à être chargé
     */
    
    public void creerElementJeu(String line, World monde){
        String delimiteurs = " ,.;";
        String mot = "0";
        StringTokenizer tokenizer_el = new StringTokenizer(line, delimiteurs);
        if (tokenizer_el.hasMoreTokens()){
            mot = tokenizer_el.nextToken();
        } 
        
        switch(mot){
            /*case "Guerrier": 
                String nom; 
                int pV = 0, ptM = 0, pA = 0, pP = 0, pM = 0, rM = 0, dA = 0, dM = 0, distMax = 0, ptP = 0, coordX = 0, coordY = 0;
                Point2D p;
                nom = tokenizer_el.nextToken();
                try {
                        pV = Integer.parseInt(tokenizer_el.nextToken());
                        ptM = Integer.parseInt(tokenizer_el.nextToken());
                        pA = Integer.parseInt(tokenizer_el.nextToken());
                        pP = Integer.parseInt(tokenizer_el.nextToken());
                        pM = Integer.parseInt(tokenizer_el.nextToken());
                        rM = Integer.parseInt(tokenizer_el.nextToken());
                        dA = Integer.parseInt(tokenizer_el.nextToken());
                        dM = Integer.parseInt(tokenizer_el.nextToken());
                        distMax = Integer.parseInt(tokenizer_el.nextToken());
                        ptP = Integer.parseInt(tokenizer_el.nextToken());
                        coordX = Integer.parseInt(tokenizer_el.nextToken());
                        coordY = Integer.parseInt(tokenizer_el.nextToken());
                } catch (NumberFormatException e) {
                        System.err.println(e.getMessage());  
                }   
                p = new Point2D(coordX, coordY);
                Guerrier(nom, pV, ptM, pA, pP, pM, rM, dA, dM, distMax, p, ptP);*/
            
            case "Mana" : 
                if (tokenizer_el.hasMoreTokens()){
                    int ptVie = 0, coordX = 0, coordY = 0;
                    try{
                        ptVie = Integer.parseInt(tokenizer_el.nextToken());
                        coordX = Integer.parseInt(tokenizer_el.nextToken());
                        coordY = Integer.parseInt(tokenizer_el.nextToken());
                    }catch (NumberFormatException e) {
                        System.err.println(e.getMessage());  
                    }
                    Mana m1 = new Mana(coordX, coordY, ptVie);
                    monde.getListPotions().add(m1);
                }
                break;
                
            case "Soin" : 
                if (tokenizer_el.hasMoreTokens()){
                    int ptVie = 0, coordX = 0, coordY = 0;
                    try{
                        ptVie = Integer.parseInt(tokenizer_el.nextToken());
                        coordX = Integer.parseInt(tokenizer_el.nextToken());
                        coordY = Integer.parseInt(tokenizer_el.nextToken());
                    }catch (NumberFormatException e) {
                        System.err.println(e.getMessage());  
                    }
                    Soin m1 = new Soin(coordX, coordY, ptVie);
                    monde.getListPotions().add(m1);
                }
                break;
            
            case "Joueur": 
                Joueur p1 = new Joueur(line);
                monde.getListJouer().add(p1);
                break;
                    
                                
         
        }
            
        
    }
    
}
