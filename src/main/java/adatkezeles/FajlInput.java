/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adatkezeles;

import alaposztalyok.Felhasznalo;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author varga
 */
public class FajlInput implements AdatInput{
    private String fajlEleres;

    public FajlInput(String fajlEleres) {
        this.fajlEleres = fajlEleres;
    }

    @Override
    public List<Felhasznalo> felhasznaloLista() throws Exception {
        List<Felhasznalo> felhasznalok=new ArrayList<>();
        
        return felhasznalok;
    }
    
}
