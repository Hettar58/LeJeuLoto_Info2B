/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lejeuloto;

import java.util.ArrayList;

/**
 *
 * @author yann
 */
public class LesJoueurs {
    private ArrayList<Joueur> al;
    
    public LesJoueurs(){
        al = new ArrayList<Joueur>();
    }
    
    public Joueur getJoueur(int i){ 
        if (i < al.size()){
            return al.get(i);
        }else{
            return null;
        }    
    }
    
    public int getNbJoueur(){return al.size();}
    
    public void ajouteJoueur(Joueur j){
        if (j != null){
            al.add(j);
        }
    }
    
    public void supprimeJoueur(Joueur j){al.remove(j);}
    
    public Joueur rechJoueur(String ps){
        Joueur res = null;
        for (int i = 0; i < al.size(); i++){
            if (al.get(i).getPseudo().equals(ps)){
                res = al.get(i);
            }
        }
        return res;
    }
    
    public String toString(){
        String res = "";
        for (int i = 0; i < al.size(); i++){
            res += al.get(i).toString()+"\n";
        }
        return res;
    }
}
