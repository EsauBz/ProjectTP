/**
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
public class Nourriture extends Objet {
    
    // variable qui contient le type de Nourriture (Malus ou Bonus)   
    private String type;
    
    //variable qui contient le nombre de tourDeJeu qui l'effet dure
    private int duree;
    
    //variable qui contient la valeur du Malus ou Bonus 
    private int valeur;
    
    //variable qui contient le nom de la caracteristique a etre modifie
    private String caract;
    
    /**
     * 
     * Constructeur default sans parametres 
     * Initialisation des variables en 0
     * 
     */
    public Nourriture(){
        super();
        this.type = "";
        this.duree = 0;
        this.caract = "";
        this.valeur = 0;
    }
    
    /**
     * 
     * Constructeur default avec 1 parametres 
     * 
     * 
     * @param n (class Nourriture)
     */
    public Nourriture (Nourriture n){
        super();
        this.duree = n.getDuree();
        this.caract = n.getCaract();
        this.valeur = n.getValeur();
        this.type = n.getType();
    }
    
    /**
     * 
     * Constructeur avec des parametres 
     * 
     * @param pos qui contient la position de la nourriture
     * @param duration duree de l'effet du Bonus/Malus
     * @param value valeur de l'augmentation ou reduction de la caracteristique
     * @param type definit si c'est un Bonus ou Malus
     * @param caract caracteristique du Personnage qui va etre modifie
     */
    public Nourriture (Point2D pos, int duration, int value, String type, String caract){
        super(pos);
        this.duree = duration;
        this.caract = caract;
        this.valeur = value;
        this.type = type;
    }
    
    //getter de la variable valeur
    public int getValeur(){
        return this.valeur;
    }
    
    //getter de la variable duree
    public int getDuree(){
        return this.duree;
    }
    
    //getter de la variable caract
    public String getCaract(){
        return this.caract;
    }
    
    //getter de la variable type
    public String getType(){
        return this.type;
    }
    
    //setter de la variable valeur
    public void setValeur(int value){
        this.valeur = value;
    }
    
    //setter de la variable duree
    public void setDuree(int duration){
        this.duree = duration;
    }
    
    //setter de la variable caract
    public void setCaract(String caracteristique){
        this.caract = caracteristique;
    }
    
    //setter de la variable type
    public void setType(String type){
        this.type = type;
    }
}
