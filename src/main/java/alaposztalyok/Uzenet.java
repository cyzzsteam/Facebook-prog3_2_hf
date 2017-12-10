/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alaposztalyok;

import java.awt.Graphics;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import vezerles.Global;
import vezerles.Vezerlo;

/**
 *
 * @author varga
 */
public class Uzenet extends Thread{
    
    private static Vezerlo vezerlo;
    
    private int x;
    private int y;
    private int celx;
    private int cely;
    private int dx;
    private int dy;
    
    private static int varakozasiIdo=Global.IDO;
    private Image kep;
    private int sebesseg;
    private boolean celbaErt=false;
    

    
    @Override
    public void run() {
        while(!celbaErt){
            mozdul();
            frissit();
            varakozik();
            celVizsgalat();
        }
       
    }
    
    
    
    public Uzenet(int x, int y, int celx, int cely, int sebesseg,Image kep) {
        this.x = x;
        this.y = y;
        this.celx = celx;
        this.cely = cely;
        this.sebesseg=sebesseg;
        this.kep=kep;
        
        mozgasBeallitas();
        
    }

    private void frissit() {
        vezerlo.frissit();
    }

    public static void setVezerlo(Vezerlo vezerlo) {
        Uzenet.vezerlo = vezerlo;
    }

    private void varakozik(){
        try {
            Thread.sleep(varakozasiIdo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Uzenet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rajzol(Graphics g) {
        g.drawImage(kep, x, y, 10, 10, null);
    }

    private void mozdul() {
        x+=dx;
        y+=dy;
    }

    private void mozgasBeallitas() {
        if(x<celx){
        dx=(celx-x)/sebesseg;
        }else{
        dx=-((x-celx)/sebesseg);
        }
        
        if(y<cely){
        dy=(cely-y)/sebesseg;
        }else{
        dy=-((y-cely)/sebesseg);
        }
    }

    private void celVizsgalat() {
        if(dx<=0&&dy<=0&&x<=celx&&y<=cely||dx<=0&&dy>=0&&x<=celx&&y>=cely||dx>=0&&dy<=0&&x>=celx&&y<=cely||dx>=0&&dy>=0&&x>=celx&&y>=cely){
        celbaErt=true;
        vezerlo.torol(this);
        }
        
        
        
        
    }

    
    
    
}
