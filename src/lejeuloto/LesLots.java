/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lejeuloto;

import java.util.ArrayList;

/**
 *
 * @author yannt
 */
public class LesLots {
    private ArrayList<Lot> al;
    
    public LesLots(){
        this.al = new ArrayList<Lot>();
    }
    
    public int getTaille(){ return al.size();}
    
    public Lot getLot(int index){
        if (index >= 0 && index < al.size()){
            return al.get(index);
        }
        else{
            return null;
        }
    }
    
    public void ajouteLot(Lot l){
        al.add(l);
    }
    
    public void retireLot(Lot l){ al.remove(al.indexOf(l)); }
    public void retireLot(int index){al.remove(index);}
    
    public String toString(){
        String res = "";
        if (al.size() > 0){
            res += "Lots: ";
            for (int i = 0; i < al.size(); i++){
                res += "\n" + al.get(i).toString();
            }
        }
        else{
            res = "Aucun lot obtenu";
        }
        return res;
    }
}
