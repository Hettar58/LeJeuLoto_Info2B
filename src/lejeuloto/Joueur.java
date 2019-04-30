package lejeuloto;


import java.awt.Color;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yt646712
 */
public class Joueur{
    private String pseudo;
    private Color couleur;
    private double solde;
    private ImageIcon photo;
    private LesCartes mesCartes;
    private LesLots mesLots;
    
    public String getPseudo() { return this.pseudo;  }
    public Color getCouleur() { return this.couleur; }
    public double getSolde() { return this.solde; }
    public ImageIcon getPhoto() { return this.photo;}
    public void setPseudo(String p) { this.pseudo=p; }
    public void setCouleur(Color c) { this.couleur = c; }
    public void setPhoto(ImageIcon p) { this.photo = p; }
    public void setSolde(double s) { this.solde = s; }
    public LesCartes getMesCartes() {
        return mesCartes;
    }
    public void setMesLots(LesLots ll){this.mesLots = ll;}
    public LesLots getMesLots(){return this.mesLots;}
    
    public Joueur() {
        this.mesCartes = new LesCartes();
        this.mesLots = new LesLots();
        this.pseudo = "";
        this.couleur=Color.gray;
        this.solde = 20;
        this.photo = new ImageIcon(getClass().getResource("joueurDefaut.png")); 
    }
    public Joueur(String p) {
        this.mesCartes = new LesCartes();
        this.mesLots = new LesLots();
        this.pseudo = p;
        this.couleur=Color.gray;
        this.solde = 20;
        this.photo = new ImageIcon(getClass().getResource("joueurDefaut.png"));
    }
    
    public String toString() {
        String res= "\nJoueur " + this.pseudo;res+= "\nCouleur " + this.couleur;res+= "\nSolde " + this.solde;res+= "\nCartes" + this.mesCartes.toString();res+= "\nLots"+this.mesLots.toString();
        return res;
    }  
    
    public boolean acheter(CarteLoto c){
        if (this.solde - c.getPrix() >= 0){
            mesCartes.ajouteCarte(c);
            this.solde -= c.getPrix();
            return true;
        }
        else{
            return false;
        }
    }
}