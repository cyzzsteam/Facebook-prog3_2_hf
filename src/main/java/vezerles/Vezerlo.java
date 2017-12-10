/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vezerles;

import adatkezeles.AdatInput;
import adatkezeles.FajlInput;
import alaposztalyok.Felhasznalo;
import alaposztalyok.Uzenet;
import feluletek.FejlecPanel;
import feluletek.FelhasznalokPanel;
import feluletek.KozossegiPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author varga
 */
public class Vezerlo {

    private KozossegiPanel kozossegiPanel;
    private FelhasznalokPanel felhasznalokPanel;
    private FejlecPanel fejlecPanel;

    private List<Uzenet> uzenetek=new CopyOnWriteArrayList<>();
    
    private final String fajlEleres = Global.ADATFAJL_ELERES;
    private List<Felhasznalo> felhasznalok = new ArrayList<>();
    private Felhasznalo celpont;
    private Felhasznalo kijelolt;
    
    private List<Felhasznalo> ismerosLista=new ArrayList<>();

    public Vezerlo(KozossegiPanel kozossegiPanel, FelhasznalokPanel felhasznalokPanel, FejlecPanel fejlecPanel) {
        this.kozossegiPanel = kozossegiPanel;
        this.felhasznalokPanel = felhasznalokPanel;
        this.fejlecPanel = fejlecPanel;
    }

    void start() {
        beallitas();
        adatbeolvasas();
        kozossegiPanel.setFelhasznaloLista(felhasznalok);
        felhasznalokPanel.kiir(felhasznalok);
    }

    private void adatbeolvasas() {
        AdatInput ai = new FajlInput(fajlEleres);
        try {
            felhasznalok = ai.felhasznaloLista();
        } catch (Exception ex) {
            Logger.getLogger(Vezerlo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pozicioKeres(int x, int y) {
        for (Felhasznalo felhasznalo : felhasznalok) {
            if (felhasznalo.talalatKeres(x, y)) {
                celpont=felhasznalo;
                ismerosLista();
            }
        }
    }

    public void felhasznaloRajzolas(Felhasznalo felhasznalo, Graphics g) {
        felhasznalo.rajzolas(g);
    }
    
    public void uzenetRajzolas(Graphics g){
        if(uzenetek!=null){
        for (Uzenet uzenet : uzenetek) {
            uzenet.rajzol(g);
        }}
    }

    private void beallitas() {
        kozossegiPanel.setVezerlo(this);
        felhasznalokPanel.setVezerlo(this);
        fejlecPanel.setVezerlo(this);
        Uzenet.setVezerlo(this);
    }

    
    //A listábol való kiválasztás.
    public void kivallaszt(Felhasznalo selectedValue) {
        celpont = selectedValue;
    }

    
    //A szövegmezős kereséses kiválasztás
    public boolean keres(String text) {
        boolean temp = false;
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(fejlecPanel, "Üres mező");
        } else {
            for (Felhasznalo felhasznalo : felhasznalok) {
                if (felhasznalo.getNev().contentEquals(text)) {
                    celpont=felhasznalo;
                    temp = true;
                }
            }
            if (!temp) {
                JOptionPane.showMessageDialog(fejlecPanel, "Nincs a keresésnek megfelelő ember");
            }
        }
        kozossegiPanel.repaint();
        return temp;
    }

    public void ismerosLista() {
        ismerosLista.clear();
        int csoport;
        if(celpont==null){
        csoport=0;
        }else{
            csoport=celpont.getCsoport();
        }
        for (Felhasznalo felhasznalo : felhasznalok) {
            if(csoport==felhasznalo.getCsoport()&&!felhasznalo.equals(celpont)){
                ismerosLista.add(felhasznalo);
            }
        }
        felhasznalokPanel.ismerosListabaIr(ismerosLista);

    }

    public void szemelyesUzenet(Felhasznalo selectedValue) {
       uzenetKuldes(celpont,kijelolt);
       uzenetKuldes(kijelolt,celpont);
    }

    public void koruzenet() {
        for (Felhasznalo felhasznalo : ismerosLista) {
            uzenetKuldes(celpont,felhasznalo);
        }
    }

    public void frissit() {
        kozossegiPanel.repaint();
    }

    public void kivallasztottba(Felhasznalo temp) {
        kijelolt=temp;
    }

    private void uzenetKuldes(Felhasznalo kozeppont, Felhasznalo cel) {
    Image kep;
    if(Math.random()<0.5){
    kep=new ImageIcon(this.getClass().getResource(Global.NULLAELERES)).getImage();}else{
    kep=new ImageIcon(this.getClass().getResource(Global.EGYELERES)).getImage();}
    
    Uzenet uzenet=new Uzenet(kozeppont.getX(), kozeppont.getY(),cel.getX(), cel.getY(),Global.SEBESSEG,kep);
    uzenet.start();
    uzenetek.add(uzenet);
    }

    public void torol(Uzenet aThis) {
        for (Uzenet uzenet : uzenetek) {
            if(uzenet.equals(aThis)){
            uzenetek.remove(uzenet);
            uzenet=null;
            }
        }
        
      
    }

}
