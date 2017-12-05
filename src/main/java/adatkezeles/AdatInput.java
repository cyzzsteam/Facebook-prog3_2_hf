/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adatkezeles;

import alaposztalyok.Felhasznalo;
import java.util.List;

/**
 *
 * @author varga
 */
public interface AdatInput {
    public List<Felhasznalo> felhasznaloLista()throws Exception;
}
