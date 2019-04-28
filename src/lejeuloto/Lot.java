/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lejeuloto;

import javax.swing.ImageIcon;

/**
 *
 * @author yannt
 */
public class Lot {
    private String descriptif;
    private int niveau;
    private String type;
    private ImageIcon icone; //variable définie si c'est un objet
    private int valeur; // variable définie si c'est un bon cadeau

    public Lot(String descriptif, int niveau, String type, ImageIcon icone, int valeur) {
        this.descriptif = descriptif;
        this.niveau = niveau;
        this.type = type;
        if (this.type == "Objet"){
            this.icone = icone;
            this.valeur = 0;
        }
        else{
            if (this.type == "Bon cadeau"){
                this.icone = null;
                this.valeur = valeur;
            }
        }
    }
    
    public Lot(){
        descriptif = null;
        niveau = 0;
        type = null;
        icone = null;
        valeur = 0;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ImageIcon getIcone() {
        return icone;
    }

    public void setIcone(ImageIcon icone) {
        this.icone = icone;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "Lot{" + "descriptif=" + descriptif + ", niveau=" + niveau + ", type=" + type + ", icone=" + icone + ", valeur=" + valeur + '}';
    }
    
    
}
