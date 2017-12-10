/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alaposztalyok;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import vezerles.Global;

/**
 *
 * @author varga
 */
public class Felhasznalo {

    private String nev;
    private int x;
    private int y;
    private Color szin;
    private int csoport;

    private final int meret = Global.MERET;
    private boolean kijeloltek = false;

    private Image kijeloltKep;
    private String kepEleres;

    public Felhasznalo(String nev, int x, int y, int csoport) {
        this.nev = nev;
        this.x = x;
        this.y = y;
        szin = szinGeneralas();
        this.csoport = csoport;
        csoportRendel();
    }

    public String getNev() {
        return nev;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getSzin() {
        return szin;
    }

    public int getCsoport() {
        return csoport;
    }

    public int getMeret() {
        return meret;
    }

    private Color szinGeneralas() {
        int r, g, b;
        r = (int) (Math.random() * 256);
        g = (int) (Math.random() * 256);
        b = (int) (Math.random() * 256);

        return new Color(r, g, b);
    }

    @Override
    public String toString() {
        return nev;
    }

    public void rajzolas(Graphics g) {
        g.setColor(szin);
        g.fillOval(x, y, meret, meret);
    }

    public boolean isKijeloltek() {
        return kijeloltek;
    }

    public Image getKijeloltKep() {
        return kijeloltKep;
    }

    public boolean talalatKeres(int x, int y) {
        if (this.getX() <= x && x <= this.getX() + Global.MERET
                && this.getY() <= y && y <= this.getY() + Global.MERET) {

            kijeloltek = true;
            return true;
        } else {
            kijeloltek = false;
            return false;
        }
    }
   

    private void csoportRendel() {
        switch (csoport) {
            case 1:
                kepEleres = Global.KEKBULLET_ELERES;
                break;
            case 2:
                kepEleres = Global.SARGABULLET_ELERES;
                break;
            case 3:
                kepEleres = Global.PIROSBULLET_ELERES;
                break;
        }
        kijeloltKep = new ImageIcon(this.getClass().getResource(kepEleres)).getImage();
    }


}
