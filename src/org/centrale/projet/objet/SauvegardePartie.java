/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.BufferedWriter;

/**
 * Classe SauvagardePartie en charge de sauvegarder une partie du jeu 
 * 
 * @author guiishida
 */

public class SauvegardePartie {
    
    //nom du fichier de sauvegarde a charger
    private String nomFichier;
    
    //attribut responsable pour sauvegarder les donnees du jeu dans un fichier
    private BufferedWriter fichier;
    
    /**
     * Constructeur avec un parametre 
     * 
     * @param fichierNom qui contient le nom du fichier à sauvegarder le jeu
     */
    public  SauvegardePartie(String fichierNom){
        nomFichier = fichierNom;
    }
    
    /**
     * Methode pour sauvegarder le jeu
     * 
     * @param monde qui represente le monde a etre sauvegarde
     */
    public void sauvegardePartie(World monde){
        
    }
    
    
}
