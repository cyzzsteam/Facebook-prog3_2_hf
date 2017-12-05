/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adatkezeles;

import alaposztalyok.Felhasznalo;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author varga
 */
public class AdatbazisInput implements AdatInput{
    private Connection kapcsolat;
    
    @Override
    public List<Felhasznalo> felhasznaloLista() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
