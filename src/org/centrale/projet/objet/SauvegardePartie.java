/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

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
     * @param fichierNom contient le nom du fichier qu'on va utiliser pour sauvegarder
     */
    public void sauvegardePartie(World monde, String fichierNom){
        BufferedWriter bufferedWriter = null;
        String ligne = null;
            
        try {
            // Creation du BufferedWriter
            bufferedWriter = new BufferedWriter(new FileWriter(fichierNom)); 
            // On ecrit dans le fichier
            bufferedWriter.write("Largeur " + monde.getTailleX()); //On ecrit la largeur
            bufferedWriter.newLine();
            bufferedWriter.write("Hauteur " + monde.getTailleY()); // On ecrit l'hauteur
            bufferedWriter.newLine();
            //For pour sauvegarder les personnages non controles par un humain
            for (int x = 0; x < monde.getListPersonnages().size(); x++){
                ligne = getTexteSauvegarde(monde.getListPersonnages().get(x));
                bufferedWriter.write(ligne + "\n"); 
            }
            //For pour sauvegarder les monstres
            for (int x = 0; x < monde.getListMonstres().size(); x++){
                ligne = getTexteSauvegarde(monde.getListMonstres().get(x));
                bufferedWriter.write(ligne + "\n"); 
            }
            //For pour sauvegarder les potions
            for (int x = 0; x < monde.getListPotions().size(); x++){
                ligne = getTexteSauvegarde(monde.getListPotions().get(x));
                bufferedWriter.write(ligne + "\n"); 
            }
            //For pour sauvegarder les joueurs
            for (int x = 0; x < monde.getListJouer().size(); x++){
                ligne = getTexteSauvegarde(monde.getListJouer().get(x).getPerso());
                bufferedWriter.write(ligne + "\n"); 
            }
        }
        // on attrape l'exception si on a pas pu creer le fichier
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } 
        // on attrape l'exception si il y a un probleme lors de l'ecriture dans le fichier
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        // on ferme le fichier
        finally {
            try {
                if (bufferedWriter != null) {
                // je force l'Ã©criture dans le fichier
                bufferedWriter.flush();
                // puis je le ferme
                bufferedWriter.close();
                }
            }
            // on attrape l'exception potentielle 
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
    }
    
    /**
     * Methode pour génerer la ligne avec des informations d'un ElementDeJeu
     * 
     * @param el le methode reçoit un ElementDeJeu
     * @return la ligne contenant les informations d'un ElementDeJeu a etre sauvegarde dans le fichier
     */
    public String getTexteSauvegarde(ElementDeJeu el){
        String ligne = null;
        return ligne;
    }
    
    
}
