package lejeuloto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CarteLoto {
    private int tab[][];
    private int jetons[][];
    private int nbCol;
    private int nbLig;
    private int nbNumeros;
    private double prix;
    public final static int valMax = 90;

    public int getNbCol(){return this.nbCol;}
    public int getNbLig(){return this.nbLig;}
    public int getNbNumeros(){return this.nbNumeros;}
    public double getPrix(){return this.prix;}
    public int[][] getTab(){return tab;}
    public int[][] getJetons(){return jetons;}
    public int getValMax(){return valMax;}

    public void setNbCol(int n){nbCol = n;}
    public void setNbLig(int n){nbLig = n;}
    
    public void setNbNumeros(int n){
        if (n > nbCol*nbLig){
            nbNumeros = nbCol*nbLig;
        }
        else{
            if (n < 3){
                nbNumeros = 3;
            }
            else{
                nbNumeros = n;
            }
        }
    }
    public void setPrix(double prix){this.prix = prix;}
    public void setTab(int[][] tab){this.tab = tab;}
    public void setJetons(int[][] jetons){this.jetons = jetons;}
    
    public CarteLoto(){
        this.nbNumeros = 15;
        this.nbCol = 5;
        this.nbLig = 3;
        this.tab = new int[nbLig][nbCol];
        this.jetons = new int[nbLig][nbCol];
        this.prix = 5;
        initValeurs();
        initValeursCarte();
    }

    public CarteLoto(int nbc, int nbVal){
        this.nbNumeros = nbVal;
        this.nbCol = nbc;
        this.nbLig = 3;
        this.tab = new int[nbLig][nbCol];
        this.jetons = new int[nbLig][nbCol];
        this.prix = 5;
        initValeurs();
        initValeursCarte();
    }

    public String toString(){
        String res = "";
        for (int i = 0; i < nbLig; i++){
            for (int j = 0; j < nbCol; j++){
                if (tab[i][j] < 10){
                    res += "  "+tab[i][j];
                }
                else{
                    res += " "+tab[i][j];
                }
            }
            res+="\n";
        }
        return res;
    }

    public String jetonsToString(){
        String res = "";
        for (int i = 0; i < nbLig; i++){
            for (int j = 0; j < nbCol; j++){
                if (jetons[i][j] < 10){
                    res += "  "+jetons[i][j];
                }
                else{
                    res += " "+jetons[i][j];
                }
            }
            res+="\n";
        }
        return res;
    }
    
    public void initValeurs(){
        for (int i = 0; i < nbLig; i++){
            for( int j = 0; j < nbCol; j++){
                tab[i][j] = 0;
                jetons[i][j] = 0;
            }
        }
    }
    
    public boolean estDans(int val, int mode){
        //mode = 0: utilise la methode pour initialiser les valeurs de la carte
        //mode = 1: utuilise la methode pour rechercher la présence d'un numéro
        boolean found = false;
        int i = 0;
        while (found == false && i < this.nbLig){
            int j = 0;
            while (found == false && j < this.nbCol){
                if (tab[i][j] == val){
                    found = true;
                    if (mode == 1){
                        jetons[i][j] = 1;
                    }
                }
                j++;
            }
            i++;
        }
        return found;
    }
    
   public void initValeursCarte(){
       
       int nb = 0;
       
       while (nb < nbNumeros){
            int x = (int)(nbLig*Math.random());
            int y = (int)(nbCol*Math.random());
            int value = (int)(1+(valMax-1)*Math.random());

           if (tab[x][y] == 0){
                if (!estDans(value, 0)){
                    tab[x][y] = value;
                    nb++;
                }
           }
       }
   }
   
   public boolean estLignePleine(int lig){
       boolean res = true;
       for (int j = 0; j < this.nbCol; j++){
           if (tab[lig][j] != 0){
               if (jetons[lig][j] == 0){
                   res = false;
               }
           }
       }
       return res;
   }
   
   public int getNbLignesPleines(){
       int output = 0;
       for (int i = 0; i < nbLig; i++){
           if (estLignePleine(i)){
               output++;
           }
       }
       return output;
   }
   
   public boolean estCartonGagnant(int option){
       boolean res = false;
       switch(option){
           case 1:
               res = getNbLignesPleines() == 1 ? true : false;
               break;
           case 2:
               res = getNbLignesPleines() == 2 ? true : false;
               break;
           case 3:
               res = getNbLignesPleines() == 3 ? true : false;
               break;
       }
       return res;
   }
   
   public void dessineCarte(JPanel jp, Color c){
       jp.removeAll();
       jp.setLayout(new GridLayout(nbLig, nbCol));
       for (int i = 0; i < nbLig; i++){
           for (int j = 0; j < nbCol; j++){
                JButton jb = new JButton();
                jb.setPreferredSize(new Dimension(100, 50));
                if (tab[i][j] != 0){
                    jb.setText(""+tab[i][j]);
                }
                if (jetons[i][j] == 0 && tab[i][j] != 0){
                     jb.setBackground(c);
                }
                jp.add(jb);
           }
       }
   }
}
