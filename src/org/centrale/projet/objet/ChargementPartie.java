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
    
    public World chargerPartie(){ //type World
        World monde = null;
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
                monde = new World(coordX, coordY);
                ligne = fichier.readLine();
                
                while (ligne != null){
                    creerElementJeu(ligne, monde);                     
                    ligne = fichier.readLine();
                }
            }
            fichier.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
              
        return monde;
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
            case "Guerrier": 
                if (tokenizer_el.hasMoreTokens()){    
                    String nom; 
                    int pV = 0, ptM = 0, pA = 0, pP = 0, pM = 0, rM = 0, dA = 0, dM = 0, distMax = 0, ptP = 0, coordX = 0, coordY = 0;
                    Point2D p = null;
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
                        p = new Point2D(coordX, coordY);
                    } catch (NumberFormatException e) {
                        System.err.println(e.getMessage());  
                    }   
                    Guerrier g1 = new Guerrier(nom, pV, ptM, pA, pP, pM, rM, dA, dM, distMax, p, ptP);
                    monde.getListPersonnages().add(g1);
                }
                break;
            
            case "Mage": 
                if (tokenizer_el.hasMoreTokens()){    
                    String nom; 
                    int pV = 0, ptM = 0, pA = 0, pP = 0, pM = 0, rM = 0, dA = 0, dM = 0, distMax = 0, ptP = 0, coordX = 0, coordY = 0;
                    Point2D p = null;
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
                        p = new Point2D(coordX, coordY);
                    } catch (NumberFormatException e) {
                        System.err.println(e.getMessage());  
                    }   
                    Mage m1 = new Mage(nom, pV, ptM, pA, pP, pM, rM, dA, dM, distMax, p, ptP);
                    monde.getListPersonnages().add(m1);
                }
                break;
                
            case "Paysan": 
                if (tokenizer_el.hasMoreTokens()){    
                    String nom; 
                    int pV = 0, ptM = 0, pA = 0, pP = 0, pM = 0, rM = 0, dA = 0, dM = 0, distMax = 0, ptP = 0, coordX = 0, coordY = 0;
                    Point2D p = null;
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
                        p = new Point2D(coordX, coordY);
                    } catch (NumberFormatException e) {
                        System.err.println(e.getMessage());  
                    }   
                    Paysan p1 = new Paysan(nom, pV, ptM, pA, pP, pM, rM, dA, dM, distMax, p, ptP);
                    monde.getListPersonnages().add(p1);
                }
                break;  
                
            case "Archer": 
                if (tokenizer_el.hasMoreTokens()){    
                    String nom; 
                    int pV = 0, ptM = 0, pA = 0, pP = 0, pM = 0, rM = 0, dA = 0, dM = 0, distMax = 0, ptP = 0, coordX = 0, coordY = 0, nbF = 0;
                    Point2D p = null;
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
                        p = new Point2D(coordX, coordY);
                        if (tokenizer_el.hasMoreTokens()){
                            nbF = Integer.parseInt(tokenizer_el.nextToken()); //Au cas il s'agit d'un Archer - récuperer son nombre de Fleches 
                        }
                    } catch (NumberFormatException e) {
                        System.err.println(e.getMessage());  
                    }   
                    Archer a1 = new Archer(nom, pV, ptM, pA, pP, pM, rM, dA, dM, distMax, p, nbF, ptP);
                    monde.getListPersonnages().add(a1);
                }
                break;    
            
            case "Loup" :
                 if (tokenizer_el.hasMoreTokens()){
                    int ptVie = 0, pA = 0, pP = 0, dA = 0, coordX = 0, coordY = 0, ptP = 0;
                    Point2D p = null;
                    try{
                        ptVie = Integer.parseInt(tokenizer_el.nextToken());
                        pA = Integer.parseInt(tokenizer_el.nextToken());
                        pP = Integer.parseInt(tokenizer_el.nextToken());
                        dA = Integer.parseInt(tokenizer_el.nextToken());
                        ptP = Integer.parseInt(tokenizer_el.nextToken());
                        coordX = Integer.parseInt(tokenizer_el.nextToken());
                        coordY = Integer.parseInt(tokenizer_el.nextToken());
                        p = new Point2D(coordX, coordY);
                    }catch (NumberFormatException e) {
                        System.err.println(e.getMessage());  
                    }
                    Loup l1 = new Loup(ptVie, pA, pP, dA, p, ptP);
                    monde.getListMonstres().add(l1);
                 } 
                 break;
            
            case "Lapin" :
                 if (tokenizer_el.hasMoreTokens()){
                    int ptVie = 0, pA = 0, pP = 0, dA = 0, coordX = 0, coordY = 0, ptP = 0;
                    Point2D p = null;
                    try{
                        ptVie = Integer.parseInt(tokenizer_el.nextToken());
                        pA = Integer.parseInt(tokenizer_el.nextToken());
                        pP = Integer.parseInt(tokenizer_el.nextToken());
                        dA = Integer.parseInt(tokenizer_el.nextToken());
                        ptP = Integer.parseInt(tokenizer_el.nextToken());
                        coordX = Integer.parseInt(tokenizer_el.nextToken());
                        coordY = Integer.parseInt(tokenizer_el.nextToken());
                        p = new Point2D(coordX, coordY);
                    }catch (NumberFormatException e) {
                        System.err.println(e.getMessage());  
                    }
                    Lapin la1 = new Lapin(ptVie, pA, pP, dA, p, ptP);
                    monde.getListMonstres().add(la1);
                 } 
                 break;
           
            case "NuageToxique" : 
                if (tokenizer_el.hasMoreTokens()){
                    int ptVie = 0, coordX = 0, coordY = 0;
                    try{
                        ptVie = Integer.parseInt(tokenizer_el.nextToken());
                        coordX = Integer.parseInt(tokenizer_el.nextToken());
                        coordY = Integer.parseInt(tokenizer_el.nextToken());
                    }catch (NumberFormatException e) {
                        System.err.println(e.getMessage());  
                    }
                    NuageToxique nt1 = new NuageToxique(coordX, coordY, ptVie);
                    monde.getListNuageToxique().add(nt1);
                    
                }
                break;
                 
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
                
            case "Nourriture" : 
                if (tokenizer_el.hasMoreTokens()){
                    Point2D p = null;
                    int value = 0, duration = 0, coordX = 0, coordY = 0;
                    String type = null, caract = null;
                    try{
                        type = tokenizer_el.nextToken();
                        caract = tokenizer_el.nextToken(); 
                        value = Integer.parseInt(tokenizer_el.nextToken());
                        duration = Integer.parseInt(tokenizer_el.nextToken());
                        coordX = Integer.parseInt(tokenizer_el.nextToken());
                        coordY = Integer.parseInt(tokenizer_el.nextToken());
                        p = new Point2D(coordX, coordY);
                    }catch (NumberFormatException e) {
                        System.err.println(e.getMessage());  
                    }
                    Nourriture n1 = new Nourriture(type, caract, value, duration, p);
                    monde.getListNourriture().add(n1);
                }
                break;
            
            case "Joueur": 
                Joueur p1 = new Joueur(line);
                monde.getListJouer().add(p1);
                break;    
                
            default :
                System.out.println("Errer! Classe non existante! ");
                break;
         
        }
    }
}
