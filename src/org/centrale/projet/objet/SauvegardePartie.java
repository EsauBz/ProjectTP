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
                ligne = getTexteSauvegarde(monde.getListPersonnages().get(x), 1);
                if (ligne != null){
                    bufferedWriter.write(ligne);
                    bufferedWriter.newLine();
                }
            }
            //For pour sauvegarder les monstres
            for (int x = 0; x < monde.getListMonstres().size(); x++){
                ligne = getTexteSauvegarde(monde.getListMonstres().get(x), 2);
                if (ligne != null){
                    bufferedWriter.write(ligne); 
                    bufferedWriter.newLine();
                }
            }
            //For pour sauvegarder les NuageToxique
            for (int x = 0; x < monde.getListNuageToxique().size(); x++){
                ligne = getTexteSauvegarde(monde.getListNuageToxique().get(x), 3);
                if (ligne != null){
                    bufferedWriter.write(ligne);
                    bufferedWriter.newLine();
                }
            }
            
            //For pour sauvegarder les potions
            for (int x = 0; x < monde.getListPotions().size(); x++){
                ligne = getTexteSauvegarde(monde.getListPotions().get(x), 4);
                if (ligne != null){
                    bufferedWriter.write(ligne);
                    bufferedWriter.newLine();
                } 
            }
            
            //For pour sauvegarder les joueurs
            for (int x = 0; x < monde.getListJouer().size(); x++){
                ligne = getTexteSauvegarde(monde.getListJouer().get(x).getPerso(), 5);
                if (ligne != null){
                    bufferedWriter.write(ligne);
                    bufferedWriter.newLine();
                }
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
     * @param identifiant parametre qui permet de identifier l'element traité par groupes
     * @return la ligne contenant les informations d'un ElementDeJeu a etre sauvegarde dans le fichier
     */
    public String getTexteSauvegarde(ElementDeJeu el, int identifiant){
        String ligne = null;
        switch(identifiant){
            case 1: 
                if (el instanceof Guerrier){
                    Guerrier e = (Guerrier) el;
                    ligne = "Guerrier " + e.getNom() + " " + String.valueOf(e.getPtVie()) + " " + String.valueOf(e.getPtMana()) + " " + String.valueOf(e.getPourcentageAtt()) + " " + String.valueOf(e.getPourcentagePar()) + " " + String.valueOf(e.getPourcentageMag()) + " " + String.valueOf(e.getPourcentageResistMag()) + " " + String.valueOf(e.getDegAtt()) + String.valueOf(e.getDegMag()) + String.valueOf(e.getDistAttMax()) + " " + String.valueOf(e.getPtPar()) + " " + String.valueOf(e.getPos().getCoordX()) + " " + String.valueOf(e.getPos().getCoordY());
                }
                else if (el instanceof Paysan){
                    Paysan e = (Paysan) el;
                    ligne = "Paysan " + e.getNom() + " " + String.valueOf(e.getPtVie()) + " " + String.valueOf(e.getPtMana()) + " " + String.valueOf(e.getPourcentageAtt()) + " " + String.valueOf(e.getPourcentagePar()) + " " + String.valueOf(e.getPourcentageMag()) + " " + String.valueOf(e.getPourcentageResistMag()) + " " + String.valueOf(e.getDegAtt()) + String.valueOf(e.getDegMag()) + String.valueOf(e.getDistAttMax()) + " " + String.valueOf(e.getPtPar()) + " " + String.valueOf(e.getPos().getCoordX()) + " " + String.valueOf(e.getPos().getCoordY());
                }
                else if (el instanceof Mage){
                    Mage e = (Mage) el;
                    ligne = "Mage " + e.getNom() + " " + String.valueOf(e.getPtVie()) + " " + String.valueOf(e.getPtMana()) + " " + String.valueOf(e.getPourcentageAtt()) + " " + String.valueOf(e.getPourcentagePar()) + " " + String.valueOf(e.getPourcentageMag()) + " " + String.valueOf(e.getPourcentageResistMag()) + " " + String.valueOf(e.getDegAtt()) + String.valueOf(e.getDegMag()) + String.valueOf(e.getDistAttMax()) + " " + String.valueOf(e.getPtPar()) + " " + String.valueOf(e.getPos().getCoordX()) + " " + String.valueOf(e.getPos().getCoordY());
                }
                else if (el instanceof Archer){
                    Archer e = (Archer) el;
                    ligne = "Archer " + e.getNom() + " " + String.valueOf(e.getPtVie()) + " " + String.valueOf(e.getPtMana()) + " " + String.valueOf(e.getPourcentageAtt()) + " " + String.valueOf(e.getPourcentagePar()) + " " + String.valueOf(e.getPourcentageMag()) + " " + String.valueOf(e.getPourcentageResistMag()) + " " + String.valueOf(e.getDegAtt()) + String.valueOf(e.getDegMag()) + String.valueOf(e.getDistAttMax()) + " " + String.valueOf(e.getPtPar()) + " " + String.valueOf(e.getPos().getCoordX()) + " " + String.valueOf(e.getPos().getCoordY()) + " " + String.valueOf(e.getNbFleches());
                }
                break; 
            
            case 2:
                if (el instanceof Lapin){
                    Lapin l = (Lapin) el;
                    ligne = "Lapin " + String.valueOf(l.getPtVie()) + " " + String.valueOf(l.getPourcentageAtt())+ " " + String.valueOf(l.getPourcentagePar())+ " " + String.valueOf(l.getPtVie())+ " " + String.valueOf(l.getDegAtt())+ " " + String.valueOf(l.getPtPar())+ " " + String.valueOf(l.getPos().getCoordX())+ " " + String.valueOf(l.getPos().getCoordY());
                }
                else if (el instanceof Loup){
                    Loup l = (Loup) el;
                    ligne = "Loup " + String.valueOf(l.getPtVie()) + " " + String.valueOf(l.getPourcentageAtt())+ " " + String.valueOf(l.getPourcentagePar())+ " " + String.valueOf(l.getPtVie())+ " " + String.valueOf(l.getDegAtt())+ " " + String.valueOf(l.getPtPar())+ " " + String.valueOf(l.getPos().getCoordX())+ " " + String.valueOf(l.getPos().getCoordY());
                }
                break;
                
            case 3: if (el instanceof NuageToxique){
                    NuageToxique nt = (NuageToxique) el;
                    ligne = "NuageToxique " + String.valueOf(nt.getPtVie()) + " " + String.valueOf(nt.getPos().getCoordX()) + " " + String.valueOf(nt.getPos().getCoordY());
                }
                break;
                
            case 4: 
                if (el instanceof Mana){
                    Mana p = (Mana) el;
                    ligne = "Mana " + String.valueOf(p.getPointPotion()) + " " + String.valueOf(p.getPos().getCoordX()) + " " + String.valueOf(p.getPos().getCoordY());
                }
                else if (el instanceof Soin){
                    Soin p = (Soin) el;
                    ligne = "Soin " + String.valueOf(p.getPointPotion()) + " " + String.valueOf(p.getPos().getCoordX()) + " " + String.valueOf(p.getPos().getCoordY());
                }
                break; 
                            
            case 5:
                if (el instanceof Guerrier){
                    Guerrier e = (Guerrier) el;
                    ligne = "Joueur Guerrier " + e.getNom() + " " + String.valueOf(e.getPtVie()) + " " + String.valueOf(e.getPtMana()) + " " + String.valueOf(e.getPourcentageAtt()) + " " + String.valueOf(e.getPourcentagePar()) + " " + String.valueOf(e.getPourcentageMag()) + " " + String.valueOf(e.getPourcentageResistMag()) + " " + String.valueOf(e.getDegAtt()) + " " + String.valueOf(e.getDegMag()) + " " +  String.valueOf(e.getDistAttMax()) + " " + String.valueOf(e.getPtPar()) + " " + String.valueOf(e.getPos().getCoordX()) + " " + String.valueOf(e.getPos().getCoordY());
                }
                else if (el instanceof Paysan){
                    Paysan e = (Paysan) el;
                    ligne = "Joueur Paysan " + e.getNom() + " " + String.valueOf(e.getPtVie()) + " " + String.valueOf(e.getPtMana()) + " " + String.valueOf(e.getPourcentageAtt()) + " " + String.valueOf(e.getPourcentagePar()) + " " + String.valueOf(e.getPourcentageMag()) + " " + String.valueOf(e.getPourcentageResistMag()) + " " + String.valueOf(e.getDegAtt()) + " " +  String.valueOf(e.getDegMag()) + " " + String.valueOf(e.getDistAttMax()) + " " + String.valueOf(e.getPtPar()) + " " + String.valueOf(e.getPos().getCoordX()) + " " + String.valueOf(e.getPos().getCoordY());
                }
                else if (el instanceof Mage){
                    Mage e = (Mage) el;
                    ligne = "Joueur Mage " + e.getNom() + " " + String.valueOf(e.getPtVie()) + " " + String.valueOf(e.getPtMana()) + " " + String.valueOf(e.getPourcentageAtt()) + " " + String.valueOf(e.getPourcentagePar()) + " " + String.valueOf(e.getPourcentageMag()) + " " + String.valueOf(e.getPourcentageResistMag()) + " " + String.valueOf(e.getDegAtt()) + " " + String.valueOf(e.getDegMag()) + " " + String.valueOf(e.getDistAttMax()) + " " + String.valueOf(e.getPtPar()) + " " + String.valueOf(e.getPos().getCoordX()) + " " + String.valueOf(e.getPos().getCoordY());
                }
                else if (el instanceof Archer){
                    Archer e = (Archer) el;
                    ligne = "Joueur Archer " + e.getNom() + " " + String.valueOf(e.getPtVie()) + " " + String.valueOf(e.getPtMana()) + " " + String.valueOf(e.getPourcentageAtt()) + " " + String.valueOf(e.getPourcentagePar()) + " " + String.valueOf(e.getPourcentageMag()) + " " + String.valueOf(e.getPourcentageResistMag()) + " " + String.valueOf(e.getDegAtt()) + " " + String.valueOf(e.getDegMag()) + " " + String.valueOf(e.getDistAttMax()) + " " + String.valueOf(e.getPtPar()) + " " + String.valueOf(e.getPos().getCoordX()) + " " + String.valueOf(e.getPos().getCoordY()) + " " + String.valueOf(e.getNbFleches());
                }
                break; 
        }
        
        return ligne;
    }
    
    
}
