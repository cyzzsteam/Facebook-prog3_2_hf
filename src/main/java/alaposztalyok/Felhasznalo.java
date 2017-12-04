/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alaposztalyok;

import java.awt.Color;
import java.awt.Graphics;

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

    public Felhasznalo(String nev, int x, int y, int csoport) {
        this.nev = nev;
        this.x = x;
        this.y = y;
        szin = szinGeneralas();
        this.csoport = csoport;
    }

    private Color szinGeneralas() {
        int r, g, b;
        r = (int) (Math.random() * 256);
        g = (int) (Math.random() * 256);
        b = (int) (Math.random() * 256);

        return new Color(r, g, b);
    }

    public void rajzolas(Graphics g) {
        g.setColor(szin);
        g.drawOval(x, y, 5, 5);
    }

}
