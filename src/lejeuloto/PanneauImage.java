/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lejeuloto;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author yannt
 */
public class PanneauImage extends JPanel{
    private Image img;
    public PanneauImage(){
        super();
        this.img = null;
    }
    public PanneauImage(Image im){
        super();
        this.img = im;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
        this.repaint();
    }
    
    /*@Override
    public void paint(Graphics g){
        super.paint(g);
        if (img != null){
            g.drawImage(img, 0, 0,null);
        }
    }*/
    
    @Override
    public void paintComponent(Graphics g){
        System.out.println("paint");
        super.paintComponent(g);
        if (img != null){
            g.drawImage(img, 0, 0,null);
        }
    }

    @Override
    public String toString() {
        return "PanneauImage{" + "img=" + img + '}';
    }
    
    
}
