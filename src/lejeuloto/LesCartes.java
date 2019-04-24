/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lejeuloto;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author yann
 */
public class LesCartes {
    private ArrayList<CarteLoto> al;
    private final int nbCartesMax = 2;
    
    public LesCartes(){
        al = new ArrayList<CarteLoto>();
    }
    
    public int getTaille(){ return al.size();}
    
    public CarteLoto getCarte(int i){
        if (i >= 0 && i < al.size()){
            return al.get(i); 
        }else{
            return null;
        }
    }
    
    public void ajouteCarte(CarteLoto c){ 
        if(al.size() < nbCartesMax){
            al.add(c);
        }
    }
    
    public void retireCarte(CarteLoto c){ al.remove(al.indexOf(c)); }
    
    public void retireCartes(){ al.clear();}
    
    public void initLesCartes(int n, int nbcol, int nbval){
        if (n > 0 && nbcol > 0 && nbval > 0){
            for(int i = 0; i < n; i++){
                al.add(new CarteLoto(nbcol, nbval));
            }
        }
    }
    
    public LesCartes rechCartes(int num){
        LesCartes lc = new LesCartes();
        for (int i = 0; i < al.size(); i++){
            CarteLoto c = al.get(i);
            if (c.estDans(num, 1) == true){
                lc.ajouteCarte(c);
            }
        }
        return lc;
    }
}
